package com.impetus.service;

import com.impetus.model.Organization;
import com.impetus.model.Person;
import com.impetus.model.User;

/** The Interface UserService. */
public interface UserService {

	public String GenerateOTP();

	public String sendOTP(String userEmail);

	/**
	 * Save person.
	 *
	 * @param user the user
	 * @return true, if successful
	 */
	public boolean savePerson(Person user);

	/**
	 * @param user the user
	 * 
	 * @return true, if successful
	 */
	public boolean saveOrganization(Organization user);

	/**
	 * Save Analyst
	 *
	 * @param user the user
	 * @return true, if successful
	 */
	public boolean saveAnalyst(User user);

}
