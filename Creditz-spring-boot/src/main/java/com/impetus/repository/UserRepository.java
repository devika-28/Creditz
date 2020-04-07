package com.impetus.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.impetus.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
    Page<User>findByRole(String role,Pageable pageable);
   
    User findByUserEmail(String userEmail);

	
}
