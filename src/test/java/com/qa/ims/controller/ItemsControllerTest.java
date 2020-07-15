package com.qa.ims.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.domain.Items;
import com.qa.ims.services.ItemsServices;

@RunWith(MockitoJUnitRunner.class)
public class ItemsControllerTest {

	/**
	 * The thing I want to fake functionlity for
	 */
	@Mock
	private ItemsServices itemsServices;

	/**
	 * Spy is used because i want to mock some methods inside the item I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the customer
	 * controller
	 */
	@Spy // for the methods in customerController
	@InjectMocks // for any classes our customerController calls (in this case customerService)
	private ItemsController itemsController;

	@Test
	public void readAllTest() {
		ItemsController itemsController = new ItemsController(itemsServices);
		List<Items> item = new ArrayList<>();
		item.add(new Items("Hogwarts Ticket", 1, 0.00));
		item.add(new Items("Chantel and Pedro Show FINALE VIP Pass",6,657.00));
		item.add(new Items("Kente Bonnet", 2, 24.55));
		Mockito.when(itemsServices.readAll()).thenReturn(item);
		assertEquals(item, itemsController.readAll());
	}

	@Test
	public void createTest() {
		String item_Name = "Hogwarts Ticket";
		int quantity= 1;
		double total_order= 0.00;
		Mockito.doReturn(item_Name).when(itemsController).getInput();
		Mockito.doReturn(quantity).when(itemsController).getNumberInput();
		Mockito.doReturn(total_order).when(itemsController).getNumInput();
		Items item = new Items("Hogwarts Ticket", 1, 0.00);
		Items savedItems = new Items("Hogwarts Ticket", 1, 0.00);
		Mockito.when(itemsServices.create(item)).thenReturn(savedItems);
		assertEquals(savedItems, itemsController.create());
	}

	/**
	 *
	 */
	@Test
	public void updateTest() {
		String item_Name = "Hogwarts Ticket";
		int quantity = 2;
		Mockito.doReturn(item_Name).when(itemsController).getInput();
		Mockito.doReturn(quantity).when(itemsController).getNumberInput();
		Items Item = new Items("Hogwarts Ticket",2);
		Mockito.when(itemsServices.update(Item)).thenReturn(Item);
		assertEquals(Item, itemsController.update());
	}


	/**
	 * Delete doesn't return anything, so we can just verify that it calls the
	 * delete method
	 */
	@Test
	public void deleteTest() {
		Long id = 1L;
		Mockito.doReturn(id).when(itemsController).getLongInput();
		itemsController.delete();
		Mockito.verify(itemsServices, Mockito.times(1)).delete(1L);
	}

}
