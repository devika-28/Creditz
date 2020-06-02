package com.impetus.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.impetus.model.Organization;
import com.impetus.model.OrganizationApplicant;
import com.impetus.model.User;
import com.impetus.service.OrganizationApplicationServiceImplementation;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class OrganizationApplicationControllerTest {
	@InjectMocks
	OrganizationApplicationController organizationController;

	@Mock
	OrganizationApplicationServiceImplementation organizationApplicationService;

	@Test
	public void getAllOrganizationApplicant() {
		List<OrganizationApplicant> list = new ArrayList<OrganizationApplicant>();
		OrganizationApplicant organizationApplicant = new OrganizationApplicant();

		Organization organization = new Organization();
		User user = new User(106, "piajaiswal8109289952@gamil.com", "person", "Momdad@123");

		organization.setOrganizationId(101);
		organization.setOrganizationName("suryaLimited");
		organization.setContact(8109289952l);
		organization.setAddress("Indore");
		organization.setDirectorName("Pia");
		organization.setUser(user);
		organizationApplicant.setBusinessAge(12);
		organizationApplicant.setApplicationId(12);
		organizationApplicant.setEmployeeCount(123);
		organizationApplicant.setEmailStatus("False");
		organizationApplicant.setLoanAmount(5000000);
		organizationApplicant.setLoanTenure(12);
		organizationApplicant.setUserId(user);
		organizationApplicant.setOrganizationId(organization);

		Organization organization1 = new Organization();
		OrganizationApplicant organizationApplicant1 = new OrganizationApplicant();
		User user1 = new User(107, "piajaiswal8109289952@gamil.com", "person", "Momdad@123");

		organization.setOrganizationId(102);
		organization.setOrganizationName("suryaLimited");
		organization.setContact(8109289952l);
		organization.setAddress("Indore");
		organization.setDirectorName("Pia");
		organization.setUser(user);
		organizationApplicant1.setBusinessAge(12);
		organizationApplicant1.setApplicationId(12);
		organizationApplicant1.setEmployeeCount(123);
		organizationApplicant1.setEmailStatus("False");
		organizationApplicant1.setLoanAmount(5000000);
		organizationApplicant1.setLoanTenure(12);
		organizationApplicant1.setUserId(user1);
		organizationApplicant1.setOrganizationId(organization1);
		list.add(organizationApplicant);
		list.add(organizationApplicant1);

		when(organizationApplicationService.getAllOrganizationApplicant()).thenReturn(list);

		// when
		List<OrganizationApplicant> result = organizationController.getAllOrganizationApplicant();

		// then
		assertThat(result.size()).isEqualTo(2);

		assertThat(result.get(0).getOrganizationId()).isEqualTo(organizationApplicant.getOrganizationId());

		assertThat(result.get(1).getOrganizationId()).isEqualTo(organizationApplicant1.getOrganizationId());
	}

	@Test
	public void findApplicants() {
		List<OrganizationApplicant> list = new ArrayList<OrganizationApplicant>();
		OrganizationApplicant organizationApplicant = new OrganizationApplicant();

		Organization organization = new Organization();
		User user = new User(106, "piajaiswal8109289952@gamil.com", "person", "Momdad@123");

		organization.setOrganizationId(101);
		organization.setOrganizationName("suryaLimited");
		organization.setContact(8109289952l);
		organization.setAddress("Indore");
		organization.setDirectorName("Pia");
		organization.setUser(user);
		organizationApplicant.setBusinessAge(12);
		organizationApplicant.setApplicationId(12);
		organizationApplicant.setEmployeeCount(123);
		organizationApplicant.setEmailStatus("False");
		organizationApplicant.setLoanAmount(5000000);
		organizationApplicant.setLoanTenure(12);
		organizationApplicant.setUserId(user);
		organizationApplicant.setOrganizationId(organization);

		Organization organization1 = new Organization();
		OrganizationApplicant organizationApplicant1 = new OrganizationApplicant();
		User user1 = new User(107, "piajaiswal8109289952@gamil.com", "person", "Momdad@123");

		organization.setOrganizationId(102);
		organization.setOrganizationName("suryaLimited");
		organization.setContact(8109289952l);
		organization.setAddress("Indore");
		organization.setDirectorName("Pia");
		organization.setUser(user);
		organizationApplicant1.setBusinessAge(12);
		organizationApplicant1.setApplicationId(12);
		organizationApplicant1.setEmployeeCount(123);
		organizationApplicant1.setEmailStatus("False");
		organizationApplicant1.setLoanAmount(5000000);
		organizationApplicant1.setLoanTenure(12);
		organizationApplicant1.setUserId(user1);
		organizationApplicant1.setOrganizationId(organization1);
		list.add(organizationApplicant);
		list.add(organizationApplicant1);

		when(organizationApplicationService.findTopPersonCreditors()).thenReturn(list);

		// when
		List<OrganizationApplicant> result = organizationController.findTopPersonCreditors();

		// then
		assertThat(result.size()).isEqualTo(2);

		assertThat(result.get(0).getOrganizationId()).isEqualTo(organizationApplicant.getOrganizationId());

		assertThat(result.get(1).getOrganizationId()).isEqualTo(organizationApplicant1.getOrganizationId());
	}

	
}
