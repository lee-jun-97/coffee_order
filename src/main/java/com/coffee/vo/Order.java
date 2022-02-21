package com.coffee.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name="payment_history")
public class Order {
	
	public int cost;
	@Id
	public String orderid;
	public String order_date;

}
