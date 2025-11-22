package com.phucle.flowerShopBE.model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the payment_method database table.
 * 
 */
@Entity
@Table(name="payment_method")
@NamedQuery(name="PaymentMethod.findAll", query="SELECT p FROM PaymentMethod p")
public class PaymentMethod implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="payment_method_id")
	private int paymentMethodId;

	private String description;

	@Column(name="method_name")
	private String methodName;

	public PaymentMethod() {
	}

	public int getPaymentMethodId() {
		return this.paymentMethodId;
	}

	public void setPaymentMethodId(int paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMethodName() {
		return this.methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

}