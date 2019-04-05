package com.example.patterns.state_pattern.basic;

/**
 * Individual classes implements the state
 * and has to change the state when particular method is called
 * @author hdargaye
 *
 */
public class ApplicationStartState implements State {

    @Override
    public void develop(Context context) {
        System.out.println("Application in the start state of development");
        context.setState(this);
    }

    @Override
    public String toString() {
        return "ApplicationStartState";
    }

}
