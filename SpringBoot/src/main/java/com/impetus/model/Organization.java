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

/** The Class Organization. */
@Entity
@Table(name = "organization")
public class Organization {

	/** The organization id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long organizationId;

	/** The organization name. */
	@Column(name = "org_name", nullable = false)
	private String organizationName;

	/** The contact. */
	@Length(min = 10,max = 10)
	@Column(name = "contact", nullable = false)
	private long contact;

	/** The address. */
	@Column(name = "address", nullable = false)
	private String address;

	/** The director name. */
	@Column(name = "directorName")
	private String directorName;

	/** The user. */
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId")
	private User user;

	/**
	 * Gets the organization id.
	 *
	 * @return the organization id
	 */
	public long getOrganizationId() {
		return organizationId;
	}

	/**
	 * Sets the organization id.
	 *
	 * @param organizationId the new organization id
	 */
	public void setOrganizationId(long organizationId) {
		this.organizationId = organizationId;
	}

	/**
	 * Gets the organization name.
	 *
	 * @return the organization name
	 */
	public String getOrganizationName() {
		return organizationName;
	}

	/**
	 * Sets the organization name.
	 *
	 * @param organizationName the new organization name
	 */
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
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
	 * Gets the director name.
	 *
	 * @return the director name
	 */
	public String getDirectorName() {
		return directorName;
	}

	/**
	 * Sets the director name.
	 *
	 * @param directorName the new director name
	 */
	public void setDirectorName(String directorName) {
		this.directorName = directorName;
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
