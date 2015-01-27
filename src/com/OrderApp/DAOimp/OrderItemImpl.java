package com.OrderApp.DAOimp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.OrderApp.DAOint.OrderItemDao;
import com.OrderApp.Models.OrderItem;
import com.OrderApp.Utility.Utility;

public class OrderItemImpl implements OrderItemDao{

	
	SessionFactory sessionFactory = null;
	Session session = null;
	@Override
	public Integer saveOrderItem(OrderItem orderItem) {
		sessionFactory = Utility.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(orderItem);
		session.getTransaction().commit();
		session.close();
		return orderItem.getOrderId();
	}

	@Override
	public Integer updateOrderItem(OrderItem orderItem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderItem searchOderItem(Integer orderItemId) {
		sessionFactory = Utility.getSessionFactory();
		session= sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("OderItem.byId");
		query.setInteger(0, orderItemId);
		OrderItem orderItem = (OrderItem) query.uniqueResult();
		
		return orderItem;
	}

	@Override
	public Integer deleteOrderItem(OrderItem orderItem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderItem> orderItemList() {
		sessionFactory = Utility.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("OrderItem.List");
		List<OrderItem> orderItemList = query.list();
		session.close();
		return orderItemList;
	}

}
