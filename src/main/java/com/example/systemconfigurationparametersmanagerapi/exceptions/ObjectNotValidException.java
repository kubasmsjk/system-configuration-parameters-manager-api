package com.example.systemconfigurationparametersmanagerapi.exceptions;

import jakarta.validation.Path;

import java.util.Map;

public class ObjectNotValidException extends RuntimeException {

    private final String errorMessages;
    private final Map<Path, String> validFault;

    public ObjectNotValidException(String errorMessages, Map<Path, String> validFault) {
        super(errorMessages);
        this.errorMessages = errorMessages;
        this.validFault = validFault;
    }

    public ObjectNotValidException(String errorMessages, Throwable e, Map<Path, String> validFault) {
        super(errorMessages, e);
        this.errorMessages = errorMessages;
        this.validFault = validFault;
    }

    public String getErrorMessages() {
        return errorMessages;
    }

    public Map<Path, String> getValidFault() {
        return validFault;
    }
}
