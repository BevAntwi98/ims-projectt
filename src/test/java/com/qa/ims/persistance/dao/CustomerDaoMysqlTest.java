package com.qa.ims.persistance.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.Ims;
import com.qa.ims.controller.CustomerController;
import com.qa.ims.persistence.dao.CustomerDaoMysql;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.services.CustomerServices;

@RunWith(MockitoJUnitRunner.class)
public class CustomerDaoMysqlTest {
	/**
     * The thing I want to fake functionality for
     */
    @Mock
    private CustomerServices customerServices;

 

    /**
     * Spy is used because i want to mock some methods inside the item I'm testing
     * InjectMocks uses dependency injection to insert the mock into the customer
     * controller
     */
    @Spy
    @InjectMocks
    private CustomerController customerController;
    
    
    final Logger LOGGER = Logger.getLogger(CustomerDaoMysqlTest.class);
    
	@BeforeClass
	public static void Init() {
		Ims ims = new Ims();
		ims.init("jdbc:mysql:35.189.70.116:3306/ims_test?serverTimezone=UTC", "root", "root", null);
		

	}
	

	@Test
	public void CreateTest() {
		CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql("jdbc:mysql:35.189.70.116/ims_test?serverTimezone=UTC",
				"root", "root");
//		String first_Name = "Akwua";
//		String surname = "Antwi";
//		String email = "oskarsmom@gmail.com";
//		String address = "234 Amnesia Rd";
//		String password = "gimme bacchos";
		Customer customer = new Customer("Akwua", "Antwi", "oskarsmom@gmail.com", "234 Amnesia Rd", "gimme bacchos");
		assertEquals(customer, customerDaoMysql.create(customer));
//		String first_Name2 = "Effia";
//		String surname2 = "Adu";
//		String email2 = "yesgawd@gmail.com";
//		String address2 = "3 Plantain Rd";
//		String password2 = "gimme moimoi gimme moimoi";
		Customer customer2 = new Customer("Effia", "Adu", "yesgawd@gmail.com", "3 Plantain Rd","gimme moimoi gimme moimoi");
		assertEquals(customer2, customerDaoMysql.create(customer2));
	}

	@Test
	public void ReadAllTest() {
		CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql("jdbc:mysql:35.189.70.116/ims_test?serverTimezone=UTC",
				"root", "root");
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer("Akwua", "Antwi", "oskarsmom@gmail.com", "234 Amnesia Rd", "gimme bacchos"));
		customers.add(new Customer("Effia", "Adu", "yesgawd@gmail.com", "3 Plantain Rd", "gimme moimoi gimme moimoi"));
		assertEquals(customers, customerDaoMysql.readAll());
	}

	@Test
	public void ReadLatestTest() {
		CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql("jdbc:mysql:35.189.70.116/ims_test?serverTimezone=UTC",
				"root", "root");
		Customer customers = new Customer("Effia", "Adu", "yesgawd@gmail.com", "3 Plantain Rd","gimme moimoi gimme moimoi");
		assertEquals(customers, customerDaoMysql.readLatest());
	}
    @Test
    public void UpdateCustomerTest() {
        CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql("jdbc:mysql:35.189.70.116/ims_test?serverTimezone=UTC","root", "root");
        Long id = 1L;
        String first_Name = "Akwua";
        String password = "qwerty";
        Customer customers = new Customer( "Akwua",null,null,null,"querty");
        assertEquals(customers, customerDaoMysql.update(customers));
    }
//    @Test
//    public void DeleteCustomerTest() {
//        CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql("jdbc:mysql:35.189.70.116/ims_test?serverTimezone=UTC", "root", "root");
//        Long id = 1L;
//        Customer customer = new Customer(1L,null,null);
//        assertEquals(customer, customerDaoMysql.delete(id));
//    }
//
//
//
//
//

}
