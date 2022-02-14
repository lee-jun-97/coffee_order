package com.coffee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee.vo.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
