package com.macgregor.ef.dataload.converters;

import com.macgregor.ef.dataload.annotations.ConvertList;
import com.macgregor.ef.exceptions.CanonicalConversionException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ListFieldConverter extends AbstractFieldConverter<ConvertList> {
    private static final Logger logger = LoggerFactory.getLogger(ListFieldConverter.class);

    public ListFieldConverter(){
        super(ConvertList.class);
    }

    @Override
    public Object convertField(Object obj, Field f) throws CanonicalConversionException {
        logger.debug(String.format("[%s %010d] - converting field %s to list", obj.getClass().getSimpleName(), System.identityHashCode(obj), f.getName()));
        ConvertList annotation = f.getAnnotation(ConvertList.class);
        Class<?> elementType = annotation.elementType();
        String sep = annotation.sep();
        List<Object> parsedElements = new ArrayList<>();

        try {
            String fieldValue = (String)FieldUtils.readField(f, obj, true);
            if(fieldValue == null){
                throw new CanonicalConversionException(String.format("[%s %010d] - cannot convert null to boolean value", obj.getClass().getSimpleName(), System.identityHashCode(obj)));
            }

            for(String rawElement : StringUtils.split(fieldValue, sep)){
                parsedElements.add(toObject(elementType, rawElement.trim()));
            }
        } catch (IllegalAccessException e) {
            throw new CanonicalConversionException(String.format("[%s %010d] - Unexpected error reading field %s, this probably shouldnt ever happen", obj.getClass().getSimpleName(), System.identityHashCode(obj), f.getName()), e);
        }

        return parsedElements;
    }

    public static Object toObject( Class clazz, String value ) {
        if( Boolean.class == clazz ) return Boolean.parseBoolean( value );
        if( Byte.class == clazz ) return Byte.parseByte( value );
        if( Short.class == clazz ) return Short.parseShort( value );
        if( Integer.class == clazz ) return Integer.parseInt( value );
        if( Long.class == clazz ) return Long.parseLong( value );
        if( Float.class == clazz ) return Float.parseFloat( value );
        if( Double.class == clazz ) return Double.parseDouble( value );
        return value;
    }
}
