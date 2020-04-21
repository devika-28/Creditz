package com.impetus.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.impetus.model.User;

@Service
public interface UsersService {

	/**
	 * get Details of all Analyst
	 *
	 * @param Integer
	 * 
	 * @param Integer
	 * 
	 * @return List of all Analyst
	 */
	public List<User> getAllAnalyst(Integer pageNo, Integer pageSize);

	/**
	 * delete Analyst details corresponding to particular userEmail
	 *
	 * @param userEmail
	 *
	 */
	public void DeleteAnalyst(String userEmail);

	/**
	 * check is there any User corresponding to particular email Address
	 *
	 * @param String
	 * 
	 * @return User
	 */
	public User uniqueCheckEmail(String userEmail);

	/**
	 * generate One Time Password
	 *
	 * @return String
	 */
	public String generateOtp();

	/**
	 * send one time password to userEmail
	 *
	 * @param user the user
	 * 
	 * @return true, if successful
	 */
	public String sendOtp(String userEmail);

	/**
	 * update the user password of particular user
	 *
	 * @param user the user
	 * 
	 * @return true, if successful
	 */
	public boolean updateUserPassword(User users);

	/**
	 * Find User on the basis of userEmail and password
	 *
	 * @param String
	 * 
	 * @param String
	 * 
	 * @return true, if successful
	 */
	public User findUserByEmailPassword(String userEmail, String password);

}
