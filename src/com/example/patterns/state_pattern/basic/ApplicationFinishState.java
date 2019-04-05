package com.example.patterns.state_pattern.basic;

public class ApplicationFinishState implements State {

    /**
     * Context - common shared object to store the 'state'
     * set at this level
     */
    @Override
    public void develop(Context context) {
        System.out.println("Application in finish state");
        context.setState(this);
    }

    @Override
    public String toString() {
        return "ApplicationFinishState";
    }

}
