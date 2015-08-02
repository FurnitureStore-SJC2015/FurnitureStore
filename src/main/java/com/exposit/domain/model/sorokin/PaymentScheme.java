package com.exposit.domain.model.sorokin;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "payment_scheme")
public class PaymentScheme {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "payment_scheme_id")
	private Integer id;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "payment_type_id")
	private PaymentForm paymentForm;

	@Column(name = "term")
	private Integer term;

	@Column(name = "penalty")
	private double penalty;

	@Column(name = "number_of_payments")
	private Integer numberOfPayments;

	@Column(name = "interest_rate")
	private double percentage;

	@OneToMany
	@JoinColumn(name = "payment_scheme_id")
	private List<Order> orders;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PaymentForm getPaymentForm() {
		return paymentForm;
	}

	public void setPaymentForm(PaymentForm paymentForm) {
		this.paymentForm = paymentForm;
	}

	public Integer getTerm() {
		return term;
	}

	public void setTerm(Integer term) {
		this.term = term;
	}

	public double getPenalty() {
		return penalty;
	}

	public void setPenalty(double penalty) {
		this.penalty = penalty;
	}

	public Integer getNumberOfPayments() {
		return numberOfPayments;
	}

	public void setNumberOfPayments(Integer numberOfPayments) {
		this.numberOfPayments = numberOfPayments;
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
