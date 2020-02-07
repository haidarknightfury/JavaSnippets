package com.example.otherpatterns.retry_pattern;

public class DatabaseNotAvailableException extends BusinessException {

    private static final long serialVersionUID = 1L;

    public DatabaseNotAvailableException(String message) {
        super(message);
    }

}
