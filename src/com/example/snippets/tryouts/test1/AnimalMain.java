package com.example.snippets.tryouts.test1;

import java.util.concurrent.atomic.AtomicBoolean;

public class AnimalMain implements Animal {

    @Override
    public void display(DefaultAnimal an) {
        System.out.println(an.getName());
    }

    public static void main(String[] args) {
        DefaultAnimal animal = new DefaultAnimal();
        animal.setName("DOG");

        AnimalMain an = new AnimalMain();
        an.display(animal);

        AtomicBoolean myVar = new AtomicBoolean(false);
        byRef(myVar);

        System.out.println(myVar.get());

    }

    public static void byRef(AtomicBoolean modified) {
        modified.set(true);
    }

}
