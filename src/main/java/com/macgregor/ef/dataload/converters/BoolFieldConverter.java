package com.macgregor.ef.dataload.converters;

import com.macgregor.ef.dataload.annotations.ConvertBool;
import com.macgregor.ef.exceptions.CanonicalConversionException;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

public class BoolFieldConverter extends AbstractFieldConverter<ConvertBool> {
    private static final Logger logger = LoggerFactory.getLogger(BoolFieldConverter.class);

    public BoolFieldConverter(){
        super(ConvertBool.class);
    }

    @Override
    public Object convertField(Object obj, Field f) throws CanonicalConversionException {
        logger.debug(String.format("[%s %010d] - converting field %s to boolean", obj.getClass().getSimpleName(), System.identityHashCode(obj), f.getName()));
        ConvertBool annotation = f.getAnnotation(ConvertBool.class);
        try {
            Object fieldValue =  FieldUtils.readField(f, obj, true);
            if(fieldValue == null){
                throw new CanonicalConversionException(String.format("[%s %010d] - cannot convert null to boolean value", obj.getClass().getSimpleName(), System.identityHashCode(obj)));
            }

            String stringBool = fieldValue.toString().toLowerCase();

            try {
                if (annotation.kind() == ConvertBool.Kind.BINARY) {
                    return BooleanUtils.toBoolean(stringBool, "1", "0");
                } else if (annotation.kind() == ConvertBool.Kind.TRUE_FALSE) {
                    return BooleanUtils.toBoolean(stringBool, "true", "false");
                } else if (annotation.kind() == ConvertBool.Kind.T_F) {
                    return BooleanUtils.toBoolean(stringBool, "t", "f");
                } else if (annotation.kind() == ConvertBool.Kind.YES_NO) {
                    return BooleanUtils.toBoolean(stringBool, "yes", "no");
                } else if (annotation.kind() == ConvertBool.Kind.Y_N) {
                    return BooleanUtils.toBoolean(stringBool, "y", "n");
                } else {
                    throw new CanonicalConversionException(String.format("[%s %010d] - dont know how to convert this boolean %s", obj.getClass().getSimpleName(), System.identityHashCode(obj), stringBool));
                }
            } catch (IllegalArgumentException e){
                throw new CanonicalConversionException(String.format("[%s %010d] - dont know how to convert this boolean %s", obj.getClass().getSimpleName(), System.identityHashCode(obj), stringBool));
            }
        } catch (IllegalAccessException e) {
            throw new CanonicalConversionException(String.format("[%s %010d] - Unexpected error reading field %s, this probably shouldnt ever happen", obj.getClass().getSimpleName(), System.identityHashCode(obj), f.getName()), e);
        }
    }
}
