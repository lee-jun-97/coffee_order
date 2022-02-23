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
	// CusmtomRepository 에서 추상화 한 method Override 하여 직접 구현함.
	public List<Order> findByOrder_Date(String order_date) {
		// 주문 일자를 조건으로 하는 Query문 생성
		List<Order> resultList = 
				entityManager.createQuery("SELECT A FROM Order A WHERE A.order_date=:order_date", Order.class)
				// :xx 로 Parameter 명시한 값에 Parameter Setting
				.setParameter("order_date", order_date)
				// Query 결과값 List로 가져옴.
				.getResultList();
			return resultList;
	}

}
