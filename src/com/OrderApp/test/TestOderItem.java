package com.OrderApp.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.OrderApp.DAOimp.CustomerImplementation;
import com.OrderApp.DAOimp.ItemDaoImp;
import com.OrderApp.Models.Customer;
import com.OrderApp.Models.Item;

public class TestOderItem {

	Customer customer;
	CustomerImplementation cust;
	
	Item item = null;
	ItemDaoImp itemDao = null;
	@Test
	public void test() {
		
//		customer = new Customer("Mohapi", "Mokoena", "Mohapi", "Male", "Home", "22222");
//		
//		cust = new CustomerImplementation();
//		
//		cust.addCustomer(customer);
		
		item = new Item();
		itemDao = new ItemDaoImp();
		item.setItemDescription("Dijo");
		item.setItemName("Papa");
		item.setItemPrice(12.25);
		
		itemDao.addItem(item);
	}

}
