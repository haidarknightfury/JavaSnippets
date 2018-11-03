package com.example.oopconcepts.inheritance_example;

public class SpecificPerson extends BasicPerson {

    int age;

    public SpecificPerson(String name, String address, int age) {
        super(name, address);
        this.age = age;
    }

    @Override
    public String toString() {
        return "SpecificPerson [age=" + this.age + ", name=" + this.name + ", address=" + this.address + "]";
    }

}
