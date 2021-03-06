package com.example.otherpatterns.retry_pattern;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class FindCustomer implements BusinessOperation<String> {

    private final String customerId;
    private final Deque<BusinessException> errors;

    public FindCustomer(String customerId, BusinessException... errors) {
        this.customerId = customerId;
        this.errors = new ArrayDeque<>(Arrays.asList(errors));
    }

    @Override
    public String perform() throws BusinessException {
        if (!this.errors.isEmpty()) {
            throw this.errors.pop(); // Simulate errors
        }
        return this.customerId;
    }

}
