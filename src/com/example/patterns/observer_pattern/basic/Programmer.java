package com.example.patterns.observer_pattern.basic;

import java.util.ArrayList;
import java.util.List;

public class Programmer {

    List<Observer> observer = new ArrayList<Observer>();
    private String state;

    public void addObserver(Observer observer) {
        this.observer.add(observer);
    }

    public String getState() {
        return this.state;
    }

    public void notifyObservers() {
        this.observer.stream().forEach(Observer::update);
    }

    public void setState(String state) {
        this.state = state;
        this.notifyObservers();
    }

}
