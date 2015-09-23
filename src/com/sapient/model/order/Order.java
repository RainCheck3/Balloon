package com.sapient.model.order;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.sapient.model.customer.NewCustomer;
import com.sapient.model.payment.Payment;

/**
 * 
 * @author jxu1 Represents an Order made, with regards to a
 *         specific customer, orderDetail, and payment
 */
public class Order {
	private Calendar calendar;
	private Date date;
	private String status;
	private NewCustomer customer;
	private Payment payment;
	private List<OrderDetail> orderDetails;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		if (date == null) {
			throw new IllegalArgumentException();
		} else {
			this.date = date;
		}
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		if (status == null) {
			throw new IllegalArgumentException();

		} else {
			this.status = status;
		}
	}

	public NewCustomer getCustomer() {
		return customer;
	}

	public void setCustomer(NewCustomer customer) {
		if (customer == null) {
			throw new IllegalArgumentException();
		} else {
			this.customer = customer;
		}
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		if (payment == null) {
			throw new IllegalArgumentException();
		} else {
			this.payment = payment;
		}
	}

	public List<OrderDetail> getOrderDetail() {
		return orderDetails;
	}

	public void setOrderDetail(List<OrderDetail> orderDetails) {
		if (orderDetails == null) {
			throw new IllegalArgumentException();
		} else {
			this.orderDetails = orderDetails;
		}
	}

	public double calcTax() {
		double totalTax = 0;

		for (OrderDetail currentOrder : orderDetails) {
			totalTax += (currentOrder.calcSubTotal() * currentOrder
					.getTaxStatus());
		}
		return totalTax;
	}

	public double calcTotal() {
		double totalPrice = 0;

		for (OrderDetail currentOrder : orderDetails) {
			totalPrice += currentOrder.calcSubTotal();
		}
		totalPrice += calcTax();

		return totalPrice;
	}
}
