package com.example.systemconfigurationparametersmanagerapi.exceptions;

public class BlankAttributeException extends RuntimeException {

    private final String errorMessages;

    public BlankAttributeException(String errorMessages) {
        super(errorMessages);
        this.errorMessages = errorMessages;
    }

    public BlankAttributeException(String errorMessages, Throwable cause) {
        super(errorMessages, cause);
        this.errorMessages = errorMessages;
    }
}
