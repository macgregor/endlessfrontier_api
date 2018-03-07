package com.macgregor.ef.exceptions;

public class CanonicalConversionException extends DataLoadException {
    public CanonicalConversionException(String message, Throwable cause) {
        super(message, cause);
    }

    public CanonicalConversionException(String message) {
        super(message);
    }
}
