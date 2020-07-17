package com.qa.ims.persistance.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.Ims;
import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.OrderDaoMysql;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.services.OrderServices;


@RunWith(MockitoJUnitRunner.class)
public class OrderDaoMysqlTest {
	
		/**
	     * The thing I want to fake functionality for
	     */
	    @Mock
	    private OrderServices orderServices;

	 

	    /**
	     * Spy is used because i want to mock some methods inside the item I'm testing
	     * InjectMocks uses dependency injection to insert the mock into the customer
	     * controller
	     */
	    @Spy
	    @InjectMocks
	    private OrderController orderController;
	    
	    
	    final Logger LOGGER = Logger.getLogger(OrderDaoMysqlTest.class);
	    
		@BeforeClass
		public static void Init() {
			Ims ims = new Ims();
			ims.init("jdbc:mysql:35.189.70.116:3306/ims_test?serverTimezone=UTC", "root", "root", null);
			

		}
		

//		@Test
//		public void CreateTest() {
//			OrderDaoMysql customerDao = new OrderDaoMysql("jdbc:mysql:35.189.70.116/ims_test?serverTimezone=UTC",
//					"root", "root");
//			Order order = new Order();
//			assertEquals(order, order.);
//		}

		@Test
		public void ReadAllTest() {
			OrderDaoMysql orderDao = new OrderDaoMysql("jdbc:mysql:35.189.70.116/ims_test?serverTimezone=UTC",
					"root", "root");
			List<Order> order = new ArrayList<>();
			order.add(new Order());
			order.add(new Order());
			assertEquals(order, orderDao.readAll());
		}

		@Test
		public void ReadLatestTest() {
			OrderDaoMysql orderDao = new OrderDaoMysql("jdbc:mysql:35.189.70.116/ims_test?serverTimezone=UTC",
					"root", "root");
			Order order = new Order();
			assertEquals(order, orderDao.readLatest());
		}
	    @Test
	    public void UpdateOrderTest() {
	    	OrderDaoMysql orderDao = new OrderDaoMysql("jdbc:mysql:35.189.70.116/ims_test?serverTimezone=UTC","root", "root");
	    	Order order = new Order();
	        assertEquals(order, orderDao.update(order));
	    }
//	    @Test
//	    @Ignore //junit breaks code
//	    public void DeleteOrderTest() {
//	        OrderDaoMysql orderDao = new OrderDaoMysql("jdbc:mysql:35.189.70.116/ims_test?serverTimezone=UTC", "root", "root");
//	       Order order = new Order();
//	        assertEquals(order, orderDao.delete(1L));
//	    }

}
