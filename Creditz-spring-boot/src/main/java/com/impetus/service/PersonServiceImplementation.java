package com.impetus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impetus.model.Person;
import com.impetus.repository.PersonRepository;

@Service
public class PersonServiceImplementation implements PersonService {

	@Autowired
	PersonRepository person;

	/**
	 * Find User on the basis of userId
	 *
	 * @param userId
	 * 
	 * @return Person
	 */
	public Person findPersonByUserId(Long userId) {
		return person.findPersonByUserId(userId);

	}

}
