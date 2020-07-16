package com.qa.ims.persistance.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.Ims;
import com.qa.ims.controller.CustomerController;
import com.qa.ims.controller.ItemsController;
import com.qa.ims.persistence.dao.CustomerDaoMysql;
import com.qa.ims.persistence.dao.ItemsDaoMysql;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Items;
import com.qa.ims.services.ItemsServices;

@RunWith(MockitoJUnitRunner.class)
public class ItemDaoMysqlTest {

	/**
     * The thing I want to fake functionality for
     */
    @Mock
    private ItemsServices itemsServices;

 

    /**
     * Spy is used because i want to mock some methods inside the item I'm testing
     * InjectMocks uses dependency injection to insert the mock into the customer
     * controller
     */
    @Spy
    @InjectMocks
    private  ItemsController itemController;
    
    
    final Logger LOGGER = Logger.getLogger(ItemDaoMysqlTest.class);
    
	@BeforeClass
	public static void Init() {
		Ims ims = new Ims();
		ims.init("jdbc:mysql:35.189.70.116:3306/ims_test?serverTimezone=UTC", "root", "root", null);	
	}
	

	@Test
	public void CreateTest() {
		ItemsDaoMysql itemDao = new ItemsDaoMysql("jdbc:mysql:35.189.70.116/ims_test?serverTimezone=UTC",
				"root", "root");
		Items item = new Items();
		assertEquals(item, itemDao.readAll());
	}

	@Test
	public void ReadAllTest() {
		ItemsDaoMysql itemDao= new ItemsDaoMysql("jdbc:mysql:35.189.70.116/ims_test?serverTimezone=UTC",
				"root", "root");
		List<Items> item = new ArrayList<>();
		item.add(new Items("Lightbulb", 3, 46.88 ));
		item.add(new Items("Charger cable", 2, 14.99));
		assertEquals(item, itemDao.readAll());
	}

	@Test
	public void ReadLatestTest() {
		ItemsDaoMysql itemDao = new ItemsDaoMysql("jdbc:mysql:35.189.70.116/ims_test?serverTimezone=UTC",
				"root", "root");
		Items item = new Items();
		assertEquals(item, itemDao.readLatest());
	}
    @Test
    public void UpdateItemTest() {
    	ItemsDaoMysql itemDao = new ItemsDaoMysql("jdbc:mysql:35.189.70.116/ims_test?serverTimezone=UTC","root", "root");
        String item_name= "Lightbulb";
        int quantity = 1;
        Items item = new Items("Lightbulb",1);
        assertEquals(item, itemDao.update(item));
    }

}
