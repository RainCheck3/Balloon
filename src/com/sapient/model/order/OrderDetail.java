package com.sapient.model.order;

import com.sapient.model.product.Balloon;

/**
 * 
 * @author jxu1 Information about a particular order, including
 *         quantity, taxStatus, and item
 * 
 */

public class OrderDetail {
	private int quantity;
	private double taxStatus;
	private Order order;
	private Balloon balloon;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTaxStatus() {
		return taxStatus;
	}

	public void setTaxStatus(double taxStatus) {
		this.taxStatus = taxStatus;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Balloon getBalloon() {
		return balloon;
	}

	public void setBalloon(Balloon balloon) {
		this.balloon = balloon;
	}

	public double calcSubTotal() {
		return quantity * balloon.getPrice();
	}
}
