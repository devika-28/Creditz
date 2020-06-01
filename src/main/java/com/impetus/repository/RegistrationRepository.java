package com.impetus.repository;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.impetus.model.Organization;
import com.impetus.model.Person;
import com.impetus.model.User;


/** The Class UserDAOImplementation. */
@Repository
public class RegistrationRepository  {
	private static final Logger LOG = LoggerFactory.getLogger(RegistrationRepository.class);
	/** The entity manager. */
	@Autowired
	private EntityManager entityManager;

	

	/**
	 * Find User By UserMail.
	 *
	 * @param userMail the userMail
	 * @return the user
	 */
	public User findUserByUserMail(String userMail) {
		return entityManager.find(User.class, userMail);

	}

	/**
	 * Save Person.
	 *
	 * @param user the user of Person type
	 * @return the boolean if saved successfully returns true To save the detail of
	 *         Person
	 */

	public boolean savePerson(Person user) {
		boolean status = false;
		entityManager = entityManager.getEntityManagerFactory().createEntityManager();
		Session currentSession = entityManager.unwrap(Session.class);
		try {
			User user1 = user.getUser();
			currentSession.save(user1);
			currentSession.save(user);
			status = true;
			LOG.info("RegistrationRepository::saveAnalyst::Person saved successfully");
		} catch (Exception e) {
			LOG.error("RegistrationRepository::saveAnalyst::exception occurs{0}", e);
		}
		return status;
	}

	/**
	 * @see com.impetus.repository.RegisterRepository.User_DAO#saveOrganization(com.impetus.Model.Organization)
	 *      Save organization.
	 * @param user the user
	 * @return the boolean on successfully saving detail returns true To save the
	 *         detail of organization
	 */

	public boolean saveOrganization(Organization user) {
		boolean status = false;
		entityManager = entityManager.getEntityManagerFactory().createEntityManager();
		Session currentSession = entityManager.unwrap(Session.class);
		try {
			User user1 = user.getUser();
			currentSession.save(user1);
			currentSession.save(user);
			status = true;
			LOG.info("RegistrationRepository::saveAnalyst::Organization saved successfully");
		} catch (Exception e) {
			LOG.error("RegistrationRepository::saveAnalyst::exception occurs", e);
		}
		return status;
	}

	/**
	 * save Analyst.
	 * 
	 * @param user
	 * @return true or false
	 */
	
	public boolean saveAnalyst(User user) {
		boolean status = false;
		try {
			entityManager = entityManager.getEntityManagerFactory().createEntityManager();
			Session currentSession = entityManager.unwrap(Session.class);
			user.setRole("Analyst");
			currentSession.save(user);
			status = true;
			LOG.info("RegistrationRepository::saveAnalyst::Analyst saved successfully");
		} catch (Exception e) {
			LOG.error("RegistrationRepository::saveAnalyst::exception occurs", e);
		}
		return status;
	}

}
