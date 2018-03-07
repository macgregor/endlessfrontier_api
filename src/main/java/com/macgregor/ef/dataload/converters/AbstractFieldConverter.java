package com.macgregor.ef.dataload.converters;

import com.macgregor.ef.exceptions.CanonicalConversionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public abstract class AbstractFieldConverter<T extends Annotation> {
    private static final Logger logger = LoggerFactory.getLogger(AbstractFieldConverter.class);

    protected Class<T> fieldAnnotationType;

    public AbstractFieldConverter(Class<T> fieldAnnotationType){
        this.fieldAnnotationType = fieldAnnotationType;
    }

    public abstract Object convertField(Object obj, Field f) throws CanonicalConversionException;

    public boolean canConvert(Field f){
        return f.getAnnotation(fieldAnnotationType) != null;
    }
}
