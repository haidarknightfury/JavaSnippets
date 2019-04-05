package com.example.patterns.state_pattern.basic;

/**
 * Shared object to keep up the state
 * Has the property of state
 * @author hdargaye
 *
 */
public class Context {

    private State state;

    public Context() {
        this.state = null;
    }

    public State getState() {
        return this.state;
    }

    public void setState(State state) {
        this.state = state;
    }

}
