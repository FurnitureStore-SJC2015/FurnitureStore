package com.exposit.domain.model.sorokin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "payment_form", uniqueConstraints = { @UniqueConstraint(
		columnNames = { "payment_type" }) })
public class PaymentForm {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "payment_type_id")
	private Integer id;

	@Column(name = "payment_type")
	@Enumerated(EnumType.STRING)
	private PaymentType name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PaymentType getName() {
		return name;
	}

	public void setName(PaymentType name) {
		this.name = name;
	}

}
