package com.impetus.service;

import com.impetus.repository.LoginRepository;

import static org.mockito.Mockito.when;


import com.impetus.model.User;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
public class TestLoginService {
	@Mock
	private LoginRepository loginRepo;
	
	@InjectMocks
	private LoginServiceImplementation loginService;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void postLoginDetails() {

		when(loginRepo.findByUserEmail("piajaiswal8109289952@gamil.com"))
		.thenReturn(new User(105, "piajaiswal8109289952@gamil.com", "person", "Momdad@123"));
		loginService.postLoginDetails("piajaiswal8109289952@gamil.com");
}
}
