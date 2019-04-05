package com.example.patterns.state_pattern.basic;

/**
 * State interface - method develop
 * All the States will need to implement the state interface
 * @author hdargaye
 *
 */
public interface State {

    /**
     * Context - the one to keep up the current state
     * @param context
     */
    public void develop(Context context);

}
