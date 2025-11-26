package com.phucle.flowerShopBE.model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the Flower_Discount database table.
 * 
 */
@Entity
@NamedQuery(name="Flower_Discount.findAll", query="SELECT f FROM Flower_Discount f")
public class Flower_Discount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Id")
	private int id;

	//bi-directional many-to-one association to Discount
	@ManyToOne
	@JoinColumn(name="DiscountId")
	private Discount discount;

	//bi-directional many-to-one association to Flower
	@ManyToOne
	@JoinColumn(name="FlowerId")
	private Flower flower;

	public Flower_Discount() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Discount getDiscount() {
		return this.discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	public Flower getFlower() {
		return this.flower;
	}

	public void setFlower(Flower flower) {
		this.flower = flower;
	}

}