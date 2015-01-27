package com.OrderApp.DAOimp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.OrderApp.DAOint.ItemDao;
import com.OrderApp.Models.Item;
import com.OrderApp.Utility.Utility;

public class ItemDaoImp implements ItemDao {

	public void addItem(Item itemModel) {

		SessionFactory sessionfactory = Utility.getSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		session.save(itemModel);
		session.getTransaction().commit();
		session.close();

	}

	public Item searchItem(int itemId) {

		Item item = new Item();

		SessionFactory sessionfactory = Utility.getSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		item = (Item) session.get(Item.class, itemId);
		session.getTransaction().commit();
		session.close();

		return item;
	}

	public List<Item> getAllItems() {

		SessionFactory sessionfactory = Utility.getSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Item> list = (List<Item>) session.createCriteria(Item.class)
				.list();
		session.getTransaction().commit();
		session.close();

		return list;
	}
}
