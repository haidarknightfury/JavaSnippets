package com.example.patterns.adapter_pattern.squarepegadaptor;

public class SquarePegAdaptor extends RoundPeg {
    SquarePeg squarePeg;

    public SquarePegAdaptor(SquarePeg squarePeg) {
        this.squarePeg = squarePeg;
    }

    @Override
    public int getRadius() {
        return this.squarePeg.width / 2;
    }
}
