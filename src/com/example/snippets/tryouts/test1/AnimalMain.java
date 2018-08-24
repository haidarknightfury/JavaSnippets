package com.example.snippets.tryouts.test1;

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
    }

}
