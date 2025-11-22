package com.phucle.flowerShopBE.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the Flowers database table.
 * 
 */
@Entity
@Table(name="Flowers")
@NamedQuery(name="Flower.findAll", query="SELECT f FROM Flower f")
public class Flower implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="FlowerId")
	private int flowerId;

	@Column(name="CreatedAt")
	private Timestamp createdAt;

	@Column(name="Description")
	private String description;

	@Column(name="Design")
	private String design;

	@Column(name="FlowerName")
	private String flowerName;

	@Column(name="ImageUrl")
	private String imageUrl;

	@Column(name="Price")
	private BigDecimal price;

	@Column(name="Stock")
	private int stock;

	//bi-directional many-to-one association to CartItem
	@OneToMany(mappedBy="flower")
	private List<CartItem> cartItems;

	//bi-directional many-to-one association to Flower_FlowerType
	@OneToMany(mappedBy="flower")
	private List<Flower_FlowerType> flowerFlowerTypes;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="CategoryId")
	private Category category;

	//bi-directional many-to-one association to OrderItem
	@OneToMany(mappedBy="flower")
	private List<OrderItem> orderItems;

	public Flower() {
	}

	public int getFlowerId() {
		return this.flowerId;
	}

	public void setFlowerId(int flowerId) {
		this.flowerId = flowerId;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDesign() {
		return this.design;
	}

	public void setDesign(String design) {
		this.design = design;
	}

	public String getFlowerName() {
		return this.flowerName;
	}

	public void setFlowerName(String flowerName) {
		this.flowerName = flowerName;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getStock() {
		return this.stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public List<CartItem> getCartItems() {
		return this.cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public CartItem addCartItem(CartItem cartItem) {
		getCartItems().add(cartItem);
		cartItem.setFlower(this);

		return cartItem;
	}

	public CartItem removeCartItem(CartItem cartItem) {
		getCartItems().remove(cartItem);
		cartItem.setFlower(null);

		return cartItem;
	}

	public List<Flower_FlowerType> getFlowerFlowerTypes() {
		return this.flowerFlowerTypes;
	}

	public void setFlowerFlowerTypes(List<Flower_FlowerType> flowerFlowerTypes) {
		this.flowerFlowerTypes = flowerFlowerTypes;
	}

	public Flower_FlowerType addFlowerFlowerType(Flower_FlowerType flowerFlowerType) {
		getFlowerFlowerTypes().add(flowerFlowerType);
		flowerFlowerType.setFlower(this);

		return flowerFlowerType;
	}

	public Flower_FlowerType removeFlowerFlowerType(Flower_FlowerType flowerFlowerType) {
		getFlowerFlowerTypes().remove(flowerFlowerType);
		flowerFlowerType.setFlower(null);

		return flowerFlowerType;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<OrderItem> getOrderItems() {
		return this.orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public OrderItem addOrderItem(OrderItem orderItem) {
		getOrderItems().add(orderItem);
		orderItem.setFlower(this);

		return orderItem;
	}

	public OrderItem removeOrderItem(OrderItem orderItem) {
		getOrderItems().remove(orderItem);
		orderItem.setFlower(null);

		return orderItem;
	}

}