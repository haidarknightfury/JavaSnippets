package com.example.otherpatterns.retry_pattern;

public class BusinessException extends Exception {

    private static final long serialVersionUID = 1L;

    public BusinessException(String message) {
        super(message);
    }

}
