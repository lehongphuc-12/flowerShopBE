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

	//bi-directional many-to-one association to Flower_Category
	@OneToMany(mappedBy="category")
	private List<Flower_Category> flowerCategories;

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

	public List<Flower_Category> getFlowerCategories() {
		return this.flowerCategories;
	}

	public void setFlowerCategories(List<Flower_Category> flowerCategories) {
		this.flowerCategories = flowerCategories;
	}

	public Flower_Category addFlowerCategory(Flower_Category flowerCategory) {
		getFlowerCategories().add(flowerCategory);
		flowerCategory.setCategory(this);

		return flowerCategory;
	}

	public Flower_Category removeFlowerCategory(Flower_Category flowerCategory) {
		getFlowerCategories().remove(flowerCategory);
		flowerCategory.setCategory(null);

		return flowerCategory;
	}

}