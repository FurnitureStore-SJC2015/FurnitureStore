package com.exposit.model;

import java.util.List;

public class Provider {

	private int id;
	private String name;
	private String email;
	private String phone;
	private String zipCode;
	private List<Report> reports;
	private List<Module> modules;
	private List<Request> requests;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getZipCode() {
		return zipCode;
	}
	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public List<Report> getReports() {
		return reports;
	}
	
	public void setReports(List<Report> reports) {
		this.reports = reports;
	}
	
	public List<Module> getModules() {
		return modules;
	}
	
	public void setModules(List<Module> modules) {
		this.modules = modules;
	}
	
	public List<Request> getRequests() {
		return requests;
	}
	
	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}
}
