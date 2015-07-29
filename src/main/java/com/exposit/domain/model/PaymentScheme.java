package com.exposit.domain.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payment_scheme")
public class PaymentScheme {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "payment_scheme_id")
	private Integer id;

	@Column(name = "payment_type_id")
	private PaymentForm paymentType;

	@Column(name = "term")
	private Date term;

	@Column(name = "penalty")
	private double penalty;

	@Column(name = "cycle")
	private Date cycle;

	@Column(name = "interest_rate")
	private double percentage;

	private List<Order> orders;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PaymentForm getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentForm paymentType) {
		this.paymentType = paymentType;
	}

	public Date getTerm() {
		return term;
	}

	public void setTerm(Date term) {
		this.term = term;
	}

	public double getPenalty() {
		return penalty;
	}

	public void setPenalty(double penalty) {
		this.penalty = penalty;
	}

	public Date getCycle() {
		return cycle;
	}

	public void setCycle(Date cycle) {
		this.cycle = cycle;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
