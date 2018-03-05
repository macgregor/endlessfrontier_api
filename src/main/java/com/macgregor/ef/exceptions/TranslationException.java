package com.macgregor.ef.exceptions;

public class TranslationException extends DataLoadException {
    public TranslationException(String message, Throwable cause) {
        super(message, cause);
    }

    public TranslationException(String message) {
        super(message);
    }
}
