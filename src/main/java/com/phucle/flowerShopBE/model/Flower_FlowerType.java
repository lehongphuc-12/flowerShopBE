package com.phucle.flowerShopBE.model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the Flower_FlowerType database table.
 * 
 */
@Entity
@NamedQuery(name="Flower_FlowerType.findAll", query="SELECT f FROM Flower_FlowerType f")
public class Flower_FlowerType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Id")
	private int id;

	//bi-directional many-to-one association to Flower
	@ManyToOne
	@JoinColumn(name="FlowerId")
	private Flower flower;

	//bi-directional many-to-one association to FlowerType
	@ManyToOne
	@JoinColumn(name="FlowerTypeId")
	private FlowerType flowerType;

	public Flower_FlowerType() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Flower getFlower() {
		return this.flower;
	}

	public void setFlower(Flower flower) {
		this.flower = flower;
	}

	public FlowerType getFlowerType() {
		return this.flowerType;
	}

	public void setFlowerType(FlowerType flowerType) {
		this.flowerType = flowerType;
	}

}