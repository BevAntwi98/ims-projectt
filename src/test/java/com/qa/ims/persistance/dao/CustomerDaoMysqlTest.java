package com.qa.ims.persistance.dao;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.Ims;
import com.qa.ims.persistence.dao.CustomerDaoMysql;
import com.qa.ims.persistence.domain.Customer;

public class CustomerDaoMysqlTest {

   
   
    @BeforeClass
    public static void Init() {
        Ims ims = new Ims();
        ims.init("jdbc:mysql:<YOUR_IP>", "root", "root", "src/test/resources/sql-schema.sql");
        final Logger LOGGER = Logger.getLogger(CustomerDaoMysqlTest.class);
	
    }


//    @Test
//    public void CreateTest() {
//        CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql("root", "root");
//        String first_Name = "Akwua";
//        String surname = "Antwi";
//        String email= "oskarsmom@gmail.com";
//        String address="234 Amnesia Rd";
//        String password="gimme bacchos";
//        Customer customer = new Customer("Akwua","Antwi","oskarsmom@gmail.com","234 Amnesia Rd","gimme bacchos");
//        assertEquals(customer, customerDaoMysql.create(customer));
//    }
//    
//    @Test
//    public void ReadCustomerTest() {
//        CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql("root", "root");
//        Long id = 1L;
//        Customer customer = new Customer(2L, null, null);
//        assertEquals(customer, customerDaoMysql.readCustomer(id));
//    }
//    @Test
//    public void UpdateCustomerTest() {
//        CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql("root", "root");
//        Long id = 1L;
//        String first_Name = "Akwua";
//        String password = "qwerty";
//        Customer customer = new Customer(2L, first_Name, password);
//        assertEquals(customer, customerDaoMysql.update(customer));
//    }
//    @Test
//    public void DeleteCustomerTest() {
//        CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql("root", "root");
//        Long id = 1L;
//        
//        Customer customer = new Customer(1L, null, null);
//        assertEquals(customer, customerDaoMysql.delete(id););
//    }
//
//
//
//
//

}
