package com.sapient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class NavigationCtrl {
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homePage() {
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "Login";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup() {
		return "Signup";
	}
	
	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public String checkout() {
		return "Checkout";
	}
	
	@RequestMapping(value = "/acnt", method = RequestMethod.GET)
	public String account() {
		return "MyAccount";
	}
	
	
	
}
