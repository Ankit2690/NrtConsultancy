package com.nrt.consultancy.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nrt.consultancy.entities.Person;
import com.nrt.consultancy.repository.PersonRepository;
import com.nrt.consultancy.services.PersonService;

@Service
public class PersonServiceImpl implements PersonService {
	@Autowired
	private PersonRepository personRepository;

	@Override
	public Person saveOnePerson(Person person) {
		Person save = personRepository.save(person);
		return save;
	}

	@Override
	public List<Person> getAllPersons() {
		List<Person> findAll = personRepository.findAll();
		return findAll;
	}

	@Override
	public Person getDetails(String selectedOption) {
		Person person = personRepository.findByName(selectedOption).get();
		return person;
	}

}
