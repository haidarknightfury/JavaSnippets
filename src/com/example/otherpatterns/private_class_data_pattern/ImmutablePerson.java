package com.example.otherpatterns.private_class_data_pattern;

public class ImmutablePerson {

    private PersonData data;

    public ImmutablePerson(String name, String othernames, int age) {
        this.data = new PersonData(name, othernames, age);
    }

    public void displayDetails() {
        System.out.println(this.data.toString());
    }

}
