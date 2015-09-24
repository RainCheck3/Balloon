/**
 * 
 */
package com.sapient.model.product;

import java.io.Serializable;

/**
 * @author jxu1
 *
 */
public class Balloon implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private double price;
	private String color;
	private String shape;
	private int quantity;
	
	//Constructor for testing
	public Balloon(double price, String color, String shape, int quantity) {
		this.price = price;
		this.color = color;
		this.shape = shape;
		this.quantity = quantity;
	}
	
	//Empty constructor
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
}
