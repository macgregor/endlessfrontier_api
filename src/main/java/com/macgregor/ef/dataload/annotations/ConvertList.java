package com.macgregor.ef.dataload.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Annotation to mark a field for List conversion
 *
 * Field should be a string containing homogenous element types separated by the configured path separator. elementType
 * should be one of:
 * Boolean.class
 * Byte.class
 * Short.class
 * Integer.class
 * Long.class
 * Float.class
 * Double.class
 * String.class
 * Object.class
 *
 * If the source field string is null, you will get an empty list. If elements cannot be converted to elementType after
 * split by sep, you will get a List of string.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ConvertList {
    String sep() default ",";
    Class<?> elementType() default Object.class;
}
