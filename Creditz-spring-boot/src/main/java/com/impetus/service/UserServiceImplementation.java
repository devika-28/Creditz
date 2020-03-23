package com.impetus.service;

import java.util.List;

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

    @Transactional
    @Override

    public boolean savePerson(Person user) {
        User user1 = user.getUser();
        user1.setPassword(hashPassword(user1.getPassword()));
        user.setUser(user1);
        return userdao.savePerson(user);
    }

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

    @Override
    public boolean saveAnalyst(User user) {
        user.setPassword(hashPassword(user.getPassword()));
        return userdao.saveAnalyst(user);
    }

    @Override
    public List<Person> findAllPersons() {
        return userdao.findAllPersons();
    }

    @Override
    public List<Organization> findAllOrganizations() {
        return userdao.findAllOrganizations();
    }

    @Override
    public List<PersonApplicant> findPersonApplicantByUserId(int userId) {
        return userdao.findPersonApplicantByUserId(userId);
    }

    @Override
    public List<OrganizationApplicant> findOrganizationApplicantByUserId(int userId) {

        return userdao.findOrganizationApplicantByUserId(userId);
    }

}
