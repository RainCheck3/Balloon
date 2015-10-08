package com.sapient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sapient.model.order.Order;

@Controller
@RequestMapping(value = "/spring")
public class CartController {
	
	@RequestMapping(value="/cart")
	public String index(ModelMap model) {
		model.put("cart", new Order());
		return "cart";
	}
}
