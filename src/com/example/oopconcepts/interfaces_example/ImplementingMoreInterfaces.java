package com.example.oopconcepts.interfaces_example;

/**
 * Implementing two interfaces having same methods signatures to override
 * Possible because in the end, what matters is to have the method
 *
 * @author hdargaye
 *
 */
public class ImplementingMoreInterfaces {

    public interface sound {
        public void makeSound();
    }

    public interface say {
        public void makeSound();
    }

    class Dog implements sound, say {
        @Override
        public void makeSound() {
            System.out.println("Bark");
        }
    }

    public static void main(String[] args) {
        Dog dog = new ImplementingMoreInterfaces().new Dog();
        dog.makeSound();
    }
}
