package com.exposit.domain.model.zanevsky;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "status")
public class Status {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(fetch = FetchType.EAGER)
	@Column(name = "status_id")
	private int id;
	
	@Basic(fetch = FetchType.EAGER)
	@Column(name = "status_name")
	@Enumerated(EnumType.STRING)
	private StatusType statusType;
	
	private List<OrderUnit> orderUnit;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public StatusType getStatusType() {
		return statusType;
	}
	public void setStatusType(StatusType statusType) {
		this.statusType = statusType;
	}
	public List<OrderUnit> getOrderUnit() {
		return orderUnit;
	}
	public void setOrderUnit(List<OrderUnit> orderUnit) {
		this.orderUnit = orderUnit;
	}
	
}
