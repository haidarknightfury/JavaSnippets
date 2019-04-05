package com.example.patterns.observer_pattern.basic;

public class ProjectCoordinator extends Observer {

    public ProjectCoordinator(Programmer programmer) {
        super(programmer);
    }

    @Override
    public void update() {
        System.out.println("Okay received your state : " + this.programmer.getState());

    }

}
