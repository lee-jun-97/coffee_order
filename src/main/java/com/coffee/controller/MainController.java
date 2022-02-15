package com.coffee.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coffee.service.OrderService;
import com.coffee.vo.Order;

@Controller
public class MainController {
	
	private Order order ;
	
	private Logger log = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/success")
	@ResponseBody
	public String success(@RequestParam String paymentKey, @RequestParam String orderId, @RequestParam int amount, Model model) {
		
		order = new Order();
		
		order.setCost(amount);
		order.setOrderid(orderId);
		
		try {
			orderService.historyInsert(order);
		} catch (Exception e) {
			log.warn("### History Insert Fail");
			e.printStackTrace();
		}
		
		return "End";
	}
	
	@RequestMapping("/search")
	@ResponseBody
	public String search() {
		
		try {
			orderService.historySelect();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return "search success";		
	}

}
