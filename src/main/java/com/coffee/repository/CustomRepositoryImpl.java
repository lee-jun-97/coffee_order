package com.coffee.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coffee.vo.Order;

@Repository
@Transactional
public class CustomRepositoryImpl implements CustomRepository {
	
	@Autowired
	EntityManager entityManager;

	@Override
	public List<Order> findByOrder_Date(String order_date) {
		// TODO Auto-generated method stub
		List<Order> resultList = 
				entityManager.createQuery("SELECT A FROM Order A WHERE A.order_date=:order_date", Order.class)
				.setParameter("order_date", order_date)
				.getResultList();
			return resultList;
	}
	
//	@Override
//	public List<Order> findByOrder_Date(String order_date) {
//		
//		List<Order> resultList = entityManager.createQuery("SELECT A FROM Order A WHERE A.order_date=order_date", Order.class).getResultList();
//		List<Order> resultList = entityManager.createQuery("SELECT A FROM Order A WHERE A.order_date="+order_date, Order.class).getResultList();
//		
//		return resultList;
//	}

}
