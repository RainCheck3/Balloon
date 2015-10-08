/**
 * 
 */
package com.sapient.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.sapient.model.customer.NewCustomer;
import com.sapient.model.order.Order;
import com.sapient.model.order.OrderDetail;
import com.sapient.model.product.Balloon;

public class BalloonDaoImpl implements BalloonDao {
	Logger log;
	

	// Construct DAO, establish database connection
	public BalloonDaoImpl() {
	}


	// Query the Products Table
	@Override
	public List<Balloon> getInventory() {
		SessionFactory sessionfactory = HibernateUtil.getSessionFactory();
		Session session = sessionfactory.openSession();
		Transaction tx = null;
		// try{
		String hql = "from Balloon";
		Query qry = session.createQuery(hql);
		List<Balloon> lst = qry.list();
		session.close();
		System.out.println(lst);
		return lst;
	}

	public String getDescription(String productid) {
		SessionFactory sessionfactory = HibernateUtil.getSessionFactory();
		Session session = sessionfactory.openSession();
		Transaction tx = null;
		Balloon balloon=new Balloon();
		// try{
		String hql = "SELECT DESCRIPTION from Balloon B WHERE B.PRODUCTID= productid";
		Query qry = session.createQuery(hql);
	    List lst = qry.list();
		session.close();
		String desc="";
		for(Iterator it=lst.iterator();it.hasNext();){
			
		    balloon = (Balloon)it.next();
			desc=balloon.getDescription();
				
			}
		return desc;
	}

	// Insert into database

	@Override
	public void addBalloon(Balloon balloon) {
		SessionFactory sessionfactory = HibernateUtil.getSessionFactory();
		Session session = sessionfactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
		String id=(String) session.save(balloon);

			tx.commit();

		} catch (HibernateException ex) {
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

//	// Insert into Order, OrderDetails Table, update products
//	@Override
//	public void placeOrder(Order order) {
//		int orderID = order.hashCode();
//		String customerID = order.getCustomer().getUsername();
//		int orderDetailID;
//		String productID;
//		double price;
//		int quantity;
//		double total;
//		boolean inStock = true;
//		int success;
//
//		// Iterate through all orderDetails, check if in stock
//		for (OrderDetail orderDetail : order.getOrderDetail()) {
//			productID = orderDetail.getBalloon().getID();
//			quantity = orderDetail.getBalloon().getQuantity();
//			// Check if product has enough stock
//			try {
//				ps = con.prepareStatement("SELECT QUANTITY FROM PRODUCTS WHERE PRODUCTID=?");
//				ps.setString(1, productID);
//				rs = ps.executeQuery();
//
//				if (rs.next()) {
//					if (rs.getInt(1) < quantity) {
//						// Not enough in stock
//						inStock = false;
//						break;
//					}
//				} else {
//					inStock = false;
//					break;
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		}
//
//		if (inStock) {
//			try {
//				// Insert into order table
//				ps = con.prepareStatement("INSERT INTO ORDERZ VALUES (?, ?)");
//				ps.setInt(1, orderID);
//				ps.setString(2, customerID);
//
//				success = ps.executeUpdate();
//
//				if (success != 0) {
//					log.info("Insert into order successful");
//				}
//
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//			// Iterate through all orderDetails, insert into orderDetails table
//			for (OrderDetail orderDetail : order.getOrderDetail()) {
//				orderDetailID = orderDetail.hashCode();
//				productID = orderDetail.getBalloon().getID();
//				price = orderDetail.getBalloon().getPrice();
//				quantity = orderDetail.getBalloon().getQuantity();
//				total = orderDetail.calcSubTotal();
//
//				try {
//					// Insert into orderDetails table
//					ps = con.prepareStatement("INSERT INTO ORDERDETAILS VALUES (?, ?, ?, ?, ?, ?)");
//					ps.setInt(1, orderDetailID);
//					ps.setInt(2, orderID);
//					ps.setString(3, productID);
//					ps.setDouble(4, price);
//					ps.setInt(5, quantity);
//					ps.setDouble(6, total);
//
//					success = ps.executeUpdate();
//
//					if (success != 0) {
//						log.info("Insert into orderDetail successful");
//					}
//
//					// Update product table
//					ps = con.prepareStatement("SELECT QUANTITY FROM PRODUCTS WHERE PRODUCTID=?");
//					ps.setString(1, productID);
//					rs = ps.executeQuery();
//
//					if (rs.next()) {
//						// Update product count
//						int currentQuantity = rs.getInt(1);
//						ps = con.prepareStatement("UPDATE PRODUCTS SET QUANTITY=? WHERE PRODUCTID=?");
//						ps.setInt(1, currentQuantity - quantity);
//						ps.setString(2, productID);
//						success = ps.executeUpdate();
//						if (success != 0) {
//							log.info("Update removal count of product successful");
//						}
//					}
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
//		closeConnections();
//	}

	// Insert into Customer Table
	@Override
	public boolean validateLogin(String userName, String passWord) {

		SessionFactory sessionfactory = HibernateUtil.getSessionFactory();
		Session session = sessionfactory.openSession();
		Transaction tx = null;

		boolean userStatus = false;

		String SQL_QUERY = " from NewCustomer as user where user.username=? and user.password=?";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter(0, userName);
		query.setParameter(1, passWord);
		List list = query.list();
		
		
		if((list!=null)&&(list.size()>0)){
			userStatus = true;
			}

		session.close();
		return userStatus;
	}

	public void registerUser(NewCustomer newcustomer) {

		SessionFactory sessionfactory = HibernateUtil.getSessionFactory();
		Session session = sessionfactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
		   Integer id=(Integer)session.save(newcustomer);
		    tx.commit();

		} catch (HibernateException ex) {
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateUser(NewCustomer customer,Integer customerId) {

		SessionFactory sessionfactory = HibernateUtil.getSessionFactory();
		Session session = sessionfactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
		    NewCustomer newcustomer=(NewCustomer) session.get(NewCustomer.class,customerId);
		    newcustomer.setCity(customer.getCity());
		    newcustomer.setCountry(customer.getCountry());
		    newcustomer.setEmail(customer.getEmail());
		    newcustomer.setFirstName(customer.getFirstName());
		    newcustomer.setLastName(customer.getLastName());
		    newcustomer.setPassword(customer.getPassword());
		    newcustomer.setState(customer.getState());
		    newcustomer.setStreet(customer.getStreet());
		    newcustomer.setZip(customer.getZip());
		    newcustomer.setUsername(customer.getUsername());
		    
		    tx.commit();

		} catch (HibernateException ex) {
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}


	@Override
	public boolean placeOrder(Order order) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
