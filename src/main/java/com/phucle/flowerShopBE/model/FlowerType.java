package com.phucle.flowerShopBE.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the FlowerTypes database table.
 * 
 */
@Entity
@Table(name="FlowerTypes")
@NamedQuery(name="FlowerType.findAll", query="SELECT f FROM FlowerType f")
public class FlowerType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="FlowerTypeId")
	private int flowerTypeId;

	@Column(name="TypeName")
	private String typeName;

	//bi-directional many-to-one association to Flower_FlowerType
	@OneToMany(mappedBy="flowerType")
	private List<Flower_FlowerType> flowerFlowerTypes;

	public FlowerType() {
	}

	public int getFlowerTypeId() {
		return this.flowerTypeId;
	}

	public void setFlowerTypeId(int flowerTypeId) {
		this.flowerTypeId = flowerTypeId;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public List<Flower_FlowerType> getFlowerFlowerTypes() {
		return this.flowerFlowerTypes;
	}

	public void setFlowerFlowerTypes(List<Flower_FlowerType> flowerFlowerTypes) {
		this.flowerFlowerTypes = flowerFlowerTypes;
	}

	public Flower_FlowerType addFlowerFlowerType(Flower_FlowerType flowerFlowerType) {
		getFlowerFlowerTypes().add(flowerFlowerType);
		flowerFlowerType.setFlowerType(this);

		return flowerFlowerType;
	}

	public Flower_FlowerType removeFlowerFlowerType(Flower_FlowerType flowerFlowerType) {
		getFlowerFlowerTypes().remove(flowerFlowerType);
		flowerFlowerType.setFlowerType(null);

		return flowerFlowerType;
	}

}