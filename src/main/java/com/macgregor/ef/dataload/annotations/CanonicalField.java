package com.macgregor.ef.dataload.annotations;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CanonicalField {
    public static final String MAPS_TO_DEFAULT = "default";

    String mapsTo() default MAPS_TO_DEFAULT;
    Class<?> hint() default Void.class;
}
