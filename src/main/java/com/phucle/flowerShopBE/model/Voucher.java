package com.phucle.flowerShopBE.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the Vouchers database table.
 * 
 */
@Entity
@Table(name="Vouchers")
@NamedQuery(name="Voucher.findAll", query="SELECT v FROM Voucher v")
public class Voucher implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="VoucherId")
	private int voucherId;

	@Column(name="Amount")
	private BigDecimal amount;

	@Column(name="Code")
	private String code;

	@Column(name="Description")
	private String description;

	@Column(name="ExpiredAt")
	private Timestamp expiredAt;

	@Column(name="IsActive")
	private boolean isActive;

	@Column(name="MaxDiscount")
	private BigDecimal maxDiscount;

	@Column(name="MinOrder")
	private BigDecimal minOrder;

	@Column(name="Percentage")
	private BigDecimal percentage;

	@Column(name="Quantity")
	private int quantity;

	public Voucher() {
	}

	public int getVoucherId() {
		return this.voucherId;
	}

	public void setVoucherId(int voucherId) {
		this.voucherId = voucherId;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getExpiredAt() {
		return this.expiredAt;
	}

	public void setExpiredAt(Timestamp expiredAt) {
		this.expiredAt = expiredAt;
	}

	public boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public BigDecimal getMaxDiscount() {
		return this.maxDiscount;
	}

	public void setMaxDiscount(BigDecimal maxDiscount) {
		this.maxDiscount = maxDiscount;
	}

	public BigDecimal getMinOrder() {
		return this.minOrder;
	}

	public void setMinOrder(BigDecimal minOrder) {
		this.minOrder = minOrder;
	}

	public BigDecimal getPercentage() {
		return this.percentage;
	}

	public void setPercentage(BigDecimal percentage) {
		this.percentage = percentage;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}