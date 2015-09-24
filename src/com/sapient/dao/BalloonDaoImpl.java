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
import com.sapient.model.order.Order;
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	// Query the database
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

		return result;
	}

	// Insert into database
	@Override
	public void addBalloon(Balloon balloon) {
		double price = balloon.getPrice();
		String color = balloon.getColor();
		String shape = balloon.getShape();
		int quantity = balloon.getQuantity();
		String productID = price + color + shape;

		try {
			ps = con.prepareStatement("INSERT INTO PRODUCTS VALUES (?, ?, ?, ?, ?)");
			ps.setString(1, productID);
			ps.setDouble(2, price);
			ps.setString(3, color);
			ps.setString(4, shape);
			ps.setInt(5, quantity);

			int success = ps.executeUpdate();

			if (success != 0) {
				log.info("Insert successfull");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null && !con.isClosed()) {
					con.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void placeOrder(Order order) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean validateLogin(String userName, String passWord) {
		// TODO Auto-generated method stub
		return false;
	}

}
