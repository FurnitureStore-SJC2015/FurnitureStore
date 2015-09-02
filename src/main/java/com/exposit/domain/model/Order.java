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

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id")
	private Integer id;

	@Column(name = "order_date")
	private Date orderDate;

	@Column(name = "assembly_date")
	private Date assemblyDate;

	@Column(name = "execution_date")
	private Date executionDate;

	@OneToMany
	@JoinColumn(name = "order_id")
	@Cascade(CascadeType.ALL)
	private List<Payment> payments;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "payment_scheme_id")
	private PaymentScheme paymentScheme;

	@ManyToOne(fetch=FetchType.EAGER)
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "client_id")
	private Client client;

	@OneToMany
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private List<OrderUnit> orderUnits;

	public Date getAssemblyDate() {
		return assemblyDate;
	}

	public void setAssemblyDate(Date assemblyDate) {
		this.assemblyDate = assemblyDate;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

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

	public void setOrderUnits(List<OrderUnit> orderUnits) {
		this.orderUnits = orderUnits;
	}

	public List<OrderUnit> getOrderUnits() {
		return orderUnits;
	}

}
