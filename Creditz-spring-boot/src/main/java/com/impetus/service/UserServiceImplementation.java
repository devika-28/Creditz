package com.impetus.service;

import java.util.List;
import java.util.Random;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.impetus.dao.User_DAO;
import com.impetus.model.Organization;
import com.impetus.model.OrganizationApplicant;
import com.impetus.model.Person;
import com.impetus.model.PersonApplicant;
import com.impetus.model.User;

@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	private User_DAO userdao;
	 @Autowired private MailService notificationService;
	
	
	
	
	
	
	
	 public  String GenerateOTP() {
	    	String numbers="0123456789";
	    	String o = "";
	    	Random r=new Random();
	    	char otp[]=new char[6];
	    	for(int i=0;i<otp.length;i++) {
	    		otp[i]=numbers.charAt(r.nextInt(numbers.length()));	
	    		System.out.println(otp[i]);
	    		o=o+otp[i];
	    	}   	
	    	return o;
	    } 

	    
	    public String sendOTP(String userEmail) {
	    	
	    	String otp=this.GenerateOTP();
	    	System.out.println(otp+"in string form");
	        notificationService.sendEmailToUser(userEmail,otp);
			return otp;
		}
	    

	/**
	 * Save person.
	 *
	 * @param user the user
	 * @return true, if successful
	 */
	@Transactional
	@Override
	public boolean savePerson(Person user) {
		User user1 = user.getUser();
		user1.setPassword(hashPassword(user1.getPassword()));
		user.setUser(user1);
		return userdao.savePerson(user);
	}

	/**
	 * * @param user the user
	 * 
	 * @return true, if successful
	 */
	@Override
	public boolean saveOrganization(Organization user) {
		User user1 = user.getUser();
		user1.setPassword(hashPassword(user1.getPassword()));
		user.setUser(user1);
		return userdao.saveOrganization(user);
	}

	private String hashPassword(String plainTextPassword) {
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}

	/**
	 * Save Analyst
	 *
	 * @param user the user
	 * @return true, if successful
	 */
	@Override
	public boolean saveAnalyst(User user) {
		user.setPassword(hashPassword(user.getPassword()));
		return userdao.saveAnalyst(user);
	}

	/** @return person list */
	@Override
	public List<Person> findAllPersons() {
		return userdao.findAllPersons();
	}

	/** @return organization list */
	@Override
	public List<Organization> findAllOrganizations() {
		return userdao.findAllOrganizations();
	}

	/**
	 * @param userId
	 * @return list of person applicant
	 */
	@Override
	public List<PersonApplicant> findPersonApplicantByUserId(int userId) {
		return userdao.findPersonApplicantByUserId(userId);
	}

	/**
	 * @param userId
	 * @return list of organization Applicant
	 */
	@Override
	public List<OrganizationApplicant> findOrganizationApplicantByUserId(int userId) {

		return userdao.findOrganizationApplicantByUserId(userId);
	}

}
