package com.phucle.flowerShopBE.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the Designs database table.
 * 
 */
@Entity
@Table(name="Designs")
@NamedQuery(name="Design.findAll", query="SELECT d FROM Design d")
public class Design implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DesignId")
	private int designId;

	@Column(name="Description")
	private String description;

	@Column(name="DesignName")
	private String designName;

	//bi-directional many-to-one association to Flower_Design
	@OneToMany(mappedBy="design")
	private List<Flower_Design> flowerDesigns;

	public Design() {
	}

	public int getDesignId() {
		return this.designId;
	}

	public void setDesignId(int designId) {
		this.designId = designId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDesignName() {
		return this.designName;
	}

	public void setDesignName(String designName) {
		this.designName = designName;
	}

	public List<Flower_Design> getFlowerDesigns() {
		return this.flowerDesigns;
	}

	public void setFlowerDesigns(List<Flower_Design> flowerDesigns) {
		this.flowerDesigns = flowerDesigns;
	}

	public Flower_Design addFlowerDesign(Flower_Design flowerDesign) {
		getFlowerDesigns().add(flowerDesign);
		flowerDesign.setDesign(this);

		return flowerDesign;
	}

	public Flower_Design removeFlowerDesign(Flower_Design flowerDesign) {
		getFlowerDesigns().remove(flowerDesign);
		flowerDesign.setDesign(null);

		return flowerDesign;
	}

}