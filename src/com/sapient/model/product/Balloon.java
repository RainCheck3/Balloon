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
	private String Description;
	private int starRating;
	private String Reviews;
	private String productId;
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

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
	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public int getStarRating() {
		return starRating;
	}

	public void setStarRating(int starReview) {
          this.starRating=starReview;
	}

	public String getReviews() {
		return Reviews;
	}

	public void setReviews(String reviews) {
		Reviews = reviews;
	}
	public String getID() {
		return price + color + shape;
	}
}
