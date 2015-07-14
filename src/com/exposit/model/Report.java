package com.exposit.model;

import java.util.Date;

public class Report {

	private int id;
	private Date reportDate;
	private double fullCost;
	private Cargo cargo;
	private Provider provider;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getReportDate() {
		return reportDate;
	}
	
	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}
	
	public double getFullCost() {
		return fullCost;
	}
	
	public void setFullCost(double fullCost) {
		this.fullCost = fullCost;
	}
	
	public Cargo getCargo() {
		return cargo;
	}
	
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	
	public Provider getProvider() {
		return provider;
	}
	
	public void setProvider(Provider provider) {
		this.provider = provider;
	}
}
