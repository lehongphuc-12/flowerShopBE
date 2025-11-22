package com.phucle.flowerShopBE.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the flower_types database table.
 * 
 */
@Entity
@Table(name="flower_types")
@NamedQuery(name="FlowerType.findAll", query="SELECT f FROM FlowerType f")
public class FlowerType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="flower_type_id")
	private int flowerTypeId;

	@Column(name="type_name")
	private String typeName;

	//bi-directional many-to-one association to FlowerFlowerType
	@OneToMany(mappedBy="flowerType")
	private List<FlowerFlowerType> flowerFlowerTypes;

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

	public List<FlowerFlowerType> getFlowerFlowerTypes() {
		return this.flowerFlowerTypes;
	}

	public void setFlowerFlowerTypes(List<FlowerFlowerType> flowerFlowerTypes) {
		this.flowerFlowerTypes = flowerFlowerTypes;
	}

	public FlowerFlowerType addFlowerFlowerType(FlowerFlowerType flowerFlowerType) {
		getFlowerFlowerTypes().add(flowerFlowerType);
		flowerFlowerType.setFlowerType(this);

		return flowerFlowerType;
	}

	public FlowerFlowerType removeFlowerFlowerType(FlowerFlowerType flowerFlowerType) {
		getFlowerFlowerTypes().remove(flowerFlowerType);
		flowerFlowerType.setFlowerType(null);

		return flowerFlowerType;
	}

}