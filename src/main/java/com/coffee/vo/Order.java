package com.coffee.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name="payment_history")
public class Order {
	
	@Column(name="cost")
	public int cost;
	@Column(name="orderid")@Id
	public String orderid;

}
