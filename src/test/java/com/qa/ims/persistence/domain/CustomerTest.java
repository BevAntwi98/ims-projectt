package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {
	
	private Customer customer;
	private Customer other;
	
	@Before
	public void setUp() {
		customer = new Customer("Emilia", "Adu", "a@gmail.com", "1 Kumasi Rd","90dayfiancay");
		other = new Customer( "Tony", "Antwi", "tony@gmail.com", "233 Kaabroni Street", "strugglelife");
	}
	
	@Test
	public void settersTest() {
		assertNull(customer.getId());
		assertNotNull(customer.getFirstName());
		assertNotNull(customer.getSurname());
		assertNotNull(customer.getEmail());
		assertNotNull(customer.getAddress());
		assertNotNull(customer.getPassword());
		
		customer.setId(null);
		assertNull(customer.getId());
		customer.setFirstName(null);
		assertNull(customer.getFirstName());
		customer.setSurname(null);
		assertNull(customer.getSurname());
		customer.setEmail(null);
		assertNull(customer.getEmail());
		customer.setAddress(null);
		assertNull(customer.getAddress());
		customer.setPassword(null);
		assertNull(customer.getPassword());
	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(customer.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(customer.equals(new Object()));
	}
	
	@Test
	public void createCustomerWithId() {
		assertEquals(1L, customer.getId(),0);
		assertEquals("Emilia", customer.getFirstName());
		assertEquals("Adu", customer.getSurname());
		assertEquals("emils@gmail.co.uk", customer.getEmail());
		assertEquals("64 Zoo Lane",customer.getAddress());
		assertEquals("dfghjkl",customer.getPassword());
	}
	
	@Test
	public void checkEquality() {
		assertTrue(customer.equals(customer));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(other.equals(other));
	}
	
	@Test
	public void customerNameNullButOtherNameNotNull() {
		customer.setFirstName(null);
		assertFalse(customer.equals(other));
	}
	
	@Test
	public void customerNamesNotEqual() {
		other.setFirstName("rhys");
		assertFalse(customer.equals(other));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNullName() {
		customer.setFirstName(null);
		other.setFirstName(null);
		assertTrue(customer.equals(customer));
	}
	
	@Test
	public void nullId() {
		customer.setId(null);
		assertFalse(customer.equals(other));
	}
	
	@Test
	public void nullIdOnBoth() {
		customer.setId(null);
		other.setId(null);
		assertTrue(customer.equals(customer));
		assertTrue(other.equals(other));
	}
	
	@Test
	public void otherIdDifferent() {
		other.setId(2L);
		assertFalse(customer.equals(other));
	}
	
	@Test
	public void nullSurname() {
		customer.setSurname(null);
		assertFalse(customer.equals(other));
	}
	
	@Test
	public void nullSurnameOnBoth() {
		customer.setSurname(null);
		other.setSurname(null);
		assertTrue(customer.equals(customer));
		assertTrue(other.equals(other));
	}
	
	@Test
	public void otherSurnameDifferent() {
		other.setSurname("antwi");
		assertFalse(customer.equals(other));
	}
	
	@Test
	public void constructorWithoutId() {
		Customer customer = new Customer("Emilia", "Adu", "emils@gmail.co.uk","64 Zoo Lane", "dfghjkl" );
		assertNull(customer.getId());
		assertNotNull(customer.getFirstName());
		assertNotNull(customer.getSurname());
		assertNotNull(customer.getEmail());
		assertNotNull(customer.getAddress());
		assertNotNull(customer.getPassword());
		
	}
	
	@Test
	public void hashCodeTest() {
		assertEquals(customer.hashCode(), other.hashCode());
	}
	@Test
	public void hashCodeTestWithNull() {
		Customer customer = new Customer(null, null, null,null,null);
		Customer other = new Customer(null, null, null, null, null);
		assertEquals(customer.hashCode(), other.hashCode());
	}
	
	@Test
	public void toStringTest() {
		String toString = "id=null, customer_name=Emilia, customer_lastname=Adu, email=a@gmail.com, address=1 Kumasi Rd, password=90dayfiancay]" ;
		assertEquals(toString, customer.toString());
	}
}
