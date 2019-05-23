package com.example.otherpatterns.object_pool;

import java.util.HashSet;
import java.util.Set;

public abstract class ObjectPool<T> {

    private Set<T> available = new HashSet<>();
    private Set<T> inUse = new HashSet<>();

    public synchronized void checkIn(T instance) {
        this.inUse.remove(instance);
        this.available.add(instance);
    }

    public synchronized T checkout() {
        if (this.available.isEmpty()) {
            this.available.add(this.create());
        }
        T instance = this.available.iterator().next();
        this.available.remove(instance);
        this.inUse.add(instance);
        return instance;
    }

    protected abstract T create();

    @Override
    public synchronized String toString() {
        return "ObjectPool [available=" + this.available + ", inUse=" + this.inUse + "]";
    }

}
