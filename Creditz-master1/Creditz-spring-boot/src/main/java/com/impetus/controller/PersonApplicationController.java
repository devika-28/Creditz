package com.impetus.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.impetus.model.PersonApplicant;
import com.impetus.service.PersonApplicationService;

@RestController
public class PersonApplicationController {

	@Autowired PersonApplicationService service;
	
    @CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/individual-user/user-application")
	public HashMap<String,Long> personApplicantApplicationSubmit(@RequestBody PersonApplicant application) {
		
//    	service.RiskMitigate(application);
//    	System.out.println("controller transfered to service");
		return service.RiskMitigate(application);

    	
	}
	
}
