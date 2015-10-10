package com.sapient.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sapient.dao.BalloonDao;
import com.sapient.dao.BalloonDaoImpl;
import com.sapient.model.product.Balloon;


@Controller
public class ProductController {

	@RequestMapping(value = "/parameter", method = RequestMethod.GET)
	public String product(@RequestParam("pid") String pid,ModelMap model, HttpSession session) {
	
		BalloonDao dao = new BalloonDaoImpl();
	    Balloon balloon=dao.getProduct(pid);
	    
	    model.addAttribute("product",balloon);
	
	    return "Product";
	}
}
