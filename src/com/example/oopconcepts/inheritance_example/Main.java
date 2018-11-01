package com.example.oopconcepts.inheritance_example;

public class Main {

    public static void main(String[] args) {

        SpecificPerson specificPerson = new SpecificPerson("Haidar", "Curepipe", 22);
        // Extended/Child class can be converted to BaseClass but not inverse - Can be upcasted but not downcasted
        BasicPerson basePerson = specificPerson;
        System.out.println(basePerson.toString());

        BasicPerson anotherBasicPerson = new BasicPerson("baka", "japan");
        SpecificPerson anotherSpecificPerson = (SpecificPerson) anotherBasicPerson;
        // class cast exception; cannot be downcasted
        System.out.println(anotherSpecificPerson);

    }

}
