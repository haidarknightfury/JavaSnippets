package com.example.snippets.reflection.person;

public class Person {

    private static int number = 0;

    public Person(String name) {
        super();
        this.name = name;
    }

    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void printPerson(Person person) {
        System.out.println(person.getName());
    }

}
