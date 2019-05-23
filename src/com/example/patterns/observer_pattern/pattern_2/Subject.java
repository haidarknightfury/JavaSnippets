package com.example.patterns.observer_pattern.pattern_2;

public interface Subject {

    public Object getUpdate(Observer obj);

    public void notifyObservers();

    public void register(Observer obj);

    public void unregister(Observer obj);

}
