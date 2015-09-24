package com.sapient.dao;

import java.util.List;

import com.sapient.model.customer.NewCustomer;
import com.sapient.model.order.Order;
import com.sapient.model.product.Balloon;

public interface BalloonDao {
	public List<Balloon> getInventory();
	public void addBalloon(Balloon balloon);
	public void placeOrder(Order order);
	public boolean validateLogin(String userName, String passWord);
	public String getDescription( String productid);
	public void registerUser(NewCustomer newcustomer);
	public void updateUser(NewCustomer customer);
}
