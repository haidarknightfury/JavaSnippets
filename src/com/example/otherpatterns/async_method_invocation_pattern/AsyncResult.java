package com.example.otherpatterns.async_method_invocation_pattern;

import java.util.concurrent.ExecutionException;

public interface AsyncResult<T> {

    boolean isCompleted();

    T getValue() throws ExecutionException;

    void await() throws InterruptedException;
}
