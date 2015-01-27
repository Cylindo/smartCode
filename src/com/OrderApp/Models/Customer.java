package com.OrderApp.Models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="tblCustomer")
public class Customer implements Serializable{
	@Id
	@GeneratedValue
	@Column(name="Customer_Id")
	private int cust_id;
	@Column(name="Name")
	private String name;
	@Column(name="Surname")
	private String surname;
	@Column(name="Password")
	private String password;
	@Column(name="Gender")
	private String gender;
	@Column(name="Address")
	private String adress;
	@Column(name="Telephone")
	private String telephone;
	
	
	@OneToMany(mappedBy="customers",cascade=CascadeType.ALL)	
	private List<OrderItem> oders;
		
	public Customer() {
		
	}
	
	public Customer(String name, String surname, String password,
			String gender, String adress, String telephone) {
		super();
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.gender = gender;
		this.adress = adress;
		this.telephone = telephone;
	}

	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<OrderItem> getOders() {
		return oders;
	}
	public void setOders(List<OrderItem> oders) {
		this.oders = oders;
	}
	
	
}
