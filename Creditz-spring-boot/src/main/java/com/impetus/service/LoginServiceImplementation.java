package com.impetus.service;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impetus.model.User;
import com.impetus.repository.LoginRepository;

@Service("userService")
public class LoginServiceImplementation implements LoginService {

    @Autowired
    private LoginRepository loginRepo;

    /** after authentication it will return user id and role to front end.
     * 
     * @param userEmail
     *            user email
     * @return hash map of user id and role */
    @Override
    public HashMap<String, String> postLoginDetails(String userEmail) {

        HashMap<String, String> credentials = new HashMap<>();

        try {
            User currentUser = loginRepo.findByUserEmail(userEmail);

            credentials.put("userId", String.valueOf(currentUser.getUserId()));
            credentials.put("role", String.valueOf(currentUser.getRole()));

        } catch (NullPointerException e) {
            credentials.put("userId", null);
            credentials.put("role", null);
        }
        return credentials;
    }

}
