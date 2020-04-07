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

import org.hibernate.annotations.ColumnDefault;
import org.springframework.beans.factory.annotation.Value;

@Entity(name ="personapplicant")
@Table(name ="personapplicant")
public class PersonApplicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long applicationId;
    
    /** The panCard */
    
    @Size(max = 10)
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
   
    @Column(name="email_status" ,nullable=false)
    private String emailStatus;
    
    public String getEmailStatus() {
		return emailStatus;
	}


	public void setEmailStatus(String emailStatus) {
		this.emailStatus = emailStatus;
	}

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    private Person  personId;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User  userId;

    
    public long getApplicationId() {
		return applicationId;
	}
    
   
	public void setApplicationId(long applicationId) {
		this.applicationId = applicationId;
	}

	public String getPancard() {
		return pancard;
	}

	public void setPancard(String pancard) {
		this.pancard = pancard;
	}

	public int getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	public int getCriminalRecord() {
		return criminalRecord;
	}

	public void setCriminalRecord(int criminalRecord) {
		this.criminalRecord = criminalRecord;
	}

	public int getBankruptcy() {
		return bankruptcy;
	}

	public void setBankruptcy(int bankruptcy) {
		this.bankruptcy = bankruptcy;
	}

	public int getLoanTenure() {
		return loanTenure;
	}

	public void setLoanTenure(int loanTenure) {
		this.loanTenure = loanTenure;
	}

	public Person getPersonId() {
		return personId;
	}

	public void setPersonId(Person personId) {
		this.personId = personId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	
}
