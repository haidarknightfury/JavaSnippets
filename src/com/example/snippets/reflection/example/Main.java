package com.example.snippets.reflection.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ClassInfo;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        // Normal Ways
        ArrayList<Animal> animaux = new ArrayList<>(Arrays.asList(new Dog(), new Cat()));
        animaux.forEach(Animal::makeSound);

        // Using Reflection - Using Guava to condense the code
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        ImmutableSet<ClassInfo> classes = ClassPath.from(classLoader).getTopLevelClasses("com.example.snippets.reflection.example");
        for (ClassInfo classInfo : classes) {
            Class targetClass = Class.forName(classInfo.getName());

            if (Animal.class.isAssignableFrom(targetClass) && !targetClass.isInterface()) {
                Object myInstance = targetClass.newInstance();
                Animal myAnimal = (Animal) myInstance;
                myAnimal.makeSound();
            }
        }
    }

}

interface Animal {
    void makeSound();
}

class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("wow");
    }
}

class Cat implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Miaow");
    }
}

class CatDog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("WowMiaow");
    }
}