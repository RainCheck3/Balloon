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
import com.sapient.model.customer.UpdateCustomer;
import com.sapient.model.order.Order;
import com.sapient.model.order.OrderDetail;
import com.sapient.model.order.OrderDetails;
import com.sapient.model.order.Orderz;
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
		return lst;

	}

	public Balloon getProduct(String productid) {
		SessionFactory sessionfactory = HibernateUtil.getSessionFactory();
		Session session = sessionfactory.openSession();
		Transaction tx = null;
		Balloon balloon= null;
		try {
			tx = session.beginTransaction();
			balloon = (Balloon) session.get(Balloon.class,productid);
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
		return balloon;
	}

	// Insert into database

	@Override
	public void addBalloon(Balloon balloon) {
		SessionFactory sessionfactory = HibernateUtil.getSessionFactory();
		Session session = sessionfactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String id = (String) session.save(balloon);

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

	// // Insert into Order, OrderDetails Table, update products
	// @Override
	public boolean placeOrder(Order order) {


		SessionFactory sessionfactory = HibernateUtil.getSessionFactory();
		Session session = sessionfactory.openSession();
		Transaction tx = null;

		int orderID = order.hashCode();
		String customerID = order.getCustomer().getUsername();
		int orderDetailID;
		String productID;
		double price;
		int quantity;
		double total;
		boolean inStock = true;
		int success;
		Integer Quantity = null;

		// Iterate through all orderDetails, check if in stock
		for (OrderDetail orderDetail : order.getOrderDetails()) {
			productID = orderDetail.getBalloon().getID();
			quantity = orderDetail.getBalloon().getQuantity();
			tx = session.beginTransaction();
			String HQL_QUERY = "select product.QUANTITY from PRODUCTS as product where product.PRODUCTID=?";
			Query query = session.createQuery(HQL_QUERY);
			query.setParameter(0, productID);
			Quantity = (Integer) query.uniqueResult();

			if (Quantity < quantity) {
				// Not enough in stock
				inStock = false;
				break;

			} else {
				inStock = false;
				break;
			}

		}

		if (inStock) {

			Orderz orders = new Orderz();
			orders.setCustomerId(customerID);
			orders.setOrderId(orderID);
			try {
				// Insert into order table
				Integer id = (Integer) session.save(orders);
				tx.commit();

				if (id != 0) {
					log.info("Insert into order successful");
				}

			} catch (HibernateException ex) {
				if (tx != null) {
					tx.rollback();
				}

				// Iterate through all orderDetails, insert into orderDetails
				// table
				for (OrderDetail orderDetail : order.getOrderDetails()) {

					// orderDetailID = orderDetail.hashCode();
					productID = orderDetail.getBalloon().getID();
					price = orderDetail.getBalloon().getPrice();
					quantity = orderDetail.getBalloon().getQuantity();
					total = orderDetail.calcSubTotal();

					OrderDetails orderdetails = new OrderDetails();
					orderdetails.setPrice(price);
					orderdetails.setProductID(productID);
					orderdetails.setQuantity(quantity);
					orderdetails.setTotal(total);

					try {
						// Insert into orderDetails table
						Integer id = (Integer) session.save(orderdetails);
						tx.commit();

						if (id != 0) {
							log.info("Insert into orderDetail successful");
						}

						// Update product table

						Balloon balloon = (Balloon) session.get(Balloon.class,
								productID);
						balloon.setQuantity((quantity - Quantity));
						tx.commit();
					} catch (HibernateException e) {
						if (tx != null) {
							tx.rollback();
						}
						e.printStackTrace();
					} finally {
						if (session != null) {
							session.close();
						}
					}
				}

			}
		}
		return true;
	}

	
	
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

		if ((list != null) && (list.size() > 0)) {
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
			Integer id = (Integer) session.save(newcustomer);
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

	public void updateUser(UpdateCustomer customer, int customerId) {
		SessionFactory sessionfactory = HibernateUtil.getSessionFactory();
		Session session = sessionfactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			UpdateCustomer updateCustomer = (UpdateCustomer) session.get(
					UpdateCustomer.class, customerId);
			updateCustomer.setCity(customer.getCity());
			updateCustomer.setCountry(customer.getCountry());
			updateCustomer.setEmail(customer.getEmail());
			updateCustomer.setFirstName(customer.getFirstName());
			updateCustomer.setLastName(customer.getLastName());
			updateCustomer.setState(customer.getState());
			updateCustomer.setStreet(customer.getStreet());
			updateCustomer.setZip(customer.getZip());

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

	public UpdateCustomer getUser(int customerId) {
		SessionFactory sessionfactory = HibernateUtil.getSessionFactory();
		Session session = sessionfactory.openSession();
		Transaction tx = null;
		UpdateCustomer updateCustomer = null;
		try {
			tx = session.beginTransaction();
			updateCustomer = (UpdateCustomer) session.get(UpdateCustomer.class,
					customerId);
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
		return updateCustomer;
	}

	public int getCustomerId(String un) {
		SessionFactory sessionfactory = HibernateUtil.getSessionFactory();
		Session session = sessionfactory.openSession();
		String HQL_QUERY = "select user.customerId from NewCustomer as user where user.username=?";
		Query query = session.createQuery(HQL_QUERY);
		query.setParameter(0, un);
		return (Integer) query.uniqueResult();
	}

}
