package com.qa.ims.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.Ims;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.services.CustomerServices;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {

	/**
	 * The thing I want to fake functionlity for
	 */
	@Mock
	private CustomerServices customerServices;

	/**
	 * Spy is used because i want to mock some methods inside the item I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the customer
	 * controller
	 */
	@Spy // for the methods in customerController
	@InjectMocks // for any classes our customerController calls (in this case customerService)
	private CustomerController customerController;
	
	@BeforeClass
	public static void Init() {
		Ims ims = new Ims();
		ims.init("jdbc:mysql:35.189.70.116:3306/ims_test?serverTimezone=UTC", "root", "root", null);
		

	}

	@Test
	public void readAllTest() {
		CustomerController customerController = new CustomerController(customerServices);
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer("Chris", "A", "ilovetupac@gmail.com","234 Fraudling Rd" , "bored"));
		customers.add(new Customer("Tifa", "L", "chocobogirl@mail.com", "19 Sector 7", "Avalanche"));
		customers.add(new Customer("Nic", "J", null, null, null));
		Mockito.when(customerServices.readAll()).thenReturn(customers);
		assertEquals(customers, customerController.readAll());
	}

	@Test
	public void createTest() {
		String id = "1";
		String first_Name = "Chris";
		String surname = "A";
		String email= "ilovetupac@gmail.com";
		 String address="234 Fraudling Rd";
		 String password="bored";
		Mockito.doReturn(first_Name, surname,email,address,password).when(customerController).getInput();
		Customer customer = new Customer(first_Name, surname,email,address,password);
		Customer savedCustomer = new Customer( "Chris", "A", "ilovetupac@gmail.com","234 Fraudling Rd" , "bored");
		Mockito.when(customerServices.create(customer)).thenReturn(savedCustomer);
		assertEquals(savedCustomer, customerController.create());
	}

	/**
	 *
	 */
	@Test
	public void updateTest() {
		String id = "1";
		String first_Name = "Tifa";
		String password = "Avalanche";
		Mockito.doReturn(id, first_Name, password).when(customerController).getInput();
		Customer customer = new Customer(1L, first_Name, password);
		Mockito.when(customerServices.update(customer)).thenReturn(customer);
		assertEquals(customer, customerController.update());
	}

	/**
	 * Delete doesn't return anything, so we can just verify that it calls the
	 * delete method
	 */
	@Test
	public void deleteTest() {
		String id = "1";
		Mockito.doReturn(id).when(customerController).getInput();
		customerController.delete();
		Mockito.verify(customerServices, Mockito.times(1)).delete(1L);
	}

}
