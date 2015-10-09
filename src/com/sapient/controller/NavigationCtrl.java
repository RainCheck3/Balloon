package com.sapient.controller;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sapient.model.product.Balloon;

import com.sapient.model.customer.LoginBean;
import com.sapient.model.customer.NewCustomer;

@Controller
public class NavigationCtrl {

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView homePage() {
		// return "index";
		return new ModelAndView("index", "orderD", new Balloon());
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(ModelMap model) {
		model.addAttribute("command", new LoginBean());
		return "Login";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signupPage(ModelMap model) {
		model.addAttribute("command", new NewCustomer());
		return "Signup";
	}

	@RequestMapping(value = "/acnt", method = RequestMethod.GET)
	public String account() {
		return "MyAccount";
	}
	
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String checkout() {
		return "Checkout";
	}

}
