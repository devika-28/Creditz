package com.impetus.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.impetus.model.CibilReport;
import com.impetus.model.PersonApplicant;
import com.impetus.repository.CibilReportRepository;
import com.impetus.repository.PersonApplicationRepository;
import com.impetus.repository.PersonRepository;

@Service
public class PersonApplicationServiceImplementation implements PersonApplicationService {
	 private static final Logger LOG = LoggerFactory.getLogger(PersonApplicationServiceImplementation.class);
    static final String APPROVED = "Approved";
    static final String FALSE = "False";
    static final String  REJECTED= "Rejected";
    
    @Autowired
    private CibilReportRepository cibilReport;

    @Autowired
    private PersonApplicationRepository personApplication;

    @Autowired
    private PersonRepository person;
    
    @Autowired
    private OrganizationApplicationServiceImplementation organizationApplication;


    /** process the submitted application and calculate the risk.
     * 
     * @param application
     *            user application
     * @return hash map consisting of application ID */
    @Override
    public HashMap<String, String> riskMitigate(PersonApplicant application) {
    	 HashMap<String, String> json=null;
         Date applicationdate = null;
         int noOfApplication;
         String nextapplicationdate;
    	 Long userId = (application.getUserId()).getUserId();
         Long personId = person.getPersonIdByUserId(userId);
         List<PersonApplicant> list=personApplication.findByUserId(userId);
         noOfApplication=list.size();
      if(noOfApplication>0) {   
     	String lastApplicationDate= list.get(noOfApplication-1).getDate();
     	String lastapplicationstatus=list.get(noOfApplication-1).getApplicationStatus();
     	if(!(lastapplicationstatus.equals(REJECTED))) {
      	try {
  			 applicationdate=new SimpleDateFormat("dd/MM/yyyy").parse(lastApplicationDate);
  		} catch (ParseException e) {
  			LOG.info("string to date parsing problem");
  		}
      	
      	if(applicationdate!=null) {
      		nextapplicationdate=organizationApplication.getNextApplicationDate(applicationdate);
      		json = new HashMap<>();
            json.put("Application_Id","Already submitted application \nYou can submit your next applcation after "+nextapplicationdate+"\nThank You" );
            return json;
      	}
      	else {
      		LOG.error("no applications yet");
      	}
       }   
      }    
      else {    
        try {
            CibilReport reportOfCurrentUser = cibilReport.findByPanCard(application.getPancard());
			application.setApplicationStatus(this.approveOrDisapprove(application, reportOfCurrentUser)); 
			} catch (Exception e) {
            application.setApplicationStatus("Record Not Found");
            }
        application.setDate(UserServiceImplementation.getCurrentDate());
        application.setTime(UserServiceImplementation.getCurrentTime());
        application.setEmailStatus(FALSE);
        personApplication.insertApplication(application.getPancard(), application.getLoanAmount(), application.getAge(), application.getGender(),
                application.getOccupation(), application.getApplicationStatus(), application.getCriminalRecord(), application.getBankruptcy(),
                application.getLoanTenure(), personId, userId, application.getEmailStatus(),application.getDate(),application.getTime());

        json = new HashMap<>();
        json.put("Application_Id", "Thanks!\nYour Application is being taken into consideration\nWe will inform you Sooner\nYour Application Id is: "+personApplication.getApplicationId());
        return json;
      }
      return json;
    }

    /** function to calculate approve or disapprove.
     * 
     * @param bankrupt
     * @param criminal
     * @param assetCategory
     * @param cibilScore
     * @param loanAmount
     * @param creditUtilization
     * @param creditLimit
     * @param monthlyIncome
     * @param monthlyLiablities
     * @param currentBalance
     * @return status */
    public String approveOrDisapprove(PersonApplicant application, CibilReport reportOfCurrentUser) {

		if (application.getBankruptcy() == 1 || application.getCriminalRecord() == 1) {
			return REJECTED;
		}

		else if (!(reportOfCurrentUser.getCategory().equals("STD")
				|| !(reportOfCurrentUser.getCategory().equals("NPA")))) {
			return "Rejected Bad History";
		}

		else if (reportOfCurrentUser.getCreditScore() < 550 && reportOfCurrentUser.getCreditScore() >= 300) {
			return "Rejected Low Credits";
		}

		else if (reportOfCurrentUser.getCreditScore() < 700 && reportOfCurrentUser.getCreditScore() >= 550) {
			int limit = 500000;
			return validation(limit, application.getLoanAmount(), reportOfCurrentUser.getCreditUtilization(),
					reportOfCurrentUser.getCreditLimit(), reportOfCurrentUser.getMonthlyIncome(),
					reportOfCurrentUser.getLiabilities(), reportOfCurrentUser.getCurrentBalance());
		}

		else if (reportOfCurrentUser.getCreditScore() < 800 && reportOfCurrentUser.getCreditScore() >= 700) {
			int limit = 1000000;
			return validation(limit, application.getLoanAmount(), reportOfCurrentUser.getCreditUtilization(),
					reportOfCurrentUser.getCreditLimit(), reportOfCurrentUser.getMonthlyIncome(),
					reportOfCurrentUser.getLiabilities(), reportOfCurrentUser.getCurrentBalance());
		}

		else if (reportOfCurrentUser.getCreditScore() <= 900 && reportOfCurrentUser.getCreditScore() >= 800) {
			return "Approve";
		}

		return "Pending Internal Error";
	}


    /** validation function.
     * 
     * @param limit
     * @param loanAmount
     * @param creditUtilization
     * @param creditLimit
     * @param monthlyIncome
     * @param monthlyLiablities
     * @param currentBalance
     * @return status */
    public String validation(int limit, int loanAmount, float creditUtilization, float creditLimit, int monthlyIncome, float monthlyLiablities,
            float currentBalance) {
        if (loanAmount > limit) {
            return "Rejected Amount Declined";
        }

        else if (creditUtilization <= .4 * creditLimit) {
            return "Rejected Bad History";
        }

        else if (.25 * (monthlyIncome + monthlyLiablities) <= loanAmount && currentBalance < loanAmount / 2) {
            return "Approve";
        }

        return "Pending Internal Error";
    }

    /** find person applications corresponding to particular Id.
     *
     * @param userId
     * @return list of Person Applicants */

    @Override
    public List<PersonApplicant> getHistory(PersonApplicant userId) {

        return  personApplication.findByUserId((userId.getUserId()).getUserId());
    }

    /** find person applications in particular page with no of records.
     *
     * @param pageNo
     * @param pageSize
     * @return list of Person Applicants */
    public List<PersonApplicant> getAllPersonApplicant(Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);

        Page<PersonApplicant> pagedResult = personApplication.findAll(paging);

        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }

    /** @return list of Person Applicants */
    public List<PersonApplicant> findApplicants() {

        return personApplication.findByemailStatus(FALSE);

    }

    /** find top creditors.
     * 
     * @return list of Person Applicants */
    public List<PersonApplicant> findTopPersonCreditors() {
        return personApplication.findTopPersonCreditors(APPROVED);
    }

}
