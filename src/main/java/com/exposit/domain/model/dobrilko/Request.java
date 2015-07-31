package com.exposit.domain.model.dobrilko;

import java.util.Date;
import java.util.List;

public class Request {
	
	private int id;
	private Date requestDate;
	private Provider provider;
	private List<RequestUnit> requestUnits;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getRequestDate() {
		return requestDate;
	}
	
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	
	public Provider getProvider() {
		return provider;
	}
	
	public void setProvider(Provider provider) {
		this.provider = provider;
	}
	
	public List<RequestUnit> getRequestUnits() {
		return requestUnits;
	}
	
	public void setRequestUnits(List<RequestUnit> requestUnits) {
		this.requestUnits = requestUnits;
	}
}
