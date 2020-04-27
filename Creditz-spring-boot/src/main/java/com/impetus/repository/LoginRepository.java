package com.impetus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.impetus.model.User;

/** Fetch data from User table in database. */
@Repository
public interface LoginRepository extends JpaRepository<User, Long> {

    /** Select user details using user email as primary key.
     * 
     * @param email
     *            applicants email
     * @return USER RECORD */
    @Query("SELECT l FROM user l WHERE l.userEmail = :email")
    User findByUserEmail(String email);

}
