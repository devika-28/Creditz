package com.impetus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity(name = "personapplicant")
@Table(name = "personapplicant")
public class PersonApplicant {
	static final int TEN = 10;

	/** The appliactionId */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long applicationId;

	/** The panCard */

	@Size(max = TEN)
	@Column(name = "pan_card", nullable = false)
	private String pancard;

	/** amount of loan */
	@Column(name = "loan_amount", nullable = false)
	private int loanAmount;

	/** age of applicant */
	@Column(name = "age", nullable = false)
	private int age;

	/** gender of applicant */
	@Column(name = "gender", nullable = false)
	private String gender;

	/** occupation of applicant */
	@Column(name = "occupation", nullable = false)
	private String occupation;

	/** status of application */
	@Column(name = "application_status", nullable = false)
	private String applicationStatus;

	/** criminal record against applicant */
	@Column(name = "criminal_record", nullable = false)
	private int criminalRecord;

	/** is applicant is bankCorrupt */
	@Column(name = "bankruptcy", nullable = false)
	private int bankruptcy;

	/** loan tenure */
	@Column(name = "loan_tenure", nullable = false)
	private int loanTenure;

	/** email_status */
	@Column(name = "email_status", nullable = false)
	private String emailStatus;

	/**
	 * application_date date of application applied
	 */
	@Column(name = "application_date", nullable = false)
	private String date;

	/**
	 * application_time time of application applied
	 */
	@Column(name = "application_time", nullable = false)
	private String time;

	/** @return the emailStatus */
	public String getEmailStatus() {
		return emailStatus;
	}

	/** The personId. */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "person_id")
	private Person personId;

	/** The userId. */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User userId;

	public void setEmailStatus(String emailStatus) {
		this.emailStatus = emailStatus;
	}

	/** @return the date of application submit */
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	/** @return the time of application submit */
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	/** @return the applicationId */
	public long getApplicationId() {
		return applicationId;
	}

	/** @param applicationId */
	public void setApplicationId(long applicationId) {
		this.applicationId = applicationId;
	}

	/** @return the pan_card */
	public String getPancard() {
		return pancard;
	}

	/** @param pancard */
	public void setPancard(String pancard) {
		this.pancard = pancard;
	}

	/** @return the loanAmount */
	public int getLoanAmount() {
		return loanAmount;
	}

	/**
	 * @param loanAmount the occupation to set
	 */
	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}

	/**
	 * @return the age of applicant
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/** @return the gender of applicant */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/** @return the occupation */
	public String getOccupation() {
		return occupation;
	}

	/**
	 * @param occupation the occupation to set
	 */
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	/** @return the applicationStatus */
	public String getApplicationStatus() {
		return applicationStatus;
	}

	/**
	 * @param bankruptcy the bankruptcy to set
	 */
	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	/** @return the whether criminal record or not */
	public int getCriminalRecord() {
		return criminalRecord;
	}

	/**
	 * @param criminalRecord the criminalRecord to set
	 */
	public void setCriminalRecord(int criminalRecord) {
		this.criminalRecord = criminalRecord;
	}

	/** @return the bankruptcy */
	public int getBankruptcy() {
		return bankruptcy;
	}

	/**
	 * @param bankruptcy the bankruptcy to set
	 */
	public void setBankruptcy(int bankruptcy) {
		this.bankruptcy = bankruptcy;
	}

	/** @return the loanTenure */
	public int getLoanTenure() {
		return loanTenure;
	}

	/**
	 * @param loanTenure the loanTenure to set
	 */
	public void setLoanTenure(int loanTenure) {
		this.loanTenure = loanTenure;
	}

	/** @return the Person */
	public Person getPersonId() {
		return personId;
	}

	/**
	 * @param personId the personId to set
	 */
	public void setPersonId(Person personId) {
		this.personId = personId;
	}

	/** @return the user */
	public User getUserId() {
		return userId;
	}

	/**
	 * @param userId the userID to set
	 */
	public void setUserId(User userId) {
		this.userId = userId;
	}

}
