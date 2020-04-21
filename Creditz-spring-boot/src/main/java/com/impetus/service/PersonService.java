package com.impetus.service;

import org.springframework.stereotype.Service;

import com.impetus.model.Person;


@Service
public interface PersonService {
    
	/**
	 * Find User on the basis of userId
	 *
	 * @param Long
	 * 
	 * @return Person
	 */
	public Person findPersonByUserId(Long userId);
	
}
