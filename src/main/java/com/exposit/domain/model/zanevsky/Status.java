package com.exposit.domain.model.zanevsky;

import java.util.List;

public class Status {

	private int id;
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
