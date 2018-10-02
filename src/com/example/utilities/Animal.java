package com.example.utilities;

public class Animal {
    public String name;
    public String category;

    public Animal(String name, String category) {
        this.name = name;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Animal [name=" + this.name + ", category=" + this.category + "]";
    }

}
