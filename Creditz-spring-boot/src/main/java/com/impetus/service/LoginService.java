package com.impetus.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.impetus.model.User;

@Service
public interface LoginService {

	/**
	 * check is there any User corresponding to particular email Address
	 *
	 * @param User
	 * 
	 * @return hash map if user Exist
	 */
       HashMap<?,?>isValidUser(User login);

}
