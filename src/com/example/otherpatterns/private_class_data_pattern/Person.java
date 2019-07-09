package com.example.otherpatterns.private_class_data_pattern;

public class Person {

    private String name;
    private String othernames;
    private int age;

    public Person(String name, String othernames, int age) {
        this.name = name;
        this.othernames = othernames;
        this.age = age;
    }

    public void displayInfo() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Person [name=" + this.name + ", othernames=" + this.othernames + ", age=" + this.age + "]";
    }

    public void incrementAge() {
        this.age++;
    }

}
