package com.example.memmgt;

public class Main {

    public static void main(String[] args) {
        int localValue = 5;
        calculate(localValue); // Passing by value - Copy of local variable passed accross the method calculate
        System.out.println(localValue);

        // Passing an Object or Array - A copy of the reference of the Obj/Array is passed which point to the same Obj/Array
        Animal animal = new Animal("Cat", "Mammal");
        renameAnimal(animal); // ref passed and changed in method below
        System.out.println(animal);

        final Animal animal2;
        animal2 = new Animal("Dog", "Mammal");
        animal2.setType("Dog"); // Can change the type

        // animal2 = new Animal(null, null); - will get an error as cannot be re assigned to a new one; reference can't be
        // changed

        // It is important to make the code const safe

    }

    public static void calculate(int calcValue) {
        calcValue = calcValue + 100;
    }

    public static void renameAnimal(Animal animal) {
        animal.setType("Cat");
    }
}
