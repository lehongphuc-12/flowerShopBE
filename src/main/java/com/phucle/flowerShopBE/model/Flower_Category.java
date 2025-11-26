package com.phucle.flowerShopBE.model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the Flower_Category database table.
 * 
 */
@Entity
@NamedQuery(name="Flower_Category.findAll", query="SELECT f FROM Flower_Category f")
public class Flower_Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Id")
	private int id;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="CategoryId")
	private Category category;

	//bi-directional many-to-one association to Flower
	@ManyToOne
	@JoinColumn(name="FlowerId")
	private Flower flower;

	public Flower_Category() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Flower getFlower() {
		return this.flower;
	}

	public void setFlower(Flower flower) {
		this.flower = flower;
	}

}