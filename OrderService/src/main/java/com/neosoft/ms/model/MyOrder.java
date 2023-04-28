package com.neosoft.ms.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MyOrder")
public class MyOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "orderId")
	private int id;
//	private int customerId;
	private String item;
//	private LocalDateTime createdAt;
	private int quantity;
	private int price;
	private int totalCost;

	public MyOrder(String item, int quantity, int price, int totalCost) {
		super();
//		this.id = orderId;
//		this.customerId = customerId;
		this.item = item;
		this.quantity = quantity;
		this.price = price;
		this.totalCost = totalCost;
	}

	public MyOrder() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

}
