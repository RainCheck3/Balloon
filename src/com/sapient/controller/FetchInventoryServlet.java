package com.sapient.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sapient.dao.BalloonDao;
import com.sapient.dao.BalloonDaoImpl;

/**
 * Servlet implementation class FetchInventoryServlet
 */
public class FetchInventoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       	
	@Override
	public void init(ServletConfig config) throws ServletException {
		BalloonDao balloonDAO = new BalloonDaoImpl();
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
