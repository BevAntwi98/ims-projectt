package com.qa.ims.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order>{

	public static final Logger LOGGER = Logger.getLogger(OrderController.class);
	
	private CrudServices<Order> orderService;
	
	public OrderController(CrudServices<Order> orderService) {
		this.orderService = orderService;
	}
	
 
	
	long getNumberInput() {
		return Utils.gettheInput();
	}
	
	double getNumInput() {
		return Utils.getNumInput();
		
	}
	/**
	 * Reads all customers to the logger
	 */
	@Override
	public List<Order> readAll() {
		List<Order> order = orderService.readAll();
		for(Order order: order) {
			LOGGER.info(order.toString());
		}
		return order;
	}

	/**
	 * Creates a customer by taking in user input
	 */
	@Override
	public Order create() {
		LOGGER.info("Welcome. Please enter your Customer ID");
		String itemName = getInput();
		LOGGER.info("Please enter the quantity");
		int quantity = getNumberInput();
		LOGGER.info("Now please enter the total price");
		double total_price = getNumInput();
		Items items = itemsService.create(new Order(itemName, quantity, total_price));
		LOGGER.info("Order Created!");
		return order;
	}

	/**
	 * Updates an existing customer by taking in user input
	 */
	@Override
	public Order update() {
		LOGGER.info("Please enter your customer ID: ");
		Long fkcustomer_ID = getInput();
		LOGGER.info("Please enter the new quantity: ");
		int quantity = getNumberInput();
		Items items = itemsService.update(new Items(itemName, quantity));
		LOGGER.info("Item: " + itemName +  " Updated!");
		return items;
	}

	/**
	 * Deletes an existing customer by the id of the customer
	 */
	@Override
	public void delete() {
		LOGGER.info("Please enter the ID of the order you would like to delete");
		Long id = Long.valueOf(gettheInput());
		orderService.delete(id);
		LOGGER.info("Order Deleted!");
		
	}
	
}




