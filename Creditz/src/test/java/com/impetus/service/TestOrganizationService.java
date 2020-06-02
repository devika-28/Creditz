package com.impetus.service;

import com.impetus.repository.OrganizationRepository;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.impetus.model.Organization;
import com.impetus.model.User;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TestOrganizationService {

	@Mock
	private OrganizationRepository organizationRepo;

	@InjectMocks
	private OrganizationServiceImplementation organizationService;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void findOrganizationByUserId() {
		Organization organization = new Organization();
		User user = new User(106, "piajaiswal8109289952@gamil.com", "person", "Momdad@123");

		organization.setOrganizationId(101);
		organization.setOrganizationName("suryaLimited");
		organization.setContact(8109289952l);
		organization.setAddress("Indore");
		organization.setDirectorName("Pia");
		organization.setUser(user);
		when(organizationRepo.findOrganizationByUserId(user.getUserId())).thenReturn(organization);
		Organization org = organizationService.findOrganizationByUserId(user.getUserId());

		assertEquals(101, org.getOrganizationId());
		assertEquals("suryaLimited", org.getOrganizationName());
		assertEquals(8109289952l, org.getContact());
		assertEquals("Pia", org.getDirectorName());

	}
}
