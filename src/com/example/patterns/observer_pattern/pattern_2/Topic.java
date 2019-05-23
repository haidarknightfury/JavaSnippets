package com.example.patterns.observer_pattern.pattern_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Topic implements Subject {

    private List<Observer> observers;
    private String message;
    private Boolean changed;
    private final Object MUTEX = new Object();

    public Topic() {
        this.observers = new ArrayList<>();
    }

    @Override
    public Object getUpdate(Observer obj) {
        return this.message;
    }

    @Override
    public void notifyObservers() {
        List<Observer> observersLocal = null;
        synchronized (this.MUTEX) {
            if (!this.changed) {
                return;
            }
            observersLocal = new ArrayList<>(this.observers);
            this.changed = false;
        }
        for (Observer obj : observersLocal) {
            obj.update();
        }
    }

    public void postMessage(String msg) {
        this.message = msg;
        System.out.println(msg);
        this.changed = true;
        this.notifyObservers();
    }

    @Override
    public void register(Observer obj) {
        Objects.requireNonNull(obj);
        synchronized (this.MUTEX) {
            if (!this.observers.contains(obj)) {
                this.observers.add(obj);
            }
        }
    }

    @Override
    public void unregister(Observer obj) {
        synchronized (this.MUTEX) {
            this.observers.remove(obj);
        }
    }

}
