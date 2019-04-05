package com.example.patterns.memento_pattern;

public class Originator {

    private String state;

    public String getMementoFromState(Memento memento) {
        return memento.getState();
    }

    public Memento saveStateToMemento() {
        return new Memento(this.state);
    }

    public void setState(String state) {
        this.state = state;
    }
}
