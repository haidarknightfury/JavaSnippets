package com.example.otherpatterns.retry_pattern;

@FunctionalInterface
public interface BusinessOperation<T> {

    T perform() throws BusinessException;
}
