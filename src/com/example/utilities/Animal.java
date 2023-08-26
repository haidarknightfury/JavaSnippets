package com.example.utilities;

public class Animal {
	static int count = 0;
	
    public String name;
    public String category;
    private static String  age;

    public Animal(String name, String category) {
        this.name = name;
        this.category = category;
    }

    @Override
    public String toString() {
       
        return "Animal [name=" + this.name + ", category=" + this.category + "]";
    }

}
