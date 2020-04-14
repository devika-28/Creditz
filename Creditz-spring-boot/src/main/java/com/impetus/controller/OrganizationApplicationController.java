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
import com.impetus.service.OrganizationApplicationService;


@RestController
public class OrganizationApplicationController {
	
	@Autowired(required=true) 
	OrganizationApplicationService organizationservice;
	@Autowired
	OrganizationApplicationService service;
	
	 @CrossOrigin(origins = "*", allowedHeaders = "*")
	   	@PostMapping("/organization-user/user-application")
	   	public HashMap<String,Long> organizationApplicantApplicationSubmit(@RequestBody OrganizationApplicant application) {
	   		
//	       	service.RiskMitigate(application);
//	       	System.out.println("controller transfered to service");
	   		return service.organizationRiskMitigate(application);

	       	
	   	}
	 @CrossOrigin(origins = "*", allowedHeaders = "*")
		@PostMapping("/organization-user/user-history")
		public List<OrganizationApplicant> organizationHistory(@RequestBody OrganizationApplicant userId) {
			return service.getHistory(userId);

	    }
	    
	
	 @CrossOrigin(origins = "*", allowedHeaders = "*")
	 @GetMapping("/getOrganizationApplicants")
	 public List<OrganizationApplicant>getAllPersonApplicant(
             @RequestParam(defaultValue="0") int pageNo, 
             @RequestParam(defaultValue="1") int pageSize)
       {
           System.out.println(pageNo);
          return organizationservice.getAllOrganizationApplicant(pageNo, pageSize);
       }
	 
	 
	 @CrossOrigin(origins = "*", allowedHeaders = "*")
	 @GetMapping("/getTopOrganizationApplicants")
	 public List<OrganizationApplicant>findTopPersonCreditors()
	 {
	      return organizationservice.findTopPersonCreditors();
	 
	 }
	 
	
}