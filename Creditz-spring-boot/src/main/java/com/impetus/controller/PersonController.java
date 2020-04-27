package com.impetus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.impetus.model.Person;
import com.impetus.service.PersonService;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    /** Find User on the basis of userId.
     *
     * @param userId
     * @return Person */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/findPersonByUserId")
    public Person findPersonByUserId(@RequestParam Long userId) {
        return personService.findPersonByUserId(userId);
    }
}
