package com.impetus.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.impetus.model.Organization;
import com.impetus.model.OrganizationApplicant;
import com.impetus.model.Person;
import com.impetus.model.PersonApplicant;
import com.impetus.model.User;
import com.impetus.service.UserService;

/** The Class UserController. */
@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = { "http://localhost:4200" })

public class UserController {

	/** The userservice. */
	@Autowired
	private UserService userservice;

	/**
	 * Verify.
	 *
	 * @return the string
	 */
	@RequestMapping("/")
	public String verify() {
		return "verified";
	}

	/**
	 * Save person.
	 *
	 * @param user the user
	 * @return the person
	 */
	@PostMapping("/save_person")
	public Person savePerson(@RequestBody Person user) {
		userservice.savePerson(user);
		return user;
	}

	/**
	 * Save organization.
	 *
	 * @param user the user
	 * 
	 * @return the organization
	 */
	@PostMapping("/save_organization")
	public Organization saveOrganization(@RequestBody Organization user) {
		userservice.saveOrganization(user);
		return user;
	}

	/**
	 * Save analyst
	 *
	 * @param user the user
	 * 
	 * @return the user
	 */
	@PostMapping("/save_analyst")
	public User saveAnalyst(@RequestBody User user) {
		userservice.saveAnalyst(user);
		return user;
	}

	/** @return person list */
	@GetMapping("/getPerson")
	public List<Person> findAllPersons() {
		return userservice.findAllPersons();
	}

	/** @return organization list */
	@GetMapping("/getOrganization")
	public List<Organization> findAllOrganizations() {
		return userservice.findAllOrganizations();
	}

	/**
	 * @param int userId
	 * @return list of person Applicant
	 */
	@GetMapping("/getPersonApplicant")
	public List<PersonApplicant> findPersonApplicantByUserId(@RequestParam int userId) {
		return userservice.findPersonApplicantByUserId(userId);
	}

	/**
	 * @param userId
	 * @return list of organization Applicant
	 */
	@GetMapping("/getOrganizationApplicant")
	public List<OrganizationApplicant> findOrganizationApplicantByUserId(@RequestParam int userId) {

		return userservice.findOrganizationApplicantByUserId(userId);
	}

}
