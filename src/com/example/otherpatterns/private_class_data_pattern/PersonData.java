package com.example.otherpatterns.private_class_data_pattern;

public class PersonData {

    private String name;
    private String othernames;
    private int age;

    public PersonData(String name, String othernames, int age) {
        this.name = name;
        this.othernames = othernames;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public String getOthernames() {
        return this.othernames;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return "PersonData [name=" + this.name + ", othernames=" + this.othernames + ", age=" + this.age + "]";
    }

}
