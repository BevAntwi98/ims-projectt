package com.qa.ims.controller;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Spy;

import com.qa.ims.Ims;
import com.qa.ims.persistance.dao.CustomerDaoMysqlTest;

public class ActionControllerTest {

	final Logger LOGGER = Logger.getLogger(Action.class);

	@Spy //
	@InjectMocks
	private Action action;

	@BeforeClass
	public static void Init() {
		Ims ims = new Ims();
		ims.init("jdbc:mysql:35.189.70.116:3306/ims_test?serverTimezone=UTC", "root", "root", null);
	}

	@Before
	public void setUp() {
		Action action;
	}

	@Test
	 public void StringActionTestCREATE() {
		
	 }

	public void printActionsTestREAD() {
        action.READ.getDescription();
	}

	public void printActionsTestUPDATE() {

	}

	public void printActionsTestDELETE() {

	}

}
