package com.sapient.model.customer;

import com.sapient.model.order.Order;

/**
 * 
 * @author jxu1 This class represents a customer name, address, and order, along
 *         with getter and setter methods for each
 */
public class NewCustomer {
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String street;
	private String city;
	private String state;
	private String Country;
	private String Email;
	private String zip;
	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username.toLowerCase();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
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
