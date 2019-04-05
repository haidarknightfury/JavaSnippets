package com.example.patterns.observer_pattern.basic;

public class Main {

    public static void main(String[] args) {

        Programmer programmer = new Programmer();
        ProjectCoordinator projectCoordinator = new ProjectCoordinator(programmer);
        programmer.addObserver(projectCoordinator);
        programmer.setState("Hey brother");
    }
}
