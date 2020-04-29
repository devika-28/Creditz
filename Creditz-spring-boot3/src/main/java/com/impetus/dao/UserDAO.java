package com.impetus.dao;

import com.impetus.model.Organization;
import com.impetus.model.Person;
import com.impetus.model.User;

/** The Interface User_DAO. */
public interface UserDAO {

    /** Save person.
     *
     * @param user
     *            the user
     * @return true, if successful to save person detail */
    boolean savePerson(Person user);

    /** save Analyst.
     * 
     * @param user
     * @return true if successful */
    boolean saveAnalyst(User user);

    /** Save organization.
     *
     * @param user
     *            the user
     * @return true, if successful to save organization detail */
    boolean saveOrganization(Organization user);

}