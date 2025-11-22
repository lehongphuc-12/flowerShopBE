package com.phucle.flowerShopBE.model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the flower_flower_type database table.
 * 
 */
@Entity
@Table(name="flower_flower_type")
@NamedQuery(name="FlowerFlowerType.findAll", query="SELECT f FROM FlowerFlowerType f")
public class FlowerFlowerType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to FlowerType
	@ManyToOne
	@JoinColumn(name="flower_type_id")
	private FlowerType flowerType;

	//bi-directional many-to-one association to Flower
	@ManyToOne
	@JoinColumn(name="flower_id")
	private Flower flower;

	public FlowerFlowerType() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public FlowerType getFlowerType() {
		return this.flowerType;
	}

	public void setFlowerType(FlowerType flowerType) {
		this.flowerType = flowerType;
	}

	public Flower getFlower() {
		return this.flower;
	}

	public void setFlower(Flower flower) {
		this.flower = flower;
	}

}