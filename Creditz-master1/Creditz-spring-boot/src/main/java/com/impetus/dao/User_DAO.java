package com.impetus.dao;

import java.util.List;

import com.impetus.model.Organization;
import com.impetus.model.OrganizationApplicant;
import com.impetus.model.Person;
import com.impetus.model.PersonApplicant;
import com.impetus.model.User;

/** The Interface User_DAO. */
    public interface User_DAO {

    /** Save person.
     *
     * @param user
     *            the user
     * @return true, if successful */
    public boolean savePerson(Person user);
    /**
     * save Analyst
     * @param user
     * @return
     */
    public boolean saveAnalyst(User user);

    /** Save organization.
     *
     * @param user
     *            the user
     * @return true, if successful */
    public boolean saveOrganization(Organization user);
    public boolean deleteAnalystByUserId(int userId);

    /** @return */
    public List<Person> findAllPersons();

    /** @return */
    public List<Organization> findAllOrganizations();

    /** @param userId
     * @return */
    public List<PersonApplicant> findPersonApplicantByUserId(int userId);

    /** @param userId
     * @return */
    public List<OrganizationApplicant> findOrganizationApplicantByUserId(int userId);
}





//package com.impetus.dao;
//
//import com.impetus.model.Organization;
//import com.impetus.model.Person;
//
///**
// * The Interface User_DAO.
// */
//public interface User_DAO {
//
//	/**
//	 * Save person.
//	 *
//	 * @param user the user
//	 * @return true, if successful
//	 */
//	public boolean savePerson(Person user);
//
//	/**
//	 * Save organization.
//	 *
//	 * @param user the user
//	 * @return true, if successful
//	 */
//	public boolean saveOrganization(Organization user);
//
//}
