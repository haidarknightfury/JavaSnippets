package com.example.otherpatterns.object_pool;

import java.util.concurrent.atomic.AtomicInteger;

public class Connection {

    public static AtomicInteger counter = new AtomicInteger(0);
    private final int id;

    public Connection() {
        this.id = counter.incrementAndGet();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Connection [id=" + this.id + "]";
    }

}
