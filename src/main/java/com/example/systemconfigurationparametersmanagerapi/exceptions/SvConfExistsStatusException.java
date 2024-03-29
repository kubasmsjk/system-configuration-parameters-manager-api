package com.example.systemconfigurationparametersmanagerapi.exceptions;

public class SvConfExistsStatusException extends RuntimeException {
    private final String errorMessages;

    public SvConfExistsStatusException(String errorMessages) {
        super(errorMessages);
        this.errorMessages = errorMessages;
    }

    public SvConfExistsStatusException(String errorMessages, Throwable cause) {
        super(errorMessages, cause);
        this.errorMessages = errorMessages;
    }

}
