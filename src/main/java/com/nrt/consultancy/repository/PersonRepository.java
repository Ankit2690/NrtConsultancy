package com.nrt.consultancy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nrt.consultancy.entities.Person;

public interface PersonRepository extends JpaRepository<Person,Long> {
	
	Optional<Person>findByName(String selectedOption);
}
