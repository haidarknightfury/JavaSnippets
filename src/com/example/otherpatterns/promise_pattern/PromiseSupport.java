package com.example.otherpatterns.promise_pattern;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class PromiseSupport<T> implements Future<T> {

    private static final int RUNNING = 1;
    private static final int FAILED = 2;
    private static final int COMPLETED = 3;

    private final Object lock;
    private volatile int state = RUNNING;
    private T value;
    private Exception exception;

    public PromiseSupport() {
        this.lock = new Object();
    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    public void fulfill(T value) {
        this.value = value;
        this.state = COMPLETED;
        synchronized (this.lock) {
            this.lock.notifyAll();
        }
    }

    public void fulfillExceptionally(Exception exception) {
        this.exception = exception;
        this.state = FAILED;
        synchronized (this.lock) {
            this.lock.notifyAll();
        }
    }

    @Override
    public T get() throws InterruptedException, ExecutionException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public boolean isDone() {
        return this.state > RUNNING;
    }

}
