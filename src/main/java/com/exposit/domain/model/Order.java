package com.exposit.domain.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id")
	private Integer id;

	@Column(name = "order_date")
	private Date orderDate;

	@Column(name = "execution_date")
	private Date executionDate;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "order_id")
	@Fetch(FetchMode.SUBSELECT)
	private List<Payment> payments;

	@ManyToOne
	@JoinColumn(name = "payment_scheme_id")
	private PaymentScheme paymentScheme;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getExecutionDate() {
		return executionDate;
	}

	public void setExecutionDate(Date executionDate) {
		this.executionDate = executionDate;
	}

	public User getUser() {
		return user;
	}

	/*
	 * public void setUser(User user) { this.user = user; }
	 */

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public PaymentScheme getPaymentScheme() {
		return paymentScheme;
	}

	public void setPaymentScheme(PaymentScheme paymentScheme) {
		this.paymentScheme = paymentScheme;
	}

}
