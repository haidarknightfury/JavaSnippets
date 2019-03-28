package com.example.patterns.adapter.squarepegadaptor;

public class RoundHole {

    int radius;

    public RoundHole(int r) {
        this.radius = r;
    }

    public boolean fits(RoundPeg roundpeg) {
        return this.radius > roundpeg.getRadius();
    }

    public int getRadius() {
        return this.radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

}
