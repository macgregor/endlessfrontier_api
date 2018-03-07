package com.macgregor.ef.dataload.converters;

import com.macgregor.ef.dataload.annotations.CanonicalField;
import com.macgregor.ef.dataload.annotations.CanonicalModel;
import com.macgregor.ef.exceptions.CanonicalConversionException;
import org.apache.commons.lang3.reflect.ConstructorUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class CanonicalModelConverter {
    private static final Logger logger = LoggerFactory.getLogger(CanonicalModelConverter.class);

    private List<AbstractFieldConverter> fieldConverters;

    public CanonicalModelConverter(){
        this.fieldConverters = new ArrayList<>();
    }

    public CanonicalModelConverter(List<AbstractFieldConverter> fieldConverters){
        this.fieldConverters = fieldConverters;
    }


    public Object convert(Object source) throws CanonicalConversionException {
        logger.debug(String.format("[%s %010d] - Beginning conversion to canonical model", source.getClass().getSimpleName(), System.identityHashCode(source)));

        Object dest = constructEmptyCanonicalModel(source);

        List<Field> fieldsToTranslate = FieldUtils.getFieldsListWithAnnotation(source.getClass(), CanonicalField.class);
        for(Field f : fieldsToTranslate) {
            String mapsToCanonicalField = getCanonicalFieldMapping(source, f);
            Object convertedField = convertField(source, f);
            try {
                FieldUtils.writeField(dest, mapsToCanonicalField, convertedField, true );
            } catch (IllegalAccessException e) {
                throw new CanonicalConversionException(String.format("[%s %010d] - Fatal error writing field %s to canonical model %s field %s", source.getClass().getSimpleName(), System.identityHashCode(source), f.getName(), dest.getClass().getSimpleName(), mapsToCanonicalField), e);
            }
        }

        logger.debug(String.format("[%s %010d] - Finished conversion to canonical model", source.getClass().getSimpleName(), System.identityHashCode(source)));

        return dest;
    }

    public Object constructEmptyCanonicalModel(Object source) throws CanonicalConversionException {
        CanonicalModel annotation = source.getClass().getAnnotation(CanonicalModel.class);
        try {
            logger.debug(String.format("[%s %010d] - Instantiating %s", source.getClass().getSimpleName(), System.identityHashCode(source), annotation.type()));
            return ConstructorUtils.invokeConstructor(annotation.type());
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            String destModelName = annotation.getClass().getSimpleName();
            throw new CanonicalConversionException(String.format("[%s %010d] - Fatal error instantiating canonical model %s. Be sure default constructor exists for %s", source.getClass().getSimpleName(), System.identityHashCode(source), destModelName, destModelName), e);
        }
    }

    public String getCanonicalFieldMapping(Object source, Field f){
        CanonicalField canonicalField = f.getAnnotation(CanonicalField.class);
        String mapsToCanonicalField = f.getName();
        if(!canonicalField.mapsTo().equals(CanonicalField.MAPS_TO_DEFAULT)){
            mapsToCanonicalField = canonicalField.mapsTo();
        }

        logger.debug(String.format("[%s %010d] - Source field %s maps to canonical field %s", source.getClass().getSimpleName(), System.identityHashCode(source), f.getName(), mapsToCanonicalField));
        return mapsToCanonicalField;
    }

    public Object convertField(Object source, Field f) throws CanonicalConversionException {
        for(AbstractFieldConverter converter : fieldConverters){
            if(converter.canConvert(f)){
                try {
                    Object convertedField = converter.convertField(source, f);
                    logger.debug(String.format("[%s %010d] - converted field %s to %s", source.getClass().getSimpleName(), System.identityHashCode(source), f.getName(), convertedField.toString()));
                    return convertedField;
                } catch (CanonicalConversionException e){
                    logger.error(String.format("[%s %010d] - converter failed to convert field %s", source.getClass().getSimpleName(), System.identityHashCode(source), f.getName()), e);
                }
            }
        }
        try {
            logger.debug(String.format("[%s %010d] - no converter for field %s, returning source value", source.getClass().getSimpleName(), System.identityHashCode(source), f.getName()));
            return FieldUtils.readField(f, source, true);
        } catch (IllegalAccessException e) {
            throw new CanonicalConversionException(String.format("[%s %010d] - Failed to do just about everything with field %s", source.getClass().getSimpleName(), System.identityHashCode(source), f.getName()), e);
        }
    }
}
