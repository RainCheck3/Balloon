package com.sapient.model.order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ORDERDETAILS")
public class OrderDetails {


	@Id @GeneratedValue
    @Column(name = "ORDERDETAILID")
	int orderDetailID;
	
	@Column(name = "PRODUCTID")
	String productID;
	
	@Column(name = "PRICE")
	double price;
	

	@Column(name = "QUANTITY")
	int quantity;
	
	@Column(name = "TOTAL")
	double total;
	
	
	public int getOrderDetailID() {
		return orderDetailID;
	}

	public void setOrderDetailID(int orderDetailID) {
		this.orderDetailID = orderDetailID;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}
