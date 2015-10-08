package com.sapient.controller;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/login")
public class Loginservice {

	@POST
	@Path("/add")
	@Produces(MediaType.TEXT_HTML)
	public String getData(@FormParam("Username") int username,
			@FormParam("Password") int password) {

		return "Date :" + day + ":" + month + ":" + year;
	}

}
