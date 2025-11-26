package com.phucle.flowerShopBE.model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the Flower_Design database table.
 * 
 */
@Entity
@NamedQuery(name="Flower_Design.findAll", query="SELECT f FROM Flower_Design f")
public class Flower_Design implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Id")
	private int id;

	//bi-directional many-to-one association to Design
	@ManyToOne
	@JoinColumn(name="DesignId")
	private Design design;

	//bi-directional many-to-one association to Flower
	@ManyToOne
	@JoinColumn(name="FlowerId")
	private Flower flower;

	public Flower_Design() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Design getDesign() {
		return this.design;
	}

	public void setDesign(Design design) {
		this.design = design;
	}

	public Flower getFlower() {
		return this.flower;
	}

	public void setFlower(Flower flower) {
		this.flower = flower;
	}

}