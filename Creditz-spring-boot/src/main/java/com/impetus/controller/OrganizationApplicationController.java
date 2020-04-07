package com.impetus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.impetus.model.OrganizationApplicant;
import com.impetus.service.OrganizationApplicationService;

@RestController
public class OrganizationApplicationController {
	
	@Autowired(required=true) 
	OrganizationApplicationService organizationservice;
	
	 @CrossOrigin(origins = "*", allowedHeaders = "*")
	 @GetMapping("/getOrganizationApplicants")
	 public List<OrganizationApplicant>getAllPersonApplicant(
             @RequestParam int pageNo, 
             @RequestParam(defaultValue="1") int pageSize)
       {
           System.out.println(pageNo);
          return organizationservice.getAllOrganizationApplicant(pageNo, pageSize);
       }
	 
	
}