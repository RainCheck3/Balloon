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
		log = Logger.getLogger(FetchInventoryServlet.class.getName());
    	BasicConfigurator.configure();
		
		// Lookup for DataSource
		try {
			ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/balloonDB");

			// Obtain a connection
			con = ds.getConnection();
			log.info("Connection success");

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Balloon> getInventory() {
		List<Balloon> result = new ArrayList<Balloon>();
		
		//Query the database
		//ps = con.prepareStatement("SELECT * FROM PRODUCTS");
		/*
		ps.setString(1, username);
		ps.setString(2, password);
		
		rs =ps.executeQuery();
				
		if (rs.next()) {
			fname = rs.getString(1);
			lname = rs.getString(2);
			return true;
		}
		return false;
		*/
		
		
		return null;
	}

	@Override
	public void addBalloon(Balloon balloon) {
		// TODO Auto-generated method stub

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
