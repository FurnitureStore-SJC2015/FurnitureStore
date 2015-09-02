package com.exposit.domain.model;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "state")
public class Status {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(fetch = FetchType.EAGER)
	@Column(name = "state_id")
	private int id;
	
	@Basic(fetch = FetchType.EAGER)
	@Column(name = "state_name")
	@Enumerated(EnumType.STRING)
	private StatusType statusType;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "status", cascade = CascadeType.ALL)
	private List<OrderUnit> orderUnits;
	
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
		return orderUnits;
	}
	public void setOrderUnit(List<OrderUnit> orderUnit) {
		this.orderUnits = orderUnit;
	}
	
}
