package com.impetus.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.impetus.service.LoginService;

@RestController
public class LoginController {

    @Autowired
    private LoginService userService;

    /** login function.
     * 
     * @return Hash map containing role and user id of current user */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping(value = "/login")
    public ResponseEntity<HashMap<String, String>> login() {

        SecurityContext context = SecurityContextHolder.getContext();
        HashMap<String, String> users = (java.util.HashMap<String, String>) userService.postLoginDetails(context.getAuthentication().getName());
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);// You many decide to return
                                                               // HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}