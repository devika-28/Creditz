package com.impetus.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.impetus.model.User;

@Service
public interface UsersService {
	public List<User> getAllAnalyst(Integer pageNo, Integer pageSize);
}
