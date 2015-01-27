package com.OrderApp.DAOimp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;



import com.OrderApp.DAOint.CustomerInterface;
import com.OrderApp.Models.Customer;
import com.OrderApp.Utility.Utility;

public class CustomerImplementation implements CustomerInterface{

	@Override
	public void addCustomer(Customer customer) {
		
		SessionFactory session=Utility.getSessionFactory();
		Session sess=session.openSession();
		sess.beginTransaction();
		sess.saveOrUpdate(customer);
		sess.getTransaction().commit();
		sess.close();
	}

	@Override
	public void editCustomer(Customer customer,int cust_id) {
		SessionFactory session=Utility.getSessionFactory();
		Session sess=session.openSession();
		
		sess.beginTransaction();
		
		Customer cust=(Customer) sess.load(Customer.class,cust_id);
		cust.setAdress(customer.getAdress());
		cust.setGender(customer.getGender());
		cust.setName(customer.getName());
		cust.setSurname(customer.getSurname());
		sess.save(cust);
		sess.beginTransaction().commit();
		
		sess.close();
		
	}

	@Override
	public void delete(int cust_id) {
		
		SessionFactory session=Utility.getSessionFactory();
		Session sess=session.openSession();
		
		sess.beginTransaction();
		
		Customer customer=(Customer)sess.load(Customer.class,cust_id);
		
		sess.delete(customer);
		sess.getTransaction().commit();
		sess.close();
		
	}

	@Override
	public List<Customer> viewAllCustomers() {
		
		SessionFactory session=Utility.getSessionFactory();
		Session sess=session.openSession();
		
		sess.beginTransaction();
		
		org.hibernate.Query query=sess.createQuery("from Customer");
        @SuppressWarnings("unchecked")
		List<Customer> list=query.list();
	
		return list;
	}

	@Override
	public Customer getCustomer(int cust_id) {
		
		SessionFactory session=Utility.getSessionFactory();
		Session sess=session.openSession();

		sess.beginTransaction();
		
		org.hibernate.Query query=sess.createQuery("from Customer Where cust_Id="+cust_id);
		
		Customer customer=(Customer)query; 
		
        
		return customer;
	}

}
