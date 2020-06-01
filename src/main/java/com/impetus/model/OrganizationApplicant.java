package com.impetus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity(name = "organizationapplicant")
@Table(name = "organizationapplicant")
public class OrganizationApplicant {
	static final int TEN = 10;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long applicationId;

	/** The panCard */
	@Size(max = TEN)
	@Column(name = "pan_card", nullable = false)
	private String pancard;

	/** Loan Amount */
	@Column(name = "loan_amount", nullable = false)
	private int loanAmount;

	/** Revenue of Organization */
	@Column(name = "revenue", nullable = false)
	private long revenue;

	/** No of Employees in Organization */
	@Column(name = "employee_count", nullable = false)
	private int employeeCount;

	/** the no years business is running */
	@Column(name = "age", nullable = false)
	private int businessAge;

	/** license no of organization */
	@Column(name = "licenseno", nullable = false)
	private String licenseNumber;

	/** field of organization */
	@Column(name = "organization_type", nullable = false)
	private String organizationType;

	/** application status approved or pending or approved */
	@Column(name = "application_status", nullable = false)
	private String applicationStatus;

	/** Criminal record against applicant */
	@Column(name = "criminal_record", nullable = false)
	private int criminalRecord;

	/** is applicant is bankCorrupt */
	@Column(name = "bankruptcy", nullable = false)
	private int bankruptcy;

	/** loan tenure */
	@Column(name = "loan_tenure", nullable = false)
	private int loanTenure;

	/** emailStatus */
	@Column(name = "email_status", nullable = false)
	private String emailStatus;

	/** date of application applied */
	@Column(name = "application_date", nullable = false)
	private String date;

	/** time of application applied */
	@Column(name = "application_time", nullable = false)
	private String time;

	/** the organization foreign key mapping */
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "organization_id")
	private Organization organizationId;

	/** the user foreign key mapping */
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User userId;

	/** @return the emailStatus */
	public String getEmailStatus() {
		return emailStatus;
	}

	public void setEmailStatus(String emailStatus) {
		this.emailStatus = emailStatus;
	}

	/** @return whether criminal record or not */
	public int getCriminalRecord() {
		return criminalRecord;
	}

	public void setCriminalRecord(int criminalRecord) {
		this.criminalRecord = criminalRecord;
	}

	/** @return whether bankruptcy or not */
	public int getBankruptcy() {
		return bankruptcy;
	}

	public void setBankruptcy(int bankruptcy) {
		this.bankruptcy = bankruptcy;
	}

	/** @return the emailStatus */
	public long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(long applicationId) {
		this.applicationId = applicationId;
	}

	/** @return the pan_card */
	public String getPancard() {
		return pancard;
	}

	/**
	 * @param pancard the panCard to set
	 */
	public void setPancard(String pancard) {
		this.pancard = pancard;
	}

	/** @return the loanAmount */
	public int getLoanAmount() {
		return loanAmount;
	}

	/**
	 * @param loanAmount the loanAmount to set
	 */
	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}

	/** @return the revenue */
	public long getRevenue() {
		return revenue;
	}

	/**
	 * @param revenue the revenue to set
	 */
	public void setRevenue(long revenue) {
		this.revenue = revenue;
	}

	/** @return the employeeCount */
	public int getEmployeeCount() {
		return employeeCount;
	}

	/**
	 * @param employeeCount the employeeCount to set
	 */
	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
	}

	/** @return the businessAge */
	public int getBusinessAge() {
		return businessAge;
	}

	/**
	 * @param businessAge the businessAge to set
	 */
	public void setBusinessAge(int businessAge) {
		this.businessAge = businessAge;
	}

	/** @return the licenseNumber */
	public String getLicenseNumber() {
		return licenseNumber;
	}

	/**
	 * @param licenseNumber the licenseNumber to set
	 */
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	/** @return the organizationType */
	public String getOrganizationType() {
		return organizationType;
	}

	/**
	 * @param organizationType the organizationType to set
	 */
	public void setOrganizationType(String organizationType) {
		this.organizationType = organizationType;
	}

	/** @return the applicationStatus */
	public String getApplicationStatus() {
		return applicationStatus;
	}

	/**
	 * @param applicationStatus the applicationStatus to set
	 */
	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	/** @return the loanTenure */
	public int getLoanTenure() {
		return loanTenure;
	}

	/**
	 * @param loanTenure the loanTenureto set
	 */
	public void setLoanTenure(int loanTenure) {
		this.loanTenure = loanTenure;
	}

	/** @return the organizationId */
	public Organization getOrganizationId() {
		return organizationId;
	}

	/**
	 * @param organizationId the organizationId to set
	 */
	public void setOrganizationId(Organization organizationId) {
		this.organizationId = organizationId;
	}

	/** @return the userId */
	public User getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(User userId) {
		this.userId = userId;
	}

	/** @return the application submit date */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/** @return the application submit time */
	public String getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}

}
