package com.impetus.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.impetus.model.User;

@Service
public interface LoginService {

      
       HashMap<?,?> isValidUser(User login);

}
