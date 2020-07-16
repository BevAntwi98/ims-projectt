package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DomainTest {
	
	
	@Test
	public void customerTest() {
		Domain domain = Domain.CUSTOMER;
		assertTrue(domain.getDescription().toLowerCase().contains("customers"));
	}
	
	@Test
	public void itemTest() {
		Domain domain = Domain.ITEM;
		assertTrue(domain.getDescription().toLowerCase().contains("Items"));
	}
	
	@Test
	public void orderTest() {
		Domain domain = Domain.ORDER;
		assertTrue(domain.getDescription().toLowerCase().contains("Orders"));
	}
	
	@Test
	public void stopTest() {
		Domain domain = Domain.STOP;
		assertTrue(domain.getDescription().toLowerCase().contains("close"));
	}

}
