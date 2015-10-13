package com.sapient.controller;

import javax.validation.Valid;

import org.apache.jasper.tagplugins.jstl.core.Redirect;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sapient.dao.BalloonDao;
import com.sapient.dao.BalloonDaoImpl;
import com.sapient.model.customer.NewCustomer;


@Controller
public class SignupCtrl {

	@RequestMapping(value= "/sign", method = RequestMethod.POST)
	public String addCustomer(@Valid NewCustomer customer, BindingResult result,  ModelMap model){
		if(result.hasErrors()){
			model.addAttribute("customer", new NewCustomer());
			return "Signup";
		}
		else {
			BalloonDao newUser =  new BalloonDaoImpl();
		   newUser.registerUser(customer);
			return "index";
	}
		}
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String displayCustomerForm(ModelMap model){
		
		model.addAttribute("customer", new NewCustomer());
		return "Signup";
	}
}
