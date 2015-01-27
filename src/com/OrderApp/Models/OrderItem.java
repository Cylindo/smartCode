package com.OrderApp.Models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "tblOrderItem")
@NamedQueries({
		@NamedQuery(name = "OderItem.byId", query = "from OrderItem where orderId=?"),
		@NamedQuery(name = "OrderItem.List", query = "from OrderItem") })
@XmlRootElement
public class OrderItem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "OrdeItemId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;
	
	@Column(name = "OrderDate")
	private Date orderdate;
	
	@Column(name = "TotalPrice")
	private double totalPrice;
	
	@ManyToOne
	@JoinColumn(name = "CustomerId")
	private Customer customers;

	@ManyToOne
	@JoinColumn(name = "ItemId")
	private Item item;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public Customer getCustomer() {
		return customers;
	}

	public void setCustomer(Customer customers) {
		this.customers = customers;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public OrderItem() {
		// TODO Auto-generated constructor stub
	}
}
