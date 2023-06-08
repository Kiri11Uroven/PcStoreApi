package com.MyIdeas.pcStore.exception.core;

public class PcsException extends RuntimeException {
    public PcsException(String message) {
        super(message);
    }

    public PcsException(String message, Throwable cause) {
        super(message, cause);
    }
}
