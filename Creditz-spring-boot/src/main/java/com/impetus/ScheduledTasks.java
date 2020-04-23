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

@Component
public class ScheduledTasks {

	private static final Logger LOG = LoggerFactory.getLogger(ScheduledTasks.class);

	@Autowired
	PersonApplicationRepository personRepository;

	@Autowired
	PersonApplicationService service;

	@Autowired
	OrganizationApplicationService service1;

	@Autowired
	private MailService notificationService;

	@Autowired
	OrganizationApplicationRepository Repository;

	static final String status = "True";

	@Scheduled(cron = "0 0 */4 * * *")
	public void scheduleTaskWithCronExpression() {
		ArrayList<PersonApplicant> personApplicants = new ArrayList<PersonApplicant>();
		personApplicants = (ArrayList<PersonApplicant>) service.findApplicants();
		Iterator<PersonApplicant> personapplicantIterator = personApplicants.iterator();
		while (personapplicantIterator.hasNext()) {
			PersonApplicant applicants = personapplicantIterator.next();
			String email = applicants.getUserId().getUserEmail();
			String estatus = applicants.getEmailStatus();
			String applicationStatus = applicants.getApplicationStatus();
			try {
				notificationService.sendEmailToApplicants(email, estatus, applicationStatus);
				LOG.info("Application status has send to" +email);
				personRepository.updateEmailStatus(applicants.getApplicationId(), status);
			} catch (MailException mailException) {
				LOG.error("exception ocuured", mailException);
			}

		}
	}

	@Scheduled(cron = "0 0 */4 * * *")
	public void scheduleTaskWithExpression() {
		ArrayList<OrganizationApplicant> organizationApplicants = new ArrayList<OrganizationApplicant>();
		organizationApplicants = (ArrayList<OrganizationApplicant>) service1.findApplicants();
		Iterator<OrganizationApplicant> organizationapplicantIterator = organizationApplicants.iterator();
		while (organizationapplicantIterator.hasNext()) {
			OrganizationApplicant applicants = organizationapplicantIterator.next();
			String email = applicants.getUserId().getUserEmail();
			String estatus = applicants.getEmailStatus();
			String applicationStatus = applicants.getApplicationStatus();
			try {
				notificationService.sendEmailToApplicants(email, estatus, applicationStatus);
				LOG.info("Application status has send to" +email);
				Repository.updateEmailStatus(applicants.getApplicationId(), status);
			} catch (MailException mailException) {
				LOG.error("exception ocuured", mailException);
			}

		}
	}
}
