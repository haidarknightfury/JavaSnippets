package com.example.otherpatterns.retry_pattern;

public class CustomerNotFoundException extends BusinessException {

    public CustomerNotFoundException(String message) {
        super(message);
    }

    private static final long serialVersionUID = 1L;

}
