package com.sapient.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sapient.dao.BalloonDaoImpl;
import com.sapient.model.customer.LoginBean;
import com.sapient.model.customer.NewCustomer;
import com.sapient.model.product.Balloon;


@Controller
public class NavigationCtrl {
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homePage(ModelMap model, HttpSession session) {
		BalloonDaoImpl balloonDao = new BalloonDaoImpl();
		List<Balloon> lst = balloonDao.getInventory();
		if (session.getAttribute("username")!=null){
			return "index";
			
		}
		model.addAttribute("command", new LoginBean());
		return "Login";
		
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET )
	public String loginPage(ModelMap model) {
		model.addAttribute("command", new LoginBean());
		return "Login";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signupPage(ModelMap model) {
		model.addAttribute("command", new NewCustomer());
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
