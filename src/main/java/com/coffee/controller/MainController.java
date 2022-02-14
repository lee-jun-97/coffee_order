package com.coffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.coffee.service.OrderService;
import com.coffee.vo.Order;

@Controller
public class MainController {
	
	private Order order ;
	
	@Autowired
	private OrderService historyService;
//	@RequestMapping("/order")
//	@ResponseBody
//	public String order(@RequestParam String item, @RequestParam int cnt) {
//		
//		return "success";
//	}
	
	@RequestMapping("/success")
	public String success(@RequestParam String paymentKey, @RequestParam String orderId, @RequestParam int amount, Model model) {
		
		order = new Order();
		
		order.setCost(amount);
		order.setOrderId(orderId);
		
		historyService.historyInsert(order);
		
		return "success.html";
	}

}
