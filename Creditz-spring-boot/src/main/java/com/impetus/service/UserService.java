package com.impetus.service;

import java.util.List;

import com.impetus.model.Organization;
import com.impetus.model.OrganizationApplicant;
import com.impetus.model.Person;
import com.impetus.model.PersonApplicant;
import com.impetus.model.User;

/** The Interface UserService. */
public interface UserService {
	
	
	
	
	
	public  String GenerateOTP(); 
    public String sendOTP(String userEmail) ;

	/**
	 * Save person.
	 *
	 * @param user the user
	 * @return true, if successful
	 */
	public boolean savePerson(Person user);

	/**
	 * * @param user the user
	 * 
	 * @return true, if successful
	 */
	public boolean saveOrganization(Organization user);

	/** @return person list */
	public List<Person> findAllPersons();

	/** @return organization list */
	public List<Organization> findAllOrganizations();

	/**
	 * @param int
	 * @return list of person applicant
	 */
	public List<PersonApplicant> findPersonApplicantByUserId(int userId);

	/**
	 * @param int
	 * @return list of organization Applicant
	 */
	public List<OrganizationApplicant> findOrganizationApplicantByUserId(int userId);

	/**
	 * Save Analyst
	 *
	 * @param user the user
	 * @return true, if successful
	 */
	public boolean saveAnalyst(User user);

}
