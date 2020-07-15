package com.qa.ims.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Items;

public class ItemsServicesTest{


@Mock
private Dao<Items> itemsDao;

@InjectMocks
private ItemsServices itemsServices;

@Test
public void itemsServicesCreate() {
	Items item = new Items("PS5 that looks like cake", 1, 90.2);
	itemsServices.create(item);
	Mockito.verify(itemsDao, Mockito.times(1)).create(item);
}



@Test
public void itemsServicesRead() {
	itemsServices.readAll();
	Mockito.verify(itemsDao, Mockito.times(1)).readAll();
}

@Test
public void itemsServicesUpdate() {
	Items item = new Items("PS5 that looks like cake", 2);
	itemsServices.update(item);
	Mockito.verify(itemsDao, Mockito.times(1)).update(item);
}

@Test
public void itemsServicesDelete() {
	itemsServices.delete(1L);;
	Mockito.verify(itemsDao, Mockito.times(1)).delete(1L);
}

}
