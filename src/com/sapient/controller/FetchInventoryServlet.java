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

import com.sapient.model.product.Balloon;

/**
 * Servlet implementation class FetchInventoryServlet
 */
public class FetchInventoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger log;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		log = Logger.getLogger(FetchInventoryServlet.class.getName());
		BasicConfigurator.configure();

		BalloonDao balloonDao = new BalloonDaoImpl();

		List<Balloon> inventory;
		inventory = balloonDao.getInventory();
		config.getServletContext().setAttribute("inv", inventory);
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FetchInventoryServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
