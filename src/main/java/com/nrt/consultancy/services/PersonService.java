package com.nrt.consultancy.services;

import java.util.List;

import com.nrt.consultancy.entities.Person;

public interface PersonService {

	Person saveOnePerson(Person person);

	List<Person> getAllPersons();

	Person getDetails(String selectedOption);

}
