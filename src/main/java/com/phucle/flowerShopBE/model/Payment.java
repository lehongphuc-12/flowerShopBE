package com.phucle.flowerShopBE.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the Payments database table.
 * 
 */
@Entity
@Table(name="Payments")
@NamedQuery(name="Payment.findAll", query="SELECT p FROM Payment p")
public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PaymentId")
	private int paymentId;

	@Column(name="PaidAmount")
	private BigDecimal paidAmount;

	@Column(name="PaidAt")
	private Timestamp paidAt;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="OrderId")
	private Order order;

	//bi-directional many-to-one association to PaymentMethod
	@ManyToOne
	@JoinColumn(name="PaymentMethodId")
	private PaymentMethod paymentMethod;

	public Payment() {
	}

	public int getPaymentId() {
		return this.paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public BigDecimal getPaidAmount() {
		return this.paidAmount;
	}

	public void setPaidAmount(BigDecimal paidAmount) {
		this.paidAmount = paidAmount;
	}

	public Timestamp getPaidAt() {
		return this.paidAt;
	}

	public void setPaidAt(Timestamp paidAt) {
		this.paidAt = paidAt;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public PaymentMethod getPaymentMethod() {
		return this.paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

}