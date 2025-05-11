package com.firstgroup.gamemanagerapi.exception;

public class DataIntegrityViolationException extends RuntimeException {
    public DataIntegrityViolationException(String message, Throwable cause) {

        super(message, cause);
    }
}
