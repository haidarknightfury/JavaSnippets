package com.example.patterns.memento_pattern;

/**
 * Immutable class Memento
 * @author hdargaye
 */
public class Memento {

    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }

    @Override
    public String toString() {
        return "Memento [state=" + this.state + "]";
    }

}
