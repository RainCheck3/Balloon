package com.sapient.model.order;

import java.io.Serializable;

import com.sapient.model.product.Balloon;

/**
 * 
 * @author jxu1 Information about a particular order, including
 *         quantity, taxStatus, and item
 * 
 */

public class OrderDetail implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private double taxStatus;
	private Order order;
	private Balloon balloon;
	private double subTotal;

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
		this.subTotal = balloon.getQuantity() * balloon.getPrice();
		return subTotal;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	
}
