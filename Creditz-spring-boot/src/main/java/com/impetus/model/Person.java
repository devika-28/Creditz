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

import org.hibernate.validator.constraints.Length;

/** The Class Person. */
@Entity
@Table(name = "person")
public class Person {

	static final int TEN = 10;

	/** The person id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long personId;

	/** The person name. */
	@Column(name = "person_name", nullable = false)
	private String personName;

	/** The contact. */
	@Length(min = TEN, max = TEN)
	@Column(name = "contact", nullable = false)
	private long contact;

	/** The address. */
	@Column(name = "address", nullable = false)
	private String address;

	/** The user. */
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId")
	private User user;

	/**
	 * Gets the person id.
	 *
	 * @return the person id
	 */
	public long getPersonId() {
		return personId;
	}

	/**
	 * Sets the person id.
	 *
	 * @param personId the new person id
	 */
	public void setPersonId(long personId) {
		this.personId = personId;
	}

	/**
	 * Gets the person name.
	 *
	 * @return the person name
	 */
	public String getPersonName() {
		return personName;
	}

	/**
	 * Sets the person name.
	 *
	 * @param personName the new person name
	 */
	public void setPersonName(String personName) {
		this.personName = personName;
	}

	/**
	 * Gets the contact.
	 *
	 * @return the contact
	 */
	public long getContact() {
		return contact;
	}

	/**
	 * Sets the contact.
	 *
	 * @param contact the new contact
	 */
	public void setContact(long contact) {
		this.contact = contact;
	}

	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 *
	 * @param address the new address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 *
	 * @param user the new user
	 */
	public void setUser(User user) {
		this.user = user;
	}

}
