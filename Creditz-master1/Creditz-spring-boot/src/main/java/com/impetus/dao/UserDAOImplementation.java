package com.impetus.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.impetus.model.Organization;
import com.impetus.model.OrganizationApplicant;
import com.impetus.model.Person;
import com.impetus.model.PersonApplicant;
import com.impetus.model.User;

/**
 * The Class UserDAOImplementation.
 */
@Repository
public class UserDAOImplementation implements User_DAO {

	/** The entity manager. */
	@Autowired
	private EntityManager entityManager;

	/*
	 * (
	 * 
	 * @see com.impetus.Dao.User_DAO#savePerson(com.impetus.Model.Person)
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	/*
	 * @see
	 * com.impetus.Dao.User_DAO#saveOrganization(com.impetus.Model.Organization)
	 */
	public boolean saveOrganization(Organization user) {
		boolean status = false;
		entityManager = entityManager.getEntityManagerFactory().createEntityManager();
		Session currentSession = (Session) entityManager.unwrap(Session.class);

		try {

			User user1 = user.getUser();
			currentSession.save(user1);
			currentSession.save(user);
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	  /**
	    * return list of person
	    * list of person
	    */
	    @SuppressWarnings("unchecked")
	    public List<Person> findAllPersons() {

	        String hql = "from Person";
	        return (List<Person>) entityManager.createQuery(hql).getResultList();
	    }

	    @SuppressWarnings("unchecked")
	    public List<Organization> findAllOrganizations() {

	        String hql = "from Organization";
	        return (List<Organization>) entityManager.createQuery(hql).getResultList();
	    }

	    @SuppressWarnings("unchecked")
	    public List<PersonApplicant> findPersonApplicantByUserId(int userId) {

	        String hql = "from PersonApplicant where user_id=" + userId;
	        return (List<PersonApplicant>) entityManager.createQuery(hql).getResultList();
	    }

	    @SuppressWarnings("unchecked")
	    public List<OrganizationApplicant> findOrganizationApplicantByUserId(int userId) {
	        String hql = "from OrganizationApplicant where user_id=" + userId;
	        return (List<OrganizationApplicant>) entityManager.createQuery(hql).getResultList();
	    }

	    @Override
	    public boolean saveAnalyst(User user) {
	        boolean status = false;
	        entityManager = entityManager.getEntityManagerFactory().createEntityManager();
	        Session currentSession = (Session) entityManager.unwrap(Session.class);
	        currentSession.save(user);
	        return status;
	    }

	    @Override
	    public boolean deleteAnalystByUserId(int userId) {
	        boolean status = false;
	        entityManager = entityManager.getEntityManagerFactory().createEntityManager();
	        Session currentSession = (Session) entityManager.unwrap(Session.class);
	        currentSession.delete(userId);
	        return status;
	       
	    }

	    
	}
