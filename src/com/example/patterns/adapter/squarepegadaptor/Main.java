package com.example.patterns.adapter.squarepegadaptor;

public class Main {

    public static void main(String[] args) {
        RoundHole roundHole = new RoundHole(10);
        System.out.println(roundHole.fits(new RoundPeg(5)));
        System.out.println(roundHole.fits(new SquarePegAdaptor(new SquarePeg(5))));
    }
}
