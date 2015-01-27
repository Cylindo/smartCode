package com.OrderApp.DAOint;

import java.util.List;

import com.OrderApp.Models.Item;

public interface ItemDao {
	public void addItem(Item itemModel);
	public Item searchItem(int itemId);
	 public List<Item> getAllItems();
}
