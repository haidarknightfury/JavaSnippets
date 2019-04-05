package com.example.patterns.state_pattern.basic;

public class Main {

    public static void main(String[] args) {
        // Shared context
        Context context = new Context();
        ApplicationStartState start = new ApplicationStartState();
        start.develop(context);

        System.out.println(context.getState());

        ApplicationFinishState applicationFinishState = new ApplicationFinishState();
        applicationFinishState.develop(context);
        System.out.println(context.getState());

    }
}
