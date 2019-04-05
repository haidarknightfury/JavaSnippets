package com.example.patterns.bridge.pattern_1;

public class Bike extends Vehicle {

    public Bike(Workshop workshop1, Workshop workshop2) {
        super(workshop1, workshop2);
    }

    @Override
    public void manufacture() {
        System.out.println("bike");
        this.workshop1.work();
        this.workshop2.work();
    }

}
