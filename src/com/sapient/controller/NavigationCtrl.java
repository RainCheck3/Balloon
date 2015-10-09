package com.sapient.controller;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.hibernate.mapping.List;
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
	public String account(ModelMap model, HttpSession session ) {
		log = Logger.getLogger(NavigationCtrl.class.getName());
		BasicConfigurator.configure();
		BalloonDao dao = new BalloonDaoImpl();
		int customerId = (Integer)dao.getCustomerId("Gunther");
		UpdateCustomer customer = dao.getUser(customerId);
		model.addAttribute("customer", customer);
		return "MyAccount";
	}

	@RequestMapping(value = "/acnt", method = RequestMethod.POST)
	public String updateAccount(@ModelAttribute("customer") @Valid UpdateCustomer customer, BindingResult result) {
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
			updateDB.updateUser(customer,10);
//			request.getSession().setAttribute("name", fName);
			return "MyAccount";
		}
	}

}
