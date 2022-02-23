package com.coffee.repository;

import java.util.List;

import com.coffee.vo.Order;

public interface CustomRepository {
	
	// 주문 일자를 조건으로 하여 DB 조회하도록 만든 method
	List<Order> findByOrder_Date(String order_date);

}
