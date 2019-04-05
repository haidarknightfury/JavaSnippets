package com.example.patterns.observer_pattern.basic;

public abstract class Observer {

    public Programmer programmer;

    public Observer(Programmer programmer) {
        this.programmer = programmer;
    }

    public abstract void update();

}
