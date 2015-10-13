package com.sapient.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.hibernate.mapping.List;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sapient.dao.BalloonDao;
import com.sapient.dao.BalloonDaoImpl;
import com.sapient.model.customer.NewCustomer;
import com.sapient.model.customer.UpdateCustomer;
import com.sapient.model.product.Balloon;
import com.sapient.model.customer.LoginBean;

@Controller
public class NavigationCtrl {
	Logger log;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView homePage(Balloon ballon, ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		if(session.getAttribute("username")==null){
		session.setAttribute("login", "login");
		}
		else {
			session.setAttribute("login", "logout");
		}
	     BalloonDaoImpl bdi = new BalloonDaoImpl();
	     java.util.List<Balloon> invntryList =  bdi.getInventory();
	     model.addAttribute("items", invntryList);
		return new ModelAndView("index", "orderD", new Balloon());
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(ModelMap model) {
		model.addAttribute("command", new LoginBean());
		return "Login";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logOut(ModelMap model,HttpSession session) {
		session.invalidate();
		model.addAttribute("command", new LoginBean());
		return "Login";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signupPage(ModelMap model) {
		model.addAttribute("customer", new NewCustomer());
		return "Signup";
	}

	@RequestMapping(value = "/acnt", method = RequestMethod.GET)
	public String account(ModelMap model, HttpSession session ) {
		if(session.getAttribute("username")==null){
			model.addAttribute("customer", new NewCustomer());
			return "Signup";
		}
		
	else
		{log = Logger.getLogger(NavigationCtrl.class.getName());
		BasicConfigurator.configure();
		BalloonDao dao = new BalloonDaoImpl();
		log.info(session.getAttribute("username"));
		String uname = (String) session.getAttribute("username");
		String customerId = dao.getCustomerId(uname);
		session.setAttribute("customerId", customerId);
		UpdateCustomer customer = dao.getUser(customerId);
		model.addAttribute("customer", customer);
		return "MyAccount"; }
	}
	
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String checkout() {
		return "Checkout";
	}

	@RequestMapping(value = "/acnt", method = RequestMethod.POST)
	public String updateAccount(@ModelAttribute("customer") @Valid UpdateCustomer customer, BindingResult result, HttpSession session) {
//		log.info("first name: " + request.getParameter("fName"));
//		log.info("last name: " + request.getParameter("lName"));
		log = Logger.getLogger(NavigationCtrl.class.getName());
		BasicConfigurator.configure();
		log.info("made it to post func");
		if(result.hasErrors())
		{
			log.info(result.getAllErrors());
			return "MyAccount";
		}
		else
		{
			log.info("no errors");
			BalloonDao updateDB = new BalloonDaoImpl();
			updateDB.updateUser(customer, (Integer)session.getAttribute("customerId"));
//			request.getSession().setAttribute("name", fName);
			return "MyAccount";
		}
	}

}
