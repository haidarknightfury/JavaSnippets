package com.example.snippets.predicate.person;

import java.util.function.Predicate;

public class PersonPredicate {
    // Why not create a function in class person - separation of concerns
    public static Predicate<Person> isAdultMale() {
        return p -> p.getAge() > 18 && p.getSex() == SexEnum.MALE;
    }

    public static Predicate<Person> isAdultFemale() {
        return p -> p.getAge() > 18 && p.getSex() == SexEnum.FEMALE;
    }
}
