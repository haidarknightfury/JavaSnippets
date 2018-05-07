package com.example.snippets.predicate.person;

import static com.example.snippets.predicate.person.PersonPredicate.isAdultMale;

import java.util.List;
import java.util.stream.Collectors;

public class Persons implements DomainOperations {

    private List<Person> persons;

    List<Person> getAdultMales() {
        return this.persons.stream().filter(isAdultMale()).collect(Collectors.toList());
    }

    List<Person> getAdultMales2() {
        return this.filter(this.persons, isAdultMale());
    }

    List<Person> getAdultFemales() {
        return this.filter(this.persons, PersonPredicate.isAdultFemale());
    }
}
