package com.MyIdeas.pcStore.exception;

import com.MyIdeas.pcStore.exception.core.PcsException;

public class ValidationException extends PcsException {
    public ValidationException(String message) {
        super(message);
    }
}
