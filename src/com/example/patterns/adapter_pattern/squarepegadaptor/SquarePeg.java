package com.example.patterns.adapter_pattern.squarepegadaptor;

public class SquarePeg {

    int width;

    public SquarePeg(int width) {
        this.width = width;
    }

    double getSquare() {
        return Math.pow(this.width, 2);
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
