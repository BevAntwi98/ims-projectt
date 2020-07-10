package com.qa.ims.services;

import java.util.List;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Items;

public class ItemsServices implements CrudServices<Items> {

	private Dao<Items> itemsDao;

	// something here

	
	public ItemsServices(Dao<Items> itemsDao) {
		this.itemsDao = itemsDao;
	}

	@Override
	public List<Items> readAll() {
		return itemsDao.readAll();
	}

	@Override
	public Items create(Items items) {
		return itemsDao.create(items);
	}

	@Override
	public Items update(Items items) {
		return itemsDao.update(items);
	}

	@Override
	public void delete(Long id) {
		itemsDao.delete(id);

	}

}
