package com.macgregor.ef.dataload;

import com.macgregor.ef.dataload.annotations.Translate;
import com.macgregor.ef.exceptions.TranslationException;
import com.macgregor.ef.model.Translation;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FieldTranslator {
    private static final Logger logger = LoggerFactory.getLogger(FieldTranslator.class);
    private SessionFactory sessionFactory;


    public FieldTranslator(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public Object translate(Object obj) throws TranslationException {
        logger.debug(String.format("Beginning translation of %s[%s]", obj.getClass(), obj.hashCode()));
        List<Field> fieldsToTranslate = FieldUtils.getFieldsListWithAnnotation(obj.getClass(), Translate.class);
        for(Field f : fieldsToTranslate) {
            String processedKey = "";
            try {
                processedKey = getFieldKey(obj, f);
                Translation translation = findTranslation(processedKey);
                if(!StringUtils.isBlank(translation.getValue())) {
                    FieldUtils.writeField(f, obj, translation.getValue(), true);
                } else {
                    logger.warn(String.format("Translation for %s found but blank, not overriding",processedKey));
                }
            } catch (TranslationException | IllegalAccessException e){
                logger.warn(e.getMessage());
            } catch (NullPointerException e){
                logger.warn(String.format("Translation for key %s not found in database", processedKey));
            }
        }
        return obj;
    }

    public String getFieldKey(Object obj, Field f) throws TranslationException {
        Translate translateAnnotation = f.getAnnotation(Translate.class);
        String translationKey = translateAnnotation.key();

        logger.debug(String.format("Processing translation key for field %s - raw key %s", f.getName(), translationKey));

        String processedKey = getFieldKey(obj, translationKey);

        logger.debug(String.format("Processing translation key for field %s - processed key %s", f.getName(), processedKey));

        return processedKey;
    }

    public String getFieldKey(Object obj, String key) throws TranslationException {
        String processedKey = key;

        Pattern fieldPattern = Pattern.compile(".*?(\\{(.*?)\\}).*?");
        Matcher fieldMatcher = fieldPattern.matcher(key);
        while (fieldMatcher.find()) {
            String fieldReference = fieldMatcher.group(2);
            Field f = FieldUtils.getField(obj.getClass(), fieldReference, true);
            if(f == null){
                throw new TranslationException(String.format("Invalid field reference in Translate annotation: raw key: %s, unknown field reference: %s", key, fieldReference));
            }

            try {
                String lookup = FieldUtils.readField(f, obj, true).toString();
                processedKey = processedKey.replace(fieldMatcher.group(1), lookup);
            } catch (IllegalAccessException e) {
                throw new TranslationException(String.format("Unexpected error reading field %s, this probably shouldnt ever happen", fieldReference), e);
            } catch (NullPointerException e) {
                throw new TranslationException(String.format("Error reading field %s, value is probably null", fieldReference), e);
            }

        }
        return processedKey;
    }

    public Translation findTranslation(String id){
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Translation t = session.get(Translation.class, id);
        tx.commit();
        session.close();
        return t;
    }
}
