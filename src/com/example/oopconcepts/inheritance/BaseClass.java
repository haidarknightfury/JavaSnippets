package com.example.oopconcepts.inheritance;

public class BaseClass {

    String name;
    String address;

    public BaseClass() {

    }

    public BaseClass(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "BaseClass [name=" + this.name + ", address=" + this.address + "]";
    }

}
