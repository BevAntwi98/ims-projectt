package com.qa.ims.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Items;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

public class ItemsController implements CrudController<Items>{

		public static final Logger LOGGER = Logger.getLogger(CustomerController.class);
		
		private CrudServices<Items> itemsService;
		
		public ItemsController(CrudServices<Items> itemsService) {
			this.itemsService = itemsService;
		}
		

		String getInput() {
			return Utils.getInput();
		}
		
		int getNumberInput() {
			return Utils.getNumberInput();
		}
		
		double getNumInput() {
			return Utils.getNumInput();
			
		}
		Long getLongInput() {
			return Utils.gettheInput();
		}
		/**
		 * Reads all customers to the logger
		 */
		@Override
		public List<Items> readAll() {
			List<Items> item = itemsService.readAll();
			for(Items items: item) {
				LOGGER.info(items.toString());
			}
			return item;
		}

		/**
		 * Creates a customer by taking in user input
		 */
		@Override
		public Items create() {
			LOGGER.info("Please enter the item name");
			String itemName = getInput();
			LOGGER.info("Please enter the quantity");
			int quantity = getNumberInput();
			LOGGER.info("Now please enter the total price");
			double total_price = getNumInput();
			Items items = itemsService.create(new Items(itemName, quantity, total_price));
			LOGGER.info("Item Created!");
			return items;
		}

		/**
		 * Updates an existing customer by taking in user input
		 */
		@Override
		public Items update() {
			LOGGER.info("Please enter the item name: ");
			String itemName = getInput();
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
			LOGGER.info("Please enter the id of the item you would like to delete");
			Long id = Long.valueOf(getInput());
			itemsService.delete(id);
			LOGGER.info("Item Deleted!");
			
		}
		
	}

