package com.sapient.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sapient.model.customer.NewCustomer;


@Controller
@RequestMapping (value="/newcustomer")
public class SignupCtrl {

	@RequestMapping(value= "/signup", method = RequestMethod.GET)
	public String addCustomer(@Valid NewCustomer newcustomer, BindingResult result){
		if(result.hasErrors()){
			return "Signup";
		}
		else 
			return "index";
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String displayCustomerForm(ModelMap model){
		
		model.addAttribute("newcustomer", new NewCustomer());
		return "Signup";
	}
}
