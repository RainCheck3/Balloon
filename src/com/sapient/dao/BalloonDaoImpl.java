/**
 * 
 */
package com.sapient.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.sapient.controller.FetchInventoryServlet;
import com.sapient.model.customer.NewCustomer;
import com.sapient.model.order.Order;
import com.sapient.model.order.OrderDetail;
import com.sapient.model.product.Balloon;

/**
 * @author jxu1
 *
 */
public class BalloonDaoImpl implements BalloonDao {
	Logger log;

	private Context ctx = null;
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	// Construct DAO, establish database connection
	public BalloonDaoImpl() {
		log = Logger.getLogger(BalloonDaoImpl.class.getName());
		BasicConfigurator.configure();

		// Lookup for DataSource
		try {
			ctx = new InitialContext();
			DataSource ds = (DataSource) ctx
					.lookup("java:comp/env/jdbc/balloonDB");

			// Obtain a connection
			con = ds.getConnection();
			log.info("DBConnection success");

		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Query the Products Table
	@Override
	public List<Balloon> getInventory() {
		List<Balloon> result = new ArrayList<Balloon>();

		try {
			ps = con.prepareStatement("SELECT * FROM PRODUCTS");
			rs = ps.executeQuery();

			while (rs.next()) {
				Balloon currentBalloon = new Balloon();
				currentBalloon.setPrice(rs.getDouble(2));
				currentBalloon.setColor(rs.getString(3));
				currentBalloon.setShape(rs.getString(4));
				currentBalloon.setQuantity(rs.getInt(5));
				result.add(currentBalloon);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnections();
		}

		return result;
	}

	// Insert into Products Table
	@Override
	public void addBalloon(Balloon balloon) {
		double price = balloon.getPrice();
		String color = balloon.getColor();
		String shape = balloon.getShape();
		int quantity = balloon.getQuantity();
		String productID = price + color + shape;
		int success = 0;

		try {
			// Check if product already exists
			ps = con.prepareStatement("SELECT ? FROM PRODUCTS WHERE PRODUCTID=?");
			ps.setInt(1, quantity);
			ps.setString(2, productID);
			rs = ps.executeQuery();

			if (rs.next()) {
				// Update product count
				int currentQuantity = rs.getInt(1);
				ps = con.prepareStatement("UPDATE PRODUCTS SET QUANTITY=? WHERE PRODUCTID=?");
				ps.setInt(1, currentQuantity + quantity);
				ps.setString(2, productID);
				success = ps.executeUpdate();
				if (success != 0) {
					log.info("Update count of product successful");
				}
			} else {
				// Insert new entry
				ps = con.prepareStatement("INSERT INTO PRODUCTS(PRODUCTID, PRICE, COLOR, SHAPE, QUANTITY) VALUES (?, ?, ?, ?, ?)");
				ps.setString(1, productID);
				ps.setDouble(2, price);
				ps.setString(3, color);
				ps.setString(4, shape);
				ps.setInt(5, quantity);

				success = ps.executeUpdate();

				if (success != 0) {
					log.info("Insert into products successful");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnections();
		}
	}

	// Insert into Order, OrderDetails Table, update products
	@Override
	public void placeOrder(Order order) {

	}

	// Query Customer Table
	@Override
	public boolean validateLogin(String username, String password) {
		String validPassword;

		try {
			ps = con.prepareStatement("SELECT PASSWORD FROM CUSTOMER WHERE CUSTOMERID=?");
			ps.setString(1, username.toLowerCase());
			rs = ps.executeQuery();

			if (rs.next()) {
				validPassword = rs.getString(1);
				if (password.equals(validPassword)) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnections();
		}
		return false;
	}

	// Insert into Customer Table
	@Override
	public void registerUser(NewCustomer newcustomer) {

		try {
			ps = con.prepareStatement("INSERT INTO CUSTOMER(CUSTOMERID, FIRSTNAME, LASTNAME, PASSWORD) VALUES (?, ?, ?, ?)");
			ps.setString(1, newcustomer.getUsername().toLowerCase());
			ps.setString(2, newcustomer.getFirstName());
			ps.setString(3, newcustomer.getLastName());
			ps.setString(4, newcustomer.getPassword());

			int success = ps.executeUpdate();

			if (success != 0) {
				log.info("Insert into customer successful");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnections();
		}
	}

	private void closeConnections() {
		try {
			if (con != null && !con.isClosed()) {
				con.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
