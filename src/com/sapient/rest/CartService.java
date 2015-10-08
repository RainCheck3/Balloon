package com.sapient.rest;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/cart")
public class CartService {

	@POST
	@Path("/add")
	@Produces(MediaType.TEXT_HTML)
	public String retrieveDate(@FormParam("year") int year,
			@FormParam("month") int month, @FormParam("day") int day) {
		return "<b>" + day + ":" + month + ":" + year + "</b>";
	}
	
	
}
