package com.sapient.model.payment;

import com.sapient.model.order.Order;

public class Payment {
	private double amountPaid;
	Order orderObjRef;

	public Order getOrderObjRef() {
		return orderObjRef;
	}

	public void setOrderObjRef(Order orderObjRef) {
		if (orderObjRef != null) {
			this.orderObjRef = orderObjRef;
		} else {
			throw new IllegalArgumentException();
		}
	}

	public double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(double amount) {
		this.amountPaid = amount;

	}

}
