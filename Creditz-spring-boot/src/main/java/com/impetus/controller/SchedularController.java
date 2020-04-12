package com.impetus.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.impetus.model.OrganizationApplicant;
import com.impetus.model.PersonApplicant;
import com.impetus.repository.OrganizationApplicationRepository;
import com.impetus.repository.PersonApplicationRepository;
import com.impetus.service.MailService;
import com.impetus.service.OrganizationApplicationService;
import com.impetus.service.PersonApplicationService;


@RestController
public class SchedularController {
	
	
	private static final Logger logger = LoggerFactory.getLogger( SchedularController.class);
	
	@Autowired PersonApplicationRepository personRepository;
	
	@Autowired OrganizationApplicationRepository Repository;
	
	@Autowired PersonApplicationService service;
	
	@Autowired OrganizationApplicationService service1;
	
	@Autowired private MailService notificationService;
	
	static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    static final String status="True";
    
    @CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping("/sendUpdatePerson")
	public void StatusUpdatePersonApplicants() {
    	ArrayList<PersonApplicant> personApplicants=new ArrayList<PersonApplicant>();
        logger.info("Cron Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
        personApplicants = (ArrayList<PersonApplicant>) service.findApplicants();
        Iterator<PersonApplicant> personapplicantIterator =personApplicants.iterator();
        while(personapplicantIterator.hasNext()) {
        PersonApplicant applicants=personapplicantIterator.next();
        String email= applicants.getUserId().getUserEmail();
        String estatus=applicants.getEmailStatus();
        String applicationStatus=applicants.getApplicationStatus();
        notificationService.sendEmailToApplicants(email, estatus,applicationStatus);
        personRepository.updateEmailStatus(applicants.getApplicationId(), status);
        }
      }
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping("/sendUpdateOrganization")
	 public void statusUpdateForOrganization() {
	    	ArrayList<OrganizationApplicant> organizationApplicants=new ArrayList<OrganizationApplicant>();
	        logger.info("Cron Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
	        organizationApplicants =(ArrayList<OrganizationApplicant>)service1.findApplicants();
	        Iterator<OrganizationApplicant> organizationapplicantIterator =organizationApplicants.iterator();
	        while(organizationapplicantIterator.hasNext()) {
	        OrganizationApplicant applicants=organizationapplicantIterator.next();
	        String email= applicants.getUserId().getUserEmail();
	        String estatus=applicants.getEmailStatus();
	        String applicationStatus=applicants.getApplicationStatus();
	        notificationService.sendEmailToApplicants(email, estatus,applicationStatus);
	        Repository.updateEmailStatus(applicants.getApplicationId(), status);
	        }
	        }	
	    }
  
