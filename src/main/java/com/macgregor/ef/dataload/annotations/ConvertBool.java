package com.macgregor.ef.dataload.annotations;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Annotation to mark a field for boolean conversion.
 *
 * Field should be a string (case insensitive) or integer in one of the following formats:
 * ConvertBool.Kind.T_F - "t" or "f"
 * ConvertBool.Kind.TRUE_FALSE - "true" or "false
 * ConvertBool.Kind.YES_NO - "yes" or "no"
 * ConvertBool.Kind.Y_N - "y" or "n"
 * ConvertBool.Kind.BINARY - 0 or 1
 * ConvertBool.Kind.BINARY - "0" or "1"
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ConvertBool {
    enum Kind { BINARY, TRUE_FALSE, YES_NO, T_F, Y_N}

    Kind kind() default Kind.TRUE_FALSE;
}
