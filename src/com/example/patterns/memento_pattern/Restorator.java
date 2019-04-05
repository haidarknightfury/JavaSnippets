package com.example.patterns.memento_pattern;

import java.util.ArrayList;
import java.util.List;

public class Restorator {

    List<Memento> mementos = new ArrayList<Memento>();

    public void add(Memento memento) {
        this.mementos.add(memento);
    }

    public Memento get(int index) {
        return this.mementos.get(index);
    }

}
