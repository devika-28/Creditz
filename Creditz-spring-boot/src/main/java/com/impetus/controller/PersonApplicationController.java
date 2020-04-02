package com.impetus.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.impetus.model.OrganizationApplicant;
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
    
    @CrossOrigin(origins = "*", allowedHeaders = "*")
   	@PostMapping("/organization-user/user-application")
   	public HashMap<String,Long> organizationApplicantApplicationSubmit(@RequestBody OrganizationApplicant application) {
   		
//       	service.RiskMitigate(application);
//       	System.out.println("controller transfered to service");
   		return service.organizationRiskMitigate(application);

       	
   	}
    
    
    
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/getPersonApplicants")
    public List<PersonApplicant>getAllPersonApplicant(
                        @RequestParam int pageNo, 
                        @RequestParam(defaultValue="1") int pageSize)
    {
    	System.out.println(pageNo);
        return service.getAllPersonApplicant(pageNo, pageSize);
 
       
    }
	
}
