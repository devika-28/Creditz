package com.impetus.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.impetus.model.Person;
import com.impetus.service.PersonService;

@RestController
public class PersonController {

	private static final Logger LOG = LoggerFactory.getLogger(PersonController.class);
	@Autowired
	private PersonService personService;

	/**
	 * Find User on the basis of userId.
	 *
	 * @param userId
	 * @return Person
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/findPersonByUserId")
	public Person findPersonByUserId(@RequestParam Long userId) {
		try {
			LOG.info("PersonController::findPersonByUserId::return findPersonByUserId method with userId:{}", userId);
			return personService.findPersonByUserId(userId);
		} catch (Exception e) {
			LOG.warn("PersonController ::findPersonByUserId:: run time exception occur{0}", e);

		}
		return null;
	}
}
