package com.example.patterns.memento_pattern;

public class Main {

    public static void main(String[] args) {
        Originator originator = new Originator();
        Restorator restorator = new Restorator();

        originator.setState("start state");
        restorator.add(originator.saveStateToMemento());

        originator.setState("second state");
        restorator.add(originator.saveStateToMemento());

        System.out.println(restorator.get(0));

    }
}
