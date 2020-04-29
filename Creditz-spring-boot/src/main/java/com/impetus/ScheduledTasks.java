package com.impetus;

import java.util.ArrayList;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.impetus.model.OrganizationApplicant;
import com.impetus.model.PersonApplicant;
import com.impetus.repository.OrganizationApplicationRepository;
import com.impetus.repository.PersonApplicationRepository;
import com.impetus.service.MailService;
import com.impetus.service.OrganizationApplicationService;
import com.impetus.service.PersonApplicationService;

/** Deal with Scheduling of sending Application Status to applicants. */
@Component
public class ScheduledTasks {

	private static final Logger LOG = LoggerFactory.getLogger(ScheduledTasks.class);

	@Autowired
	private PersonApplicationRepository personRepository;

	@Autowired
	private PersonApplicationService service;

	@Autowired
	private OrganizationApplicationService service1;

	@Autowired
	private MailService notificationService;

	@Autowired
	private OrganizationApplicationRepository repository;

	static final String STATUS = "True";

	/** send status of application to person applicants execute in every 4 hour. */
	@Scheduled(cron = "0 0 */4 * * *")
	public void sendApplicationStatusToPersonApplicants() {
		ArrayList<PersonApplicant> personApplicants;
		LOG.info("ScheduledTasks::sendApplicationStatusToPersonApplicants::Schedular starts");
		LOG.info("ScheduledTasks::sendApplicationStatusToPersonApplicants::called find applicants method");
		personApplicants = (ArrayList<PersonApplicant>) service.findApplicants();

		Iterator<PersonApplicant> personapplicantIterator = personApplicants.iterator();
		while (personapplicantIterator.hasNext()) {
			PersonApplicant applicants = personapplicantIterator.next();
			String email = applicants.getUserId().getUserEmail();
			LOG.info("ScheduledTasks::sendApplicationStatusToPersonApplicants::The user email is:{}",email);
			String estatus = applicants.getEmailStatus();
			LOG.info("ScheduledTasks::sendApplicationStatusToPersonApplicants::The email Status is:{}",estatus);
			String applicationStatus = applicants.getApplicationStatus();
			LOG.info("ScheduledTasks::sendApplicationStatusToPersonApplicants::The applicationStatus is"
					+ applicationStatus);
			try {
				LOG.info("ScheduledTasks::sendApplicationStatusToPersonApplicants::call sendEmailToApplicants method");
				notificationService.sendEmailToApplicants(email, estatus, applicationStatus);
				LOG.info("ScheduledTasks ::sendApplicationStatusToPersonApplicants::call updateEmailStatus Method");
				personRepository.updateEmailStatus(applicants.getApplicationId(), STATUS);
			} catch (MailException mailException) {
				LOG.info("ScheduledTasks::sendApplicationStatusToPersonApplicants::Exception occur{}",mailException);
			}

		}
	}

	/**
	 * send status of application to organization applicants execute in every 4
	 * hour.
	 */
	@Scheduled(cron = "0 0 */4 * * *")
	public void scheduleSendApplicationStatusToPersonApplicants() {
		ArrayList<OrganizationApplicant> organizationApplicants;
		LOG.info("ScheduledTasks::scheduleSendApplicationStatusToPersonApplicants::Schedular starts");
		LOG.info("ScheduledTasks::scheduleSendApplicationStatusToPersonApplicants::called find applicants method");
		organizationApplicants = (ArrayList<OrganizationApplicant>) service1.findApplicants();
		Iterator<OrganizationApplicant> organizationapplicantIterator = organizationApplicants.iterator();
		while (organizationapplicantIterator.hasNext()) {
			OrganizationApplicant applicants = organizationapplicantIterator.next();
			String email = applicants.getUserId().getUserEmail();
			LOG.info(
					"ScheduledTasks::scheduleSendApplicationStatusToPersonApplicants::call sendEmailToApplicants method");
			String estatus = applicants.getEmailStatus();
			LOG.info("ScheduledTasks::scheduleSendApplicationStatusToPersonApplicants::The email Status is{}",estatus);
			String applicationStatus = applicants.getApplicationStatus();
			LOG.info("ScheduledTasks::scheduleSendApplicationStatusToPersonApplicants::The applicationStatus is:{}",applicationStatus);
			try {
				LOG.info(
						"ScheduledTasks::scheduleSendApplicationStatusToPersonApplicants::call sendEmailToApplicants method");
				notificationService.sendEmailToApplicants(email, estatus, applicationStatus);
				LOG.info(
						"ScheduledTasks::scheduleSendApplicationStatusToPersonApplicantss::call updateEmailStatus Method");
				repository.updateEmailStatus(applicants.getApplicationId(), STATUS);
			} catch (MailException mailException) {
				LOG.info("ScheduledTasks::scheduleSendApplicationStatusToPersonApplicants::Exception occur:{}",mailException);
			}

		}
	}
}
