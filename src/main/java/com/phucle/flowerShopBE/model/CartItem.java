package com.phucle.flowerShopBE.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the cart_items database table.
 * 
 */
@Entity
@Table(name="cart_items")
@NamedQuery(name="CartItem.findAll", query="SELECT c FROM CartItem c")
public class CartItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cart_item_id")
	private int cartItemId;

	private BigDecimal price;

	private int quantity;

	//bi-directional many-to-one association to Cart
	@ManyToOne
	@JoinColumn(name="cart_id")
	private Cart cart;

	//bi-directional many-to-one association to Flower
	@ManyToOne
	@JoinColumn(name="flower_id")
	private Flower flower;

	public CartItem() {
	}

	public int getCartItemId() {
		return this.cartItemId;
	}

	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
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

	public Cart getCart() {
		return this.cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Flower getFlower() {
		return this.flower;
	}

	public void setFlower(Flower flower) {
		this.flower = flower;
	}

}