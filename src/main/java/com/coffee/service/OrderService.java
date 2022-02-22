package com.coffee.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.repository.OrderRepository;
import com.coffee.vo.Order;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	private static final Logger log = LoggerFactory.getLogger(OrderService.class);
	
	public void historyInsert(Order order) {
		
		log.info("### history Insert Start");
		
		log.info("### historyService cost : " + order.getCost());
		log.info("### historyService orderId : " + order.getOrderid());

		// JPA Repository 사용하여 DB에 Insert
		// @Id로 Primary Key 지정한 orderid가 중복되는 값이 있으면 Update 됨.
		orderRepository.save(order);
		
		log.info("### history Insert End");
		
	}
	
	public List<Order> historySelectAll() {
		
		log.info("### history Select Start");
		
		// 결제 내역 모두 Select 함.
		List<Order> history = orderRepository.findAll();
		
		log.info("### Select Count : " + history.size());
		
		for(Order i : history) {
			log.info("### Cost : " + i.getCost());
			log.info("### OrderId : " + i.getOrderid());
		}
		
		log.info("### history Select End");
		
		return history;		
	}
	
	public List<Order> historySelectDate(String order_date) {
		
		log.info("### history select By Date Start");
		
		List<Order> historyDate = orderRepository.findByOrder_Date(order_date);
		
		for(Order i : historyDate) {
			log.info("### Cost : " + i.getCost());
			log.info("### OrderId : " + i.getOrderid());
			log.info("### Order_Date : " + i.getOrder_date());
		}
		
		return historyDate;
	}

}
