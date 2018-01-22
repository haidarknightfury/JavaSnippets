package com.example.snippets.lamda.person;

import static com.example.snippets.lamda.person.PersonPredicate.isAdultMale;

import java.util.List;
import java.util.stream.Collectors;

public class Persons implements DomainOperations{
	
	private List<Person> persons;
	
	List<Person> getAdultMales(){
		return persons.stream().filter(isAdultMale()).collect(Collectors.toList());	
	}
	
	List<Person> getAdultMales2(){
		return this.filter(persons, isAdultMale());
	}
}
