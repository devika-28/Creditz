package com.impetus.service;

import com.impetus.repository.OrganizationApplicationRepository;
import com.impetus.repository.OrganizationRepository;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.impetus.model.Organization;
import com.impetus.model.OrganizationApplicant;
import com.impetus.model.User;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TestOrganizationApplicationService {

	@Mock
	private OrganizationApplicationRepository organizationApplication;

	@Mock
	private OrganizationRepository organization;

	@InjectMocks
	private OrganizationApplicationServiceImplementation organizationApplicationService;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void findApplicants()

	{
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
		list.add(organizationApplicant1);
		list.add(organizationApplicant);

		when(organizationApplication.findByemailStatus("False")).thenReturn(list);

		List<OrganizationApplicant> empList = organizationApplicationService.findApplicants();

		assertEquals(2, empList.size());
		verify(organizationApplication, times(1)).findByemailStatus("False");
	}

	@Test
	public void getAllApplicants()

	{
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
		list.add(organizationApplicant1);
		list.add(organizationApplicant);

		when(organizationApplication.findAll()).thenReturn(list);

		List<OrganizationApplicant> empList = organizationApplicationService.getAllOrganizationApplicant();

		assertEquals(2, empList.size());
		verify(organizationApplication, times(1)).findAll();
	}

	@Test
	public void getAllTopCreditors()

	{
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
		organizationApplicant.setApplicationStatus("Approved");
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
		organizationApplicant1.setApplicationStatus("Approved");
		organizationApplicant1.setUserId(user1);
		organizationApplicant1.setOrganizationId(organization1);
		list.add(organizationApplicant1);
		list.add(organizationApplicant);

		when(organizationApplication.findTopPersonCreditors("Approved")).thenReturn(list);

		List<OrganizationApplicant> empList = organizationApplicationService.findTopPersonCreditors();

		assertEquals(2, empList.size());
		verify(organizationApplication, times(1)).findTopPersonCreditors("Approved");
	}

	@Test
	public void getHistory()

	{
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
		organizationApplicant.setApplicationStatus("Approved");
		organizationApplicant.setOrganizationId(organization);

		OrganizationApplicant organizationApplicant1 = new OrganizationApplicant();

		organizationApplicant1.setBusinessAge(12);
		organizationApplicant1.setApplicationId(12);
		organizationApplicant1.setEmployeeCount(123);
		organizationApplicant1.setEmailStatus("False");
		organizationApplicant1.setLoanAmount(5000000);
		organizationApplicant1.setLoanTenure(12);
		organizationApplicant1.setApplicationStatus("Approved");
		organizationApplicant1.setUserId(user);
		organizationApplicant1.setOrganizationId(organization);
		list.add(organizationApplicant1);
		list.add(organizationApplicant);

		when(organizationApplication.findByUserId(106)).thenReturn(list);

		List<OrganizationApplicant> empList = organizationApplicationService.getHistory(organizationApplicant1);

		assertEquals(2, empList.size());
		verify(organizationApplication, times(1)).findByUserId((organizationApplicant1.getUserId()).getUserId());
	}

}
