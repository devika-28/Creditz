package com.impetus.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.impetus.model.User;

@Service
public interface AnalystService {

	
    /** get Details of all Analyst.
     * @return List of all Analyst */
    List<User> getAllAnalyst();

    /** delete Analyst details corresponding to particular userEmail.
     *
     * @param userEmail
     */
    void deleteAnalyst(String userEmail);

    /** check is there any User corresponding to particular email Address.
     *
     * @param userEmail
     * @return User */
    User uniqueCheckEmail(String userEmail);

    /** generate One Time Password.
     *
     * @return String */
    String generateOtp();

    /** send one time password to userEmail.
     *
     * @param userEmail
     *            the user
     * @return true, if successful */
    String sendOtp(String userEmail);

    /** update the user password of particular user.
     *
     * @param users
     *            the user
     * @return true, if successful */
    boolean updateUserPassword(String auth);

    /** Find User on the basis of userEmail and password.
     *
     * @param userEmail
     * @param password
     * @return true, if successful */
    User findUserByEmailPassword(String userEmail, String password);

}
