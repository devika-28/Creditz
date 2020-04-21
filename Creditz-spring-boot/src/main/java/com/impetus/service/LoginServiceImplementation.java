package com.impetus.service;

import java.util.HashMap;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impetus.model.User;
import com.impetus.repository.LoginRepository;

@Service
public class LoginServiceImplementation implements LoginService {

	@Autowired
	private LoginRepository loginRepo;
	
	/**
	 * check is there any User corresponding to particular email Address
	 *
	 * @param User
	 * 
	 * @return hash map if user Exist
	 */
	@Override
	public HashMap<String, String> isValidUser(User login) {

		HashMap<String, String> credentials = new HashMap< >();
		
        credentials.put("userId", null);
        credentials.put("role", null);
        
       
		try {
			User currentUser = loginRepo.findByUserEmail(login.getUserEmail());

			hashPassword("Devika@28");   
//		System.out.println("currentUser.getPassword()"+ currentUser.getPassword());
//		System.out.println("currentUser.getPassword()"+ currentUser.getUserEmail());
//		System.out.println("currentUser.getPassword()"+ currentUser.getRole());
//		System.out.println("currentUser.getPassword()"+ currentUser.getUserId());

	        if (BCrypt.checkpw(login.getPassword(), currentUser.getPassword())) {

				credentials.replace("userId", String.valueOf(currentUser.getUserId()));
                credentials.replace("role",  currentUser.getRole());

			}

		} catch (NullPointerException e) {
            credentials.put("userId", null);
		    credentials.put("role", null);
			
		}

		return credentials;
	}
	
	private String hashPassword(String plainTextPassword){
	    System.out.println(BCrypt.hashpw(plainTextPassword, BCrypt.gensalt(12)));
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt(12));
    }
	
	
}
