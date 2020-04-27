package com.impetus.service;

import java.security.NoSuchAlgorithmException;

import com.impetus.model.Organization;
import com.impetus.model.Person;
import com.impetus.model.User;

/** The Interface UserService. */
public interface UserService {
    /** Generate OTP ,no parameters.
     * 
     * @return OTP in string form
     * @throws NoSuchAlgorithmException
     */
    String generateOTP() throws NoSuchAlgorithmException;

    /** send OTP.
     * 
     * @param userEmail
     * @return OTP in string form
     * @throws NoSuchAlgorithmException
     */
    String sendOTP(String userEmail) throws NoSuchAlgorithmException;

    /** Save person.
     *
     * @param user
     *            the user
     * @return true, if successful */
    boolean savePerson(Person user);

    /** @param user
     *            the user
     * @return true, if successful */
    boolean saveOrganization(Organization user);

    /** Save Analyst.
     *
     * @param user
     *            the user
     * @return true, if successful */
    boolean saveAnalyst(User user);

}
