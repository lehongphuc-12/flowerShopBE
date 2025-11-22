package com.phucle.flowerShopBE.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the Categories database table.
 * 
 */
@Entity
@Table(name="Categories")
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CategoryId")
	private int categoryId;

	@Column(name="CategoryName")
	private String categoryName;

	//bi-directional many-to-one association to Flower
	@OneToMany(mappedBy="category")
	private List<Flower> flowers;

	public Category() {
	}

	public int getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Flower> getFlowers() {
		return this.flowers;
	}

	public void setFlowers(List<Flower> flowers) {
		this.flowers = flowers;
	}

	public Flower addFlower(Flower flower) {
		getFlowers().add(flower);
		flower.setCategory(this);

		return flower;
	}

	public Flower removeFlower(Flower flower) {
		getFlowers().remove(flower);
		flower.setCategory(null);

		return flower;
	}

}