package com.sapient.model.product;

import java.io.Serializable;

import javax.persistence.*;

/**
 * @author vinay
 * 
 */
@Entity
@Table(name = "PRODUCTS")
public class Balloon implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "PRICE")
	private double price;
	
	@Column(name = "COLOR")
	private String color;
	
	@Column(name = "SHAPE")
	private String shape;
	
	@Column(name = "QUANTITY")
	private int quantity;
	
	@Column(name = "DESCRIPTION")
	private String Description;
	
	
	@Id 
    @Column(name = "PRODUCTID")
	private String productId;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	// Constructor for testing
	public Balloon(String description,String productId,double price, String color, String shape, int quantity) {
		this.price = price;
		this.color = color;
		this.shape = shape;
		this.quantity = quantity;
		this.Description=description;
		this.productId=productId;
	}

	// Empty constructor
	public Balloon() {
		// TODO Auto-generated constructor stub
	}

	public int getQuantity() {
		return quantity;
	}
	                                                                                                                                                                        

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Price: "+price+" "+"Shape: "+shape;
	}

	
}
