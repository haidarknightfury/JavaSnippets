package com.example.otherpatterns.retry_pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

public class Retry<T> implements BusinessOperation<T> {

    private final BusinessOperation<T> operation;
    private final int maxAttempts;
    private final long delay;
    private final AtomicInteger attempts;
    private final Predicate<Exception> ignoreTests;
    private final List<Exception> errors;

    @SafeVarargs
    public Retry(BusinessOperation<T> operation, int maxAttempts, long delay, Predicate<Exception>... ignoreTests) {
        this.operation = operation;
        this.maxAttempts = maxAttempts;
        this.delay = delay;
        this.attempts = new AtomicInteger(0);
        this.ignoreTests = Arrays.stream(ignoreTests).reduce(Predicate::or).orElse(e -> false);
        this.errors = new ArrayList<>();
    }

    public List<Exception> errors() {
        return Collections.unmodifiableList(this.errors);
    }

    public int attempts() {
        return this.attempts.intValue();
    }

    @Override
    public T perform() throws BusinessException {
        do {
            try {
                System.out.println("performing operation");
                return this.operation.perform();
            } catch (BusinessException e) {
                this.errors.add(e);
                if (this.attempts.incrementAndGet() >= this.maxAttempts || !this.ignoreTests.test(e)) { // If not ignore test then throw errors no matter the amount of errors
                    throw e;
                }

                try {
                    Thread.sleep(this.delay);
                } catch (InterruptedException e2) {
                    // TODO: handle exception
                }
            }
        } while (true);
    }

}
