package com.example.patterns.bridge.pattern_1;

public class Car extends Vehicle {

    public Car(Workshop workshop1, Workshop workshop2) {
        super(workshop1, workshop2);
    }

    @Override
    public void manufacture() {
        System.out.println("car");
        this.workshop1.work();
        this.workshop2.work();
    }

}
