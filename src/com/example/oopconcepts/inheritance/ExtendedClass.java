package com.example.oopconcepts.inheritance;

public class ExtendedClass extends BaseClass {

    int age;

    public ExtendedClass(String name, String address, int age) {
        super(name, address);
        this.age = age;
    }

    @Override
    public String toString() {
        return "ExtendedClass [age=" + this.age + ", name=" + this.name + ", address=" + this.address + "]";
    }

}
