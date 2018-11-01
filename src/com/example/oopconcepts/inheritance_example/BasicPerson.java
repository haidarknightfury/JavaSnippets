package com.example.oopconcepts.inheritance_example;

public class BasicPerson {

    String name;
    String address;

    public BasicPerson() {

    }

    public BasicPerson(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "BasicPerson [name=" + this.name + ", address=" + this.address + "]";
    }

}
