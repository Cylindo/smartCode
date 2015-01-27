package com.OrderApp.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.OrderApp.DAOimp.CustomerImplementation;
import com.OrderApp.DAOimp.ItemDaoImp;
import com.OrderApp.DAOimp.OrderItemImpl;
import com.OrderApp.Models.Customer;
import com.OrderApp.Models.Item;
import com.OrderApp.Models.OrderItem;

public class TestOderss {

	
	Customer customer;
	CustomerImplementation cust;
	
	Item item = null;
	ItemDaoImp itemDao = null;
	 OrderItem orderItem = null;
	 OrderItemImpl orderImpl = null;
	@Test
	public void test() {
		itemDao = new ItemDaoImp();
		cust = new CustomerImplementation();
		
		
		orderImpl = new OrderItemImpl();
		orderItem = new OrderItem();
		
		
		customer = cust.getCustomer(1);
		assertNotNull(customer);
		
		
		
	}

}
