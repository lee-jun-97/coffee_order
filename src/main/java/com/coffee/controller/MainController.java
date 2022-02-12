package com.coffee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.coffee.vo.CoffeeVO;

@Controller
public class MainController {
	
	private CoffeeVO coffeeVO ;
	
//	@RequestMapping("/order")
//	@ResponseBody
//	public String order(@RequestParam String item, @RequestParam int cnt) {
//		
//		return "success";
//	}
	
	@RequestMapping("/success")
	public String success(@RequestParam String paymentKey, @RequestParam String orderId, @RequestParam Long amount, Model model) {
		
		coffeeVO = new CoffeeVO();
		
		coffeeVO.setCost(amount);
		coffeeVO.setOrderId(orderId);
		
		System.out.println(coffeeVO.getCost());
		System.out.println(coffeeVO.getOrderId());
		
		model.addAttribute("orderId", orderId);
		model.addAttribute("cost", amount);
		
		System.out.println(model);
		
		
		return "success.html";
	}

}
