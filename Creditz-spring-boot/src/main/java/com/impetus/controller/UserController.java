package com.impetus.controller;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.impetus.model.Organization;
import com.impetus.model.Person;
import com.impetus.model.User;
import com.impetus.service.UserService;

/** The Class UserController. */
@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = { "http://localhost:4200" })

public class UserController {

    /** The user service. */
    @Autowired
    private UserService userservice;

    @GetMapping("/otp")
    public String sendOTP(String userEmail) throws NoSuchAlgorithmException{
        return userservice.sendOTP(userEmail);

    }

    /** Save person.
     *
     * @param user
     *            the user
     * @return the person */
    @PostMapping("/save_person")
    public Person savePerson(@RequestBody Person user) {
        userservice.savePerson(user);
        return user;
    }

    /** Save organization.
     *
     * @param user
     *            the user
     * @return the organization */
    @PostMapping("/save_organization")
    public Organization saveOrganization(@RequestBody Organization user) {
        userservice.saveOrganization(user);
        return user;
    }

    /** Save analyst.
     *
     * @param user
     *            the user
     * @return the user */
    @PostMapping("/save_analyst")
    public User saveAnalyst(@RequestBody User user) {
        userservice.saveAnalyst(user);
        return user;
    }

}
