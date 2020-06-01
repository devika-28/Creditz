package com.impetus.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impetus.model.Person;
import com.impetus.repository.PersonRepository;

@Service
public class PersonServiceImplementation implements PersonService {

	private static final Logger LOG = LoggerFactory.getLogger(PersonServiceImplementation.class);
	@Autowired
	private PersonRepository person;

	/**
	 * Find User on the basis of userId.
	 *
	 * @param userId
	 * @return Person
	 */
	public Person findPersonByUserId(Long userId) {
		LOG.info("PersonServiceImplementation::findPersonByUserId::call findPersonByUserId method with userId:{}",
				userId);
		return person.findPersonByUserId(userId);

	}

}
