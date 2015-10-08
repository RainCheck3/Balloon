package com.sapient.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.sapient.dao.BalloonDao;
import com.sapient.dao.BalloonDaoImpl;
import com.sapient.model.customer.NewCustomer;

/**
 * Servlet implementation class UpdateCustomerServlet
 */
public class UpdateCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Logger log;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCustomerServlet() {
        super();
		log = Logger.getLogger(UpdateCustomerServlet.class.getName());
		BasicConfigurator.configure();
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
		NewCustomer customer = new NewCustomer();
		log.info("first name: " + request.getParameter("fName"));
		log.info("last name: " + request.getParameter("lName"));
		String fName = request.getParameter("fName");
		customer.setCity(request.getParameter("city"));
		customer.setCountry(request.getParameter("country"));
		customer.setEmail(request.getParameter("email"));
		customer.setFirstName(request.getParameter("fName"));
		customer.setLastName(request.getParameter("lName"));
		customer.setState(request.getParameter("state"));
		customer.setStreet(request.getParameter("street"));
		customer.setZip(request.getParameter("zip"));
		BalloonDao updateDB = new BalloonDaoImpl();
		updateDB.updateUser(customer,10);
		request.getSession().setAttribute("name", fName);
		request.getRequestDispatcher("MyAccount.jsp").forward(request, response);
	}

}
