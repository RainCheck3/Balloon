package com.sapient.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.sapient.dao.BalloonDao;
import com.sapient.dao.BalloonDaoImpl;
import com.sapient.model.customer.NewCustomer;
import com.sapient.model.product.Balloon;

/**
 * Servlet implementation class FetchInventoryServlet
 */
public class FetchInventoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Logger log;
    
	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		log = Logger.getLogger(FetchInventoryServlet.class.getName());
		BasicConfigurator.configure();
		
		BalloonDao balloonDao = new BalloonDaoImpl();
		//Balloon balloon = new Balloon(5,"Red", "Square", 20);
		//Balloon balloon = new Balloon(15,"Green", "Heart", 100);
		//balloonDao.addBalloon(balloon);
	
		List<Balloon> inventory;
		//inventory = balloonDao.getInventory();
		//log.info(inventory.size());
		/*
		NewCustomer user = new NewCustomer();
		user.setUsername("Rain");
		user.setPassword("hunter2");
		user.setFirstName("Jiaju");
		user.setLastName("Xu");
		balloonDao.registerUser(user);
		*/
		if(balloonDao.validateLogin("Rain", "hunter2")) {
			log.info("login success");
		}
		else {
			log.info("login failed");
		}
		
		
		//config.getServletContext().setAttribute("inv", inventory);
	}
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchInventoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
