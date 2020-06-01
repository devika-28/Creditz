package com.impetus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

@Entity(name = "user")
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
@Component
public class User {

	public User(long userId, @Email String userEmail, String role, @Length(min = 10) String password) {
		super();
		this.userId = userId;
		this.userEmail = userEmail;
		this.role = role;
		this.password = password;
	}

	public User() {
		
	}

	static final int N10 = 10;

	/** the userId */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;

	/** the userEmail */
	@Email()
	@Column(unique = true, name = "user_email", nullable = false)
	private String userEmail;

	/** the role */
	@Column(name = "role", nullable = false)
	private String role;

	/** the password */
	@Length(min = N10)
	@Column(name = "password", nullable = false)
	private String password;

	/** @return the userId */
	public long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}

	/** @return the userEmail */
	public String getUserEmail() {
		return userEmail;
	}

	/**
	 * @param userEmail the userEmail to set
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	/** @return the role */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/** @return the password */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public Object thenReturn(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}