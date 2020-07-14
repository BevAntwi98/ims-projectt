package com.qa.ims.controller;

import java.sql.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {

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
		List<Order> orders = orderService.readAll();
		for (Order order : orders) {
			LOGGER.info(order.toString());
		}
		return orders;
	}

	/**
	 * Creates a customer by taking in user input
	 */
	@Override
	public Order create() {
		LOGGER.info("Welcome. Please enter your Customer ID");
		Long customer_id= getNumberInput();
		LOGGER.info("Date of Order placed: ");
		// Date placed_date = getNumberInput();
		LOGGER.info("Total: £");
		double total_order = getNumInput();
		Order order = orderService.create(new Order(customer_id, placed_date, total_order));
		LOGGER.info("Order Created!");
		return order;
	}

	/**
	 * Updates an existing customer by taking in user input
	 */
	@Override
	public Order update() {
		LOGGER.info("Please enter your Customer ID: ");
		Long fkcustomer_id = getNumberInput();
		LOGGER.info("Please enter the new total: £");
		double total_order= getNumInput();
		Order order = orderService.create(new Order(fkcustomer_id,total_order));
		LOGGER.info("Order: " + order.getOrder_id() + " Updated!");
		return order;
	}

	/**
	 * Deletes an existing customer by the id of the customer
	 */
	@Override
	public void delete() {
		LOGGER.info("Please enter the ID of the order you would like to delete");
		Long id = Long.valueOf(getNumberInput());
		orderService.delete(id);
		LOGGER.info("Order Deleted!");

	}

}
