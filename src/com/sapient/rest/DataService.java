package com.sapient.rest;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.sapient.dao.BalloonDao;
import com.sapient.dao.BalloonDaoImpl;
import com.sapient.model.customer.NewCustomer;

@Path("account/")
public class DataService {
	Logger log;
	@POST
	@Path("upd")
	@Produces(MediaType.TEXT_HTML)
	public String updateAccount(@ FormParam("fName") String fName, @FormParam("lName") String lName, 
			@FormParam("email") String email, @FormParam("street") String street, @FormParam("city") String city, 
			@FormParam("state") String state, @FormParam("zip") String zip, @FormParam("country") String country) {
		BasicConfigurator.configure();
		NewCustomer customer = new NewCustomer();
		customer.setCity(city);
		customer.setCountry(country);
		customer.setEmail(email);
		customer.setFirstName(fName);
		customer.setLastName(lName);
		customer.setState(state);
		customer.setStreet(street);
		customer.setZip(zip);
		BalloonDao updateDB = new BalloonDaoImpl();
		updateDB.updateUser(customer);
//		request.getSession().setAttribute("name", fName);
		return fName + " " + lName;
	}
}
