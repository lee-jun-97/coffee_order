package com.coffee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.repository.OrderRepository;
import com.coffee.vo.Order;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository ; 
	
	public void historyInsert(Order order) {
		
		System.out.println("#### historyService cost : " + order.getCost());
		System.out.println("#### historyService orderId : " + order.getOrderId());

		orderRepository.save(order);
	}

}
