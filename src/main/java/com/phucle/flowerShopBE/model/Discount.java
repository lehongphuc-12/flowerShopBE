package com.phucle.flowerShopBE.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the Discounts database table.
 * 
 */
@Entity
@Table(name="Discounts")
@NamedQuery(name="Discount.findAll", query="SELECT d FROM Discount d")
public class Discount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DiscountId")
	private int discountId;

	@Column(name="Amount")
	private BigDecimal amount;

	@Column(name="DiscountName")
	private String discountName;

	@Column(name="EndDate")
	private Timestamp endDate;

	@Column(name="IsActive")
	private boolean isActive;

	@Column(name="Percentage")
	private BigDecimal percentage;

	@Column(name="StartDate")
	private Timestamp startDate;

	//bi-directional many-to-one association to Flower_Discount
	@OneToMany(mappedBy="discount")
	private List<Flower_Discount> flowerDiscounts;

	public Discount() {
	}

	public int getDiscountId() {
		return this.discountId;
	}

	public void setDiscountId(int discountId) {
		this.discountId = discountId;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getDiscountName() {
		return this.discountName;
	}

	public void setDiscountName(String discountName) {
		this.discountName = discountName;
	}

	public Timestamp getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public BigDecimal getPercentage() {
		return this.percentage;
	}

	public void setPercentage(BigDecimal percentage) {
		this.percentage = percentage;
	}

	public Timestamp getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public List<Flower_Discount> getFlowerDiscounts() {
		return this.flowerDiscounts;
	}

	public void setFlowerDiscounts(List<Flower_Discount> flowerDiscounts) {
		this.flowerDiscounts = flowerDiscounts;
	}

	public Flower_Discount addFlowerDiscount(Flower_Discount flowerDiscount) {
		getFlowerDiscounts().add(flowerDiscount);
		flowerDiscount.setDiscount(this);

		return flowerDiscount;
	}

	public Flower_Discount removeFlowerDiscount(Flower_Discount flowerDiscount) {
		getFlowerDiscounts().remove(flowerDiscount);
		flowerDiscount.setDiscount(null);

		return flowerDiscount;
	}

}