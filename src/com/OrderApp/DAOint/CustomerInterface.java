package com.OrderApp.DAOint;

import java.util.List;

import com.OrderApp.Models.Customer;


public interface CustomerInterface {

	void addCustomer(Customer customer);
	void editCustomer(Customer customer,int cust_id);
	void delete(int cust_id);
	List<Customer> viewAllCustomers();
	Customer getCustomer(int cust_id);
}
