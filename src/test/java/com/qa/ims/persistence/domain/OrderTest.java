package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class OrderTest {
	private Order order;
	private Order other;
	Date date = new Date();

	@Before
	public void setUp() {
		order = new Order(1L, 1L, "Off White Sweatshirt", date, 150.99);
		other = new Order(2L, 2L, "Summer Dress", date, 21.54);
	}

	@Test
	public void settersTest() {
		assertNull(order.getOrder_id());
		assertNotNull(order.getCustomer_id());
		assertNotNull(order.getPlaced_date());
		assertNotNull(order.getTotal_order());
		assertNotNull(order.addItemToOrder());

		order.setOrder_id(null);
		assertNull(order.getOrder_id());
		order.setCustomer_id(null);
		assertNull(order.getCustomer_id());
		order.setItem_name(null);
		assertNull(order.getItem_name());
		order.setPlaced_date(null);
		assertNull(order.getPlaced_date());
		order.setTotal_order(0);
		assertNull(order.getTotal_order());

	}

	@Test
	public void equalsWithNull() {
		assertFalse(order.equals(null));
	}

	@Test
	public void equalsWithDifferentObject() {
		assertFalse(order.equals(new Object()));
	}

	@Test
	public void createOrderWithId() {
		assertEquals(1L, order.getOrder_id(), 0);
	}

	@Test
	public void checkEquality() {
		assertTrue(order.equals(order));
	}

	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(other.equals(other));
	}

	@Test
	public void orderidNullButOtherNameNotNull() {
		order.setOrder_id(null);
		assertFalse(order.equals(other));
	}

	@Test
	public void orderidNotEqual() {
		other.setOrder_id(3L);
		assertFalse(order.equals(other));
	}

	@Test
	public void checkEqualityBetweenDifferentObjectsOrderId() {
		order.setOrder_id(null);;
		other.setOrder_id(null);
		assertTrue(order.equals(null));
		assertTrue(other.equals(null));
	}

	@Test
	public void nullOrderId() {
		order.setOrder_id(null);
		assertFalse(order.equals(other));
	}

	@Test
	public void nullIdOnBoth() {
		order.setCustomer_id(null);
		other.setOrder_id(null);
		assertTrue(order.equals(order));
		assertTrue(other.equals(other));
	}

	@Test
	public void otherIdDifferent() {
		other.setOrder_id(2L);
		assertFalse(order.equals(other));
	}
	
	
	@Test
	public void nullCustomerId() {
		order.setCustomer_id(null);
		assertFalse(order.equals(other));
	}

	@Test
	public void nullCustomerIdOnBoth() {
		order.setCustomer_id(null);
		other.setCustomer_id(null);
		assertTrue(order.equals(order));
		assertTrue(other.equals(other));
	}

	@Test
	public void otherCustomerIdDifferent() {
		other.setCustomer_id(4L);
		assertFalse(order.equals(other));
	}

	@Test

	public void nullPlaced_date() {
		order.setPlaced_date(null);
		assertFalse(order.equals(other));
	}

	@Test
	public void nullPlaced_dateOnBoth() {
		order.setPlaced_date(null);
		other.setPlaced_date(null);
		assertTrue(order.equals(order));
		assertTrue(other.equals(other));
	}

	@Test
	public void otherPlaced_dateDifferent() {
		other.setPlaced_date(date);
		assertFalse(order.equals(other));
	}

//	@Test
//
//	public void nullTotal_order() {
//		order.setTotal_order(null);
//		assertFalse(order.equals(other));
//	}
//
//	@Test
//	public void nullTotal_orderOnBoth() {
//		order.setTotal_order(null);
//		other.setTotal_order(null);
//		assertTrue(order.equals(order));
//		assertTrue(other.equals(other));
//	}
//
//	@Test
//	public void otherTotal_orderDifferent() {
//		other.setTotal_order(date);
//		assertFalse(order.equals(other));
//	}
	@Test
	public void constructorWithoutOrderId() {
		Order order = new Order(null, 1L, "Off White Sweatshirt", date, 150.99);
		assertNull(order.getOrder_id());
		assertNotNull(order.getCustomer_id());
		assertNotNull(order.getPlaced_date());
		assertNotNull(order.getItem_name());
		assertNotNull(order.getTotal_order());
	}

	@Test
	public void constructorWithoutCustomerId() {
		Order order = new Order(1L, null, "Off White Sweatshirt", date, 150.99);
		assertNotNull(order.getOrder_id());
		assertNull(order.getCustomer_id());
		assertNotNull(order.getItem_name());
		assertNotNull(order.getPlaced_date());
		assertNotNull(order.getTotal_order());
	}

	@Test
	public void hashCodeTest() {
		assertEquals(order.hashCode(), other.hashCode());
	}

	@Test
	public void hashCodeTestWithNull() {
		Order order = new Order(null, null, null, null, 0);
		Order other = new Order(null, null, null, null, 0);
		assertEquals(order.hashCode(), other.hashCode());
	}

	@Test
	public void toStringTest() {
		String toString = "order_id=1, fkustomer_id=1, item_Name=Off White Sweatshirt, placed_date= placed_date, total_order=21.54";
		assertEquals(toString, order.toString());
	}
}
