package com.sapient.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sapient.dao.BalloonDaoImpl;
import com.sapient.model.customer.LoginBean;
import com.sapient.model.product.Balloon;


@Controller

public class LoginCtrl {

	@RequestMapping(value= "/log", method = RequestMethod.POST)
		public String customerLogin( LoginBean loginbean, BindingResult result, ModelMap model ,HttpServletRequest request){
			if(result.hasErrors()){
				model.addAttribute("command", new LoginBean());
				return "Login";
			}
			else {
				BalloonDaoImpl newBalloon =  new BalloonDaoImpl();
				
				if (newBalloon.validateLogin( loginbean.getUsername()  , loginbean.getPassword() ) )
						{
					      HttpSession session = request.getSession(true);
					      session.setAttribute("username", loginbean.getUsername());
					      if(session.getAttribute("username")==null){
					  		session.setAttribute("login", "login");
					  		}
					  		else {
					  			session.setAttribute("login", "logout");
					  		}
					      
                          model.addAttribute("name", loginbean.getUsername());
					      model.addAttribute("orderD", new Balloon());
					      BalloonDaoImpl bdi = new BalloonDaoImpl();
						  java.util.List<Balloon> invntryList =  bdi.getInventory();
						  model.addAttribute("items", invntryList);
					      return "index";
						}
				else 
				{   
					model.addAttribute("command", new LoginBean());
					return "Login";
				}
				
				}
			
		}
	
	

}


