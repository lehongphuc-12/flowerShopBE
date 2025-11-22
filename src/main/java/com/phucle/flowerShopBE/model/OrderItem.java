package com.phucle.flowerShopBE.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the order_items database table.
 * 
 */
@Entity
@Table(name="order_items")
@NamedQuery(name="OrderItem.findAll", query="SELECT o FROM OrderItem o")
public class OrderItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="order_item_id")
	private int orderItemId;

	private BigDecimal price;

	private int quantity;

	//bi-directional many-to-one association to Flower
	@ManyToOne
	@JoinColumn(name="flower_id")
	private Flower flower;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="order_id")
	private Order order;

	public OrderItem() {
	}

	public int getOrderItemId() {
		return this.orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Flower getFlower() {
		return this.flower;
	}

	public void setFlower(Flower flower) {
		this.flower = flower;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}