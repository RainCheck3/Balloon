package com.sapient.model.order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "CUSTOMER")
public class Orderz {
     
	
	@Id @GeneratedValue
    @Column(name = "NO")
    private int id;
	
    @Column(name = "ORDERID")
	private int orderId;
	
	@Column(name = "CUSTOMERID")
	private String customerId;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	
	
}
