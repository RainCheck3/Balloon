package com.sapient.model.customer;

import static com.sapient.util.IsNumber.isNumeric;

import com.sapient.model.order.Order;

/**
 * 
 * @author jxu1 This class represents a customer name, address,
 *         and order, along with getter and setter methods for each
 */
public class NewCustomer {
	private String firstName;
	private String lastName;
	private String address;
	private Order order;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (firstName.length() < 2) {
			throw new IllegalArgumentException(
					"Invalid name entered, length needs to be greater than 1");
		}
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (lastName.length() < 2) {
			throw new IllegalArgumentException(
					"Invalid name entered, length needs to be greater than 1");
		}
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		if (address.length() < 10 || !(isNumeric(address.substring(0, 1)))) {
			throw new IllegalArgumentException(
					"Invalid address, length must be greater than 10 and first character needs to be numeric");
		} else {
			this.address = address;
		}
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		if (order == null) {
			throw new IllegalArgumentException("Null order object");
		} else {
			this.order = order;
		}
	}
}
