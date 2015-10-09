package com.sapient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sapient.model.order.OrderDetail;
import com.sapient.model.product.Balloon;


@Controller
public class NavigationCtrl {
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView homePage() {
		//return "index";
		
		return new ModelAndView("index", "orderD", new Balloon());
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "Login";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup() {
		return "Signup";
	}
	
	@RequestMapping(value = "/acnt", method = RequestMethod.GET)
	public String account() {
		return "MyAccount";
	}
	
	
	
}
