package com.OrderApp.DAOint;

import java.util.List;

import com.OrderApp.Models.OrderItem;


public interface OrderItemDao {
	public Integer saveOrderItem(OrderItem orderItem);
	public Integer updateOrderItem(OrderItem orderItem);
	public OrderItem searchOderItem(Integer orderItemId);
	public Integer deleteOrderItem(OrderItem orderItem);
	public List<OrderItem> orderItemList();

}
