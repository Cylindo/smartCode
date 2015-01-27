package com.OrderApp.Models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "tblItem")
@XmlRootElement
public class Item {
	@Id
	@GeneratedValue
	@Column(name = "Item_Id")
	private int itemId;

	@Column(name = "Item_Name")
	private String itemName;

	@Column(name = "Item_Description")
	private String itemDescription;

	@Column(name = "Item_Price")
	private Double itemPrice;

	@Column(name = "Item_Brand")
	private String itemBrand;

	@OneToMany(targetEntity = OrderItem.class, mappedBy = "item", cascade = CascadeType.ALL)
	private List<OrderItem> orderItem;

	public Item() {

	}

	public Item(int itemId, String itemName, String itemDescription,
			Double itemPrice) {

		this.itemId = itemId;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.itemPrice = itemPrice;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public Double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public List<OrderItem> getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(List<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}

	public String getItemBrand() {
		return itemBrand;
	}

	public void setItemBrand(String itemBrand) {
		this.itemBrand = itemBrand;
	}

}
