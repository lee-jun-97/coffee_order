package com.coffee.repository;

import java.util.List;

import com.coffee.vo.Order;

public interface CustomRepository {
	
	List<Order> findByOrder_Date(String order_date);

}
