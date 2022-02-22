package com.coffee.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coffee.service.OrderService;
import com.coffee.vo.Order;

@Controller
public class MainController {
	
	private Order order ;
	
	private static final Logger log = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/")
	public String home() {
		return "index.html";
	}
	
	@RequestMapping("/order")
	public String order() {
		return "order.html";
	}
	
	@RequestMapping("/success")
	@ResponseBody
	public String success(@RequestParam String paymentKey, @RequestParam String orderId, @RequestParam int amount) {
		
		order = new Order();
		
		Date order_date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		order.setCost(amount);
		order.setOrderid(orderId);
		order.setOrder_date(df.format(order_date));
		
		try {
			orderService.historyInsert(order);
		} catch (Exception e) {
			log.warn("### History Insert Fail");
			e.printStackTrace();
		}
		
		return "End";
	}
	
	@RequestMapping("/search")
	public String search() {
		
		return "search.html";		
	}
	
	@RequestMapping("/searchhistory")
	@ResponseBody
	public String searchHistory(@RequestParam(defaultValue = "null") String order_date) {
		
		System.out.println(order_date);
		
		if(order_date.equals("null")) {
			List<Order> historyList = orderService.historySelectAll();
			return historyList.toString();
		} else {
			List<Order> historyList = orderService.historySelectDate(order_date);
			return historyList.toString();
		}
	}

}
