package com.example.snippets.enums;

public enum Planet {

    MERCURY(3.303e+23, 2.4397e6), VENUS(4.869e+24, 6.0518e6);

    private final double mass; // in kilograms
    private final double radius; // in meters

    private Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }

}
