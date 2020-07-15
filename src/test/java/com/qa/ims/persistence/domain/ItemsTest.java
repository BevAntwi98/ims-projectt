package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ItemsTest {
	
	private Items item;
	private Items other;
	
	@Before
	public void setUp() {
		item = new Items("Banana", 6, 12.67);
		other = new Items("Monokuma Plushie", 1, 30.50);
	}
	
	@Test
	public void settersTest() {
		assertNotNull(item.getId());
		assertNotNull(item.getItem_name());
		assertNotNull(item.getQuantity());
		assertNotNull(item.getTotal_price());
		
		
		item.setId(null);
		assertNull(item.getId());
		item.setItem_name(null);
		assertNull(item.getItem_name());
		item.setQuantity((Integer) null);
		assertNull(item.getQuantity());
		item.setTotal_price((Double) null);
		assertNull(item.getTotal_price());
	
	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(item.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(item.equals(new Object()));
	}
	
	@Test
	public void createItemWithId() {
		assertEquals(1, item.getId(), 0);
		assertEquals("Guitar",item.getItem_name());
		assertEquals(3, item.getQuantity());
		assertEquals(130.00, item.getTotal_price());
		
	}
	
	@Test
	public void checkEquality() {
		assertTrue(item.equals(item));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(other.equals(other));
	}
	
	@Test
	public void itemNameNullButOtherNameNotNull() {
		item.setItem_name(null);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void itemNameNotEqual() {
		other.setItem_name("rhys");
		assertFalse(item.equals(other));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNullName() {
		item.setItem_name(null);
		other.setItem_name(null);
		assertTrue(other.equals(null));
	}
	
	@Test
	public void nullId() {
		item.setId(null);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void nullIdOnBoth() {
		item.setId(null);
		other.setId(null);
		assertTrue(item.equals(item));
		assertTrue(other.equals(other));
	}
	
	@Test
	public void otherIdDifferent() {
		other.setId(2L);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void nullItem_name() {
		item.setItem_name(null);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void nullItem_nameOnBoth() {
		item.setItem_name(null);
		other.setItem_name(null);
		assertTrue(item.equals(item));
		assertTrue(other.equals(other));
	}
	
	@Test
	public void otherItem_nameDifferent() {
		other.setItem_name("Sweets");
		assertFalse(item.equals(other));
	}
	@Test
	public void nullQuantity(int quantity) {
		item.setQuantity((Integer) null);
		assertFalse(item.equals(other));
	}
	
	@SuppressWarnings("null")
	@Test
	public void nullQuantityOnBoth() {
		item.setQuantity((Integer) null);;
		other.setQuantity((Integer) null);
		assertTrue(item.equals(item));
		assertTrue(other.equals(other));
	}
	
	@Test
	public void otherQuantityDifferent() {
		other.setQuantity(23);
		assertFalse(item.equals(other));
	}
	
	public void nullTotal_order() {
		item.setTotal_price( null);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void nullTotal_orderOnBoth() {
		item.setTotal_order(null);;
		other.setTotal_order(null);
		assertTrue(item.equals(item));
		assertTrue(other.equals(other));
	}
	
	@Test
	public void otherTotal_orderDifferent() {
		other.setTotal_order(16.78);
		assertFalse(item.equals(other));
	}

	
	@Test
	public void constructorWithoutId() {
		Items items = new Items("Kente Bonnet",1, 24.55 );
		assertNull(items.getId());
		assertNotNull(items.getItem_name());
		assertNotNull(items.getQuantity());
		assertNotNull(items.getTotal_price());
		
	}
	}
	
	
//	
//	@Test
//	public void hashCodeTest() {
//		assertEquals(customer.hashCode(), other.hashCode());
//	}
//	@Test
//	public void hashCodeTestWithNull() {
//		Customer customer = new Customer(null, null, null,null,null);
//		Customer other = new Customer(null, null, null, null, null);
//		assertEquals(customer.hashCode(), other.hashCode());
//	}
//	
//	@Test
//	public void toStringTest() {
//		String toString = "id:1 customer_name: Emilia customer_lastname: Adu";
//		assertEquals(toString, customer.toString());
//	}
//}



