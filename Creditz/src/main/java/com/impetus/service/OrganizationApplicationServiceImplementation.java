package com.impetus.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impetus.model.CibilReport;
import com.impetus.model.OrganizationApplicant;
import com.impetus.repository.CibilReportRepository;
import com.impetus.repository.OrganizationApplicationRepository;
import com.impetus.repository.OrganizationRepository;

@Service
public class OrganizationApplicationServiceImplementation implements OrganizationApplicationService {

    private static final Logger LOG = LoggerFactory.getLogger(OrganizationApplicationServiceImplementation.class);
    static final String APPROVED = "Approved";
    static final String DATEFORMAT = "dd/MM/yyyy";
    static final String REJECTEDLOWCREDITS = "Rejected Low Credits";
    static final String REJECTED = "Rejected";
    static final String PENDING = "Pending";
    static final String RECORDNOTFOUND = "Record Not Found";
    static final String REJECTEDBADHISTORY = "Rejected Bad History";
    static final String EMAILSTATUS = "False";
    static final String REJECTEDEARLY = "Rejected Early";
    static final String REJECTEDLIMIT = "Invalid Limit";
    static final int SEVENTYLAKHS = 700000;
    static final double N02 = .2;
    static final double N05 = .5;
    static final int N12 = 12;
    static final int N6 = 6;
    static final int N60 = 60;
    static final int N1200 = 1200;
    static final int N700 = 700;
    static final int N900 = 900;
    static final double N1305 = 13.5;
    static final int N300 = 300;
    static final int N500 = 500;
    static final int CS550 = 550;

    /** the organization application */
    @Autowired(required = true)
    private OrganizationApplicationRepository organizationApplication;

    /** the CIBIL report */
    @Autowired
    private CibilReportRepository cibilReport;

    /** the organization */
    @Autowired
    private OrganizationRepository organization;

    /** @param application
     * @return Application id string and value of application id
     * @throws ParseException
     */
    public HashMap<String, Long> organizationRiskMitigate(OrganizationApplicant application) throws ParseException {
        LOG.info("OrganizationApplicationServiceImplementation ::organizationRiskMitigate::Evaluating Policy");

        HashMap<String, Long> json = null;
        Long userId = (application.getUserId()).getUserId();
        Long organizatinId = organization.getOrganizationIdByUserId(userId);
        application.setDate(UserServiceImplementation.getCurrentDate());
        application.setTime(UserServiceImplementation.getCurrentTime());

        if((application.getLoanAmount()<7000000 && application.getLoanAmount()> 200000) && (application.getLoanTenure()<100 && application.getLoanTenure()>6))
        		{
        		CibilReport reportOfCurrentUser = cibilReport.findByPanCard(application.getPancard());
        LOG.info("OrganizationApplicationServiceImplementation ::organizationRiskMitigate::Fetching CIBIL Records");

        if (reportOfCurrentUser != null) {
            LOG.info("OrganizationApplicationServiceImplementation ::organizationRiskMitigate::CIBIL Records, Fetched");

            
            application.setApplicationStatus(this.approveOrDisapprove(application, reportOfCurrentUser));
            LOG.info("OrganizationApplicationServiceImplementation ::organizationRiskMitigate::Application Status SET");
        } else {
            LOG.info("OrganizationApplicationServiceImplementation ::organizationRiskMitigate::CIBIL Record not found");

            application.setApplicationStatus(RECORDNOTFOUND);
        }
     }
        else {
        	
        	LOG.info("OrganizationApplicationServiceImplementation ::organizationRiskMitigate::Not in verified range of loan amount or tenure");
            application.setApplicationStatus(REJECTEDLIMIT);
        }
        application.setEmailStatus(EMAILSTATUS);
        LOG.info("OrganizationApplicationServiceImplementation ::organizationRiskMitigate::Inserting Data into database");
        organizationApplication.insertApplication(application.getBankruptcy(), application.getBusinessAge(), application.getCriminalRecord(),
                application.getEmployeeCount(), application.getLicenseNumber(), application.getLoanAmount(), application.getLoanTenure(),
                application.getOrganizationType(), application.getPancard(), application.getRevenue(), application.getApplicationStatus(),
                organizatinId, userId, application.getEmailStatus(), application.getDate(), application.getTime());
        LOG.info("OrganizationApplicationServiceImplementation ::organizationRiskMitigate::Data inserted Succesfully");

        json = new HashMap<>();
        LOG.info("OrganizationApplicationServiceImplementation ::organizationRiskMitigate::Fetching Application ID");
        json.put("Application_Id", organizationApplication.getApplicationId());
        LOG.info("OrganizationApplicationServiceImplementation ::organizationRiskMitigate::Return Application ID to controller");
        return json;

    }

    /** this will calculate and return to submit application after 6 months.
     * 
     * @param currentApplicationdate
     * @param lastApplicationdate
     * @return status if application is submitted in a span of more than 6 months
     * @throws ParseException
     */

    String checkdate(Date lastApplicationdate, String currentApplicationdate) throws ParseException {
        int daylast;
        int monthlast;
        int yearlast;
        Date currentdate;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(lastApplicationdate);
        daylast = calendar.get(Calendar.DAY_OF_MONTH);
        monthlast = calendar.get(Calendar.MONTH);
        yearlast = calendar.get(Calendar.YEAR);

        monthlast += N6;
        if (monthlast > N12) {
            monthlast %= N12;
            yearlast += 1;
        }
        lastApplicationdate = new SimpleDateFormat(DATEFORMAT).parse(daylast + "/" + monthlast + "/" + yearlast);

        currentdate = new SimpleDateFormat(DATEFORMAT).parse(currentApplicationdate);

        if (lastApplicationdate.after(currentdate)) {

            return REJECTEDEARLY;
        }
        return null;
    }

    /** approve or disapprove.
     * 
     * @param application
     * @param reportOfCurrentUser
     * @return value for application status approved or other .
     * @throws ParseException
     */

    public String approveOrDisapprove(OrganizationApplicant application, CibilReport reportOfCurrentUser) throws ParseException {
        String nextapplicationStatus;
        String assetCategory = reportOfCurrentUser.getCategory();
        int cibilScore = reportOfCurrentUser.getCreditScore();
        int loanAmount = application.getLoanAmount();
        int monthlyIncome = reportOfCurrentUser.getMonthlyIncome();
        int loanTenure = application.getLoanTenure();
        float assetCost = reportOfCurrentUser.getAssetCost();
        float liabilites = reportOfCurrentUser.getLiabilities();
        Long userId = (application.getUserId()).getUserId();
        int noOfApplication;
        Date applicationdate;
        List<OrganizationApplicant> list = organizationApplication.findByUserId(userId);
        noOfApplication = list.size();

        if (noOfApplication > 0) {
            String lastApplicationDate = list.get(noOfApplication - 1).getDate();
             if(!(list.get(noOfApplication - 1).getApplicationStatus().equals(REJECTEDLIMIT))) {
            applicationdate = new SimpleDateFormat(DATEFORMAT).parse(lastApplicationDate);

            if (applicationdate != null) {

                nextapplicationStatus = this.checkdate(applicationdate, application.getDate());
                
                if (nextapplicationStatus.equals(REJECTEDEARLY)) {
                    return REJECTEDEARLY;
                }
            } 
            else {
                LOG.info("date formating error");
            }
             }
        }

        if (loanAmount > SEVENTYLAKHS || application.getBankruptcy() == 1 || application.getCriminalRecord() == 1) {
            return REJECTED;
        } else if ( reportOfCurrentUser.getCreditUtilization() >= N60 || (!((assetCategory.equals("STD")) || (assetCategory.equals("NPA")))))  {
            return REJECTEDBADHISTORY;
        } else if (cibilScore < N500 && cibilScore >= N300) {
            return REJECTEDLOWCREDITS;
        } else if (cibilScore <= N900 && cibilScore >= N700) {

            return APPROVED;
        } else if (cibilScore < N700 && cibilScore >= N500) {
            float calculatedIncome = (float) (monthlyIncome * N05);
            float interest = (float) ((loanAmount * N1305 * loanTenure) / N1200);
            float emi = ((loanAmount + interest) / loanTenure);
            float assetvalue = assetCost - liabilites;
            float loanamt = (float) (loanAmount + (assetvalue * N02));
            if (calculatedIncome > emi || assetvalue > loanamt) {
                return APPROVED;
            }
        }

        return "Pending Internal Error";

    }

    /** find out top creditors.
     * 
     * @return list of Organization Applicants */
    @Override
    public List<OrganizationApplicant> findTopPersonCreditors() {
        LOG.info("OrganizationApplicationServiceImplementation::findApplicants::call findByemailStatus method with email Status:{}", EMAILSTATUS);
        return organizationApplication.findTopPersonCreditors(APPROVED);
    }

    /** find out all application associated with particular userId.
     *
     * @param userId
     * @return list of Organization Applicants */
    @Override
    public List<OrganizationApplicant> getHistory(OrganizationApplicant userId) {
        LOG.info("OrganizationApplicationServiceImplementation::getHistory::call findByemailStatus method with findByUserId:{}",
                (userId.getUserId()).getUserId());
        return organizationApplication.findByUserId((userId.getUserId()).getUserId());
    }

    /** get organization applications.
     * 
     * @return list of Organization Applicants */
    public List<OrganizationApplicant> getAllOrganizationApplicant() {
        LOG.info("OrganizationApplicationServiceImplementation::getAllOrganizationApplicant::call findAll method with email Status:{0},EMAILSTATUS ");
        return organizationApplication.findAll();

    }

    /** @return list of Organization Applicants */
    public List<OrganizationApplicant> findApplicants() {

        return organizationApplication.findByemailStatus(EMAILSTATUS);

    }

}