package com.example.otherpatterns.retry_pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

public class RetryExponentialBackoff<T> implements BusinessOperation<T> {

    private final BusinessOperation<T> operation;
    private final int maxAttempts;
    private final long maxDelay;
    private final AtomicInteger attempts;
    private Predicate<Exception> ignoreTests;
    private final List<Exception> errors;

    @SafeVarargs
    public RetryExponentialBackoff(BusinessOperation<T> operation, int maxAttempts, long maxDelay, AtomicInteger attempts, Predicate<Exception>... ignorePredicates) {
        super();
        this.operation = operation;
        this.maxAttempts = maxAttempts;
        this.maxDelay = maxDelay;
        this.attempts = new AtomicInteger();
        this.ignoreTests = Arrays.stream(ignorePredicates).reduce(Predicate::or).orElse(e -> false); // if not present return a predicate which return false
        this.errors = new ArrayList<>();
    }

    public List<Exception> errors() {
        return Collections.unmodifiableList(this.errors);
    }

    @Override
    public T perform() throws BusinessException {
        do {
            try {
                return this.operation.perform();
            } catch (BusinessException e) {
                this.errors.add(e);
                if (this.attempts.incrementAndGet() >= this.maxAttempts || !this.ignoreTests.test(e)) {
                    throw e;
                }

                try {
                    Random random = new Random();
                    long testDelay = (long) Math.pow(2, this.attempts()) * 1000 + random.nextInt(1000);
                    long delay = testDelay < this.maxDelay ? testDelay : this.maxDelay;
                    Thread.sleep(delay);
                } catch (InterruptedException e2) {
                }
            }

        } while (true);
    }

    private double attempts() {
        return this.attempts.intValue();
    }

}
