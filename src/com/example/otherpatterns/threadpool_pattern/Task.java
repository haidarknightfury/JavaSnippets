package com.example.otherpatterns.threadpool_pattern;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Task {

    private static final AtomicInteger ID_GENERATOR = new AtomicInteger();
    private final int id;
    private final int timeMs;

    public Task(final int timeMs) {
        this.timeMs = timeMs;
        this.id = ID_GENERATOR.incrementAndGet();
    }

    public int getId() {
        return this.id;
    }

    public int getTimeMs() {
        return this.timeMs;
    }

    @Override
    public String toString() {
        return "Task [id=" + this.id + ", timeMs=" + this.timeMs + "]";
    }

}
