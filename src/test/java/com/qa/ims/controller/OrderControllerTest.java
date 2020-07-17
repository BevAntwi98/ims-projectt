package com.qa.ims.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.domain.Order;

import com.qa.ims.services.OrderServices;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {
	

	Date date = new Date();

	/**
	 * The thing I want to fake functionlity for
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

	public void OrderController(OrderServices orderServices) {
		
	}

	@Test
	public void readAll() {
		OrderController orderController = new OrderController(orderServices);
		List<Order> order = new ArrayList<>();
		order.add(new Order(1L, 1L, "Shoes", date, 200.00));
		order.add(new Order(2L, 2L, "Pencil Case", date, 12.34));
		order.add(new Order(3L, 3L, "Lip" , date, 16.87));
		Mockito.when(orderServices.readAll()).thenReturn(order);
		assertEquals(order, orderController.readAll());
	}

	@Test
	public void create() {
//
//		Long customer_id = 1L;
//		String item_Name = "Shoes";
//		Date placed_date = date;
//		Double total_order = 200.00;
//		Mockito.doReturn(customer_id).when(orderController).getNumberInput();
//		Mockito.doReturn(placed_date).when(orderController).getTheDate();
//		Mockito.doReturn(total_order).when(orderController).getNumInput();
//		Order order = new Order( customer_id, item_Name, placed_date, total_order);
//		Order savedOrder = new Order(1L, 1L, "Shoes", date, 200.00);
//		Mockito.when(orderServices.create(order)).thenReturn(savedOrder);
//		assertEquals(savedOrder, orderController.create());
	}

	/**
	 *
	 */
//	@Test
//	public void updateTest() {
//		Long customer_id = 1L;
////		Date placed_date = date;
//		Double total_order = 0.00;
//		Mockito.doReturn(customer_id).when(orderController).getNumberInput();
////		Mockito.doReturn(placed_date).when(orderController).getTheDate();
//		Mockito.doReturn(total_order).when(orderController).getNumInput();
//		Order order = new Order(1L, 23.88);
//		Mockito.when(orderServices.update(order)).thenReturn(order);
////		assertEquals(order, orderController.update());
//	}

	/**
	 * Delete doesn't return anything, so we can just verify that it calls the
	 * delete method
	 */
//	@Test
//	public void deleteTest() {
//		String id = "1";
//		Mockito.doReturn(id).when(orderController).getInput();
//		orderController.delete();
//		Mockito.verify(orderServices, Mockito.times(1)).delete(1L);
//	}


}
