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
			con.setAutoCommit(true);
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
				currentBalloon.setProductId(rs.getString(1));
				currentBalloon.setPrice(rs.getDouble(2));
				currentBalloon.setColor(rs.getString(3));
				currentBalloon.setShape(rs.getString(4));
				currentBalloon.setQuantity(rs.getInt(5));
				currentBalloon.setDescription(rs.getString(6));
				currentBalloon.setReviews(rs.getString(7));
				currentBalloon.setStarRating(rs.getInt(8));
				result.add(currentBalloon);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnections();
		}

		return result;
	}

	public String getDescription(String productid)
	{
		String desc="";
		try {
			ps = con.prepareStatement("SELECT Description FROM PRODUCTS WHERE PRODUCTID=?");
			ps.setString(1, productid);
			rs = ps.executeQuery();
			
			while(rs.next()){
				desc = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//Close connections
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
		return desc;
	}
	// Insert into database

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
			ps = con.prepareStatement("SELECT QUANTITY FROM PRODUCTS WHERE PRODUCTID=?");
			ps.setString(1, productID);
			rs = ps.executeQuery();

			if (rs.next()) {
				// Update product count
				int currentQuantity = rs.getInt(1);
				ps = con.prepareStatement("UPDATE PRODUCTS SET QUANTITY=? WHERE PRODUCTID=?");
				ps.setInt(1, currentQuantity + quantity);
				ps.setString(2, productID);
				success = ps.executeUpdate();
				if (success != 0) {
					log.info("Update addition count of product successful");
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
		int orderID = order.hashCode();
		String customerID = order.getCustomer().getUsername();
		int orderDetailID;
		String productID;
		double price;
		int quantity;
		double total;
		boolean inStock = true;
		int success;

		// Iterate through all orderDetails, check if in stock
		for (OrderDetail orderDetail : order.getOrderDetail()) {
			productID = orderDetail.getBalloon().getID();
			quantity = orderDetail.getBalloon().getQuantity();
			// Check if product has enough stock
			try {
				ps = con.prepareStatement("SELECT QUANTITY FROM PRODUCTS WHERE PRODUCTID=?");
				ps.setString(1, productID);
				rs = ps.executeQuery();

				if (rs.next()) {
					if (rs.getInt(1) < quantity) {
						// Not enough in stock
						inStock = false;
						break;
					}
				} else {
					inStock = false;
					break;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		if (inStock) {
			try {
				// Insert into order table
				ps = con.prepareStatement("INSERT INTO ORDERZ VALUES (?, ?)");
				ps.setInt(1, orderID);
				ps.setString(2, customerID);

				success = ps.executeUpdate();

				if (success != 0) {
					log.info("Insert into order successful");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// Iterate through all orderDetails, insert into orderDetails table
			for (OrderDetail orderDetail : order.getOrderDetail()) {
				orderDetailID = orderDetail.hashCode();
				productID = orderDetail.getBalloon().getID();
				price = orderDetail.getBalloon().getPrice();
				quantity = orderDetail.getBalloon().getQuantity();
				total = orderDetail.calcSubTotal();

				try {
					// Insert into orderDetails table
					ps = con.prepareStatement("INSERT INTO ORDERDETAILS VALUES (?, ?, ?, ?, ?, ?)");
					ps.setInt(1, orderDetailID);
					ps.setInt(2, orderID);
					ps.setString(3, productID);
					ps.setDouble(4, price);
					ps.setInt(5, quantity);
					ps.setDouble(6, total);

					success = ps.executeUpdate();

					if (success != 0) {
						log.info("Insert into orderDetail successful");
					}

					// Update product table
					ps = con.prepareStatement("SELECT QUANTITY FROM PRODUCTS WHERE PRODUCTID=?");
					ps.setString(1, productID);
					rs = ps.executeQuery();

					if (rs.next()) {
						// Update product count
						int currentQuantity = rs.getInt(1);
						ps = con.prepareStatement("UPDATE PRODUCTS SET QUANTITY=? WHERE PRODUCTID=?");
						ps.setInt(1, currentQuantity - quantity);
						ps.setString(2, productID);
						success = ps.executeUpdate();
						if (success != 0) {
							log.info("Update removal count of product successful");
						}
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		closeConnections();
	}

	// Insert into Customer Table
	@Override
	public boolean validateLogin(String userName, String passWord) {
	
		try {
			ps = con.prepareStatement("SELECT * FROM USERS WHERE USERID=? AND PASSWD=?");
			ps.setString(1, userName);
			ps.setString(2, passWord);
			rs = ps.executeQuery();
			
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//Close connections
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
		return false;
	}

	public void registerUser(NewCustomer newcustomer) {

		try {
			ps = con.prepareStatement("INSERT INTO CUSTOMER(CUSTOMERID, FIRSTNAME, LASTNAME, PASSWORD) VALUES (?, ?, ?, ?)");
			ps.setString(1, newcustomer.getUsername());
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

	public void updateUser(NewCustomer customer) {

		try {
			ps = con.prepareStatement("UPDATE CUSTOMER SET FIRSTNAME = ?, LASTNAME = ?, STREET = ?, "
					+ "CITY = ?, STATE = ?, COUNTRY = ?, ZIP = ?, EMAIL = ? "
					+ "WHERE CUSTOMERID = ?");
			String id = "lightning";
			ps.setString(1, customer.getFirstName());
			ps.setString(2, customer.getLastName());
			ps.setString(3, customer.getStreet());
			ps.setString(4, customer.getCity());
			ps.setString(5, customer.getState());
			ps.setString(6, customer.getCountry());
			ps.setString(7, customer.getZip());
			ps.setString(8, customer.getEmail());
			ps.setString(9, id);

			log.info(ps);
			int success = ps.executeUpdate();

			if (success != 0) {
				log.info("Update customer successful");
			} else {
				log.info("Update customer failed");
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
