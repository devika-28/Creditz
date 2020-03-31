package com.impetus.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.impetus.model.User;
import com.impetus.repository.UserRepository;

@Service
public class UsersServiceImplementation implements UsersService {
	@Autowired UserRepository user;
	
	@Override
	public List<User> getAllAnalyst(Integer pageNo, Integer pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		String role="Analyst";
        Page<User>pagedResult = user.findByRole(role,paging);
         
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<User>();
        }
    }
	}


