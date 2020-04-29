package com.impetus.controller;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.impetus.model.OrganizationApplicant;
import com.impetus.model.PersonApplicant;
import com.impetus.repository.OrganizationApplicationRepository;
import com.impetus.repository.PersonApplicationRepository;
import com.impetus.service.MailService;
import com.impetus.service.OrganizationApplicationService;
import com.impetus.service.PersonApplicationService;

/** Scheduler controller. */
@RestController
public class SchedularController {

	private static final Logger LOG = LoggerFactory.getLogger(SchedularController.class);

	@Autowired
	private PersonApplicationRepository personRepository;

	@Autowired
	private OrganizationApplicationRepository repository;

	@Autowired
	private PersonApplicationService service;

	@Autowired
	private OrganizationApplicationService service1;

	@Autowired
	private MailService notificationService;

	static final DateTimeFormatter DATETIMEFORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");
	static final String STATUS = "True";

	/** send status of application to person applicants. */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/sendUpdatePerson")
	public void statusUpdatePersonApplicants() {
		ArrayList<PersonApplicant> personApplicants;
		LOG.info("SchedularController ::statusUpdatePersonApplicants::Schedular starts");
		LOG.info("SchedularController ::statusUpdatePersonApplicants::called find applicants method");
		personApplicants = (ArrayList<PersonApplicant>) service.findApplicants();
		Iterator<PersonApplicant> personapplicantIterator = personApplicants.iterator();

		while (personapplicantIterator.hasNext()) {
			PersonApplicant applicants = personapplicantIterator.next();

			String email = applicants.getUserId().getUserEmail();
			LOG.info("SchedularController ::statusUpdateForOrganization::The user email is {}", email);
			String estatus = applicants.getEmailStatus();
			LOG.info("SchedularController ::statusUpdateForOrganization::The Email Status is {}", estatus);
			String applicationStatus = applicants.getApplicationStatus();
			LOG.info("SchedularController ::statusUpdateForOrganization::The application status is {}",
					applicationStatus);

			try {
				LOG.info("SchedularController ::statusUpdatePersonApplicants::call sendEmailToApplicants method");
				notificationService.sendEmailToApplicants(email,applicationStatus);
				LOG.info(
						"SchedularController ::statusUpdatePersonApplicants::call updateEmailStatus method with email:{}",
						email);
				personRepository.updateEmailStatus(applicants.getApplicationId(), STATUS);

			} catch (MailException mailException) {
				LOG.error("SchedularController ::statusUpdatePersonApplicants::exception occur", mailException);
			}

		}
		LOG.info("SchedularController ::statusUpdatePersonApplicants::Schedular has stop");
	}

	/** send status of application to organization applicants. */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/sendUpdateOrganization")
	public void statusUpdateForOrganization() {
		LOG.info("SchedularController ::statusUpdateForOrganization::Schedular starts");
		ArrayList<OrganizationApplicant> organizationApplicants;

		LOG.info("SchedularController ::statusUpdatePersonApplicants::called find applicants method");
		organizationApplicants = (ArrayList<OrganizationApplicant>) service1.findApplicants();

		Iterator<OrganizationApplicant> organizationapplicantIterator = organizationApplicants.iterator();

		while (organizationapplicantIterator.hasNext()) {
			OrganizationApplicant applicants = organizationapplicantIterator.next();
			String email = applicants.getUserId().getUserEmail();
			LOG.info("SchedularController ::statusUpdateForOrganization::The user email is {}",email);
			String estatus = applicants.getEmailStatus();
			LOG.info("SchedularController ::statusUpdateForOrganization::The Email Status is {}" + estatus);
			String applicationStatus = applicants.getApplicationStatus();
			LOG.info(
					"SchedularController ::statusUpdateForOrganization::The application status is {}" + applicationStatus);

			try {
				LOG.info("SchedularController ::statusUpdateForOrganization::call sendEmailToApplicants method");
				notificationService.sendEmailToApplicants(email,applicationStatus);
				LOG.info("SchedularController ::statusUpdateForOrganization::Application status has send to {}",email);
				repository.updateEmailStatus(applicants.getApplicationId(), STATUS);
			} catch (MailException mailException) {
				LOG.error("SchedularController ::statusUpdateForOrganization::exception occur", mailException);
			}
		}
		LOG.info("SchedularController ::statusUpdateForOrganization::Schedular has stop");
	}
}
