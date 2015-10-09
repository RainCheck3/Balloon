package com.sapient.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sapient.model.order.Order;
import com.sapient.model.order.OrderDetail;
import com.sapient.model.product.Balloon;

@Controller
public class CartController {

	@RequestMapping(value = "/addcart", method = RequestMethod.POST)
	public String addToCart(@ModelAttribute("item") Balloon item,
			HttpSession session) {
		Order order = (Order) session.getAttribute("cart");
		int quantityToAdd = 1;
		OrderDetail itemToAdd = new OrderDetail();
		itemToAdd.setBalloon(item);

		// No cart initialized yet
		if (order == null) {
			order = new Order();
			List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
			itemToAdd.calcSubTotal();
			orderDetails.add(itemToAdd);
			order.setOrderDetail(orderDetails);
		} else {
			// Check for duplicates
			boolean flag = false;
			for (OrderDetail currentItemsInCart : order.getOrderDetail()) {
				// Duplicate found
				if (currentItemsInCart.getBalloon().getProductId() == itemToAdd
						.getBalloon().getProductId()) {
					currentItemsInCart.getBalloon().setQuantity(
							currentItemsInCart.getBalloon().getQuantity()
									+ quantityToAdd);
					flag = true;
					break;
				}
			}
			// Add new item to cart
			if (flag == false) {
				itemToAdd.calcSubTotal();
				order.getOrderDetail().add(itemToAdd);
			}
		}

		session.setAttribute("cart", order);

		return "Checkout";

	}
}
