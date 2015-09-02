package com.exposit.domain.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "company")
@PrimaryKeyJoinColumn(name = "id")
public class Company extends User {
	
	@Basic(fetch = FetchType.EAGER)
	@Column(name = "address")
	private String address;
	
	@Basic(fetch = FetchType.EAGER)
	@Column(name = "zip")
	private String zip;
	
	@Basic(fetch = FetchType.EAGER)
	@Column(name = "director")
	private String director;

	@Basic(fetch = FetchType.EAGER)
	@Column(name = "description")
	private String description;

	@Basic(fetch = FetchType.EAGER)
	@Column(name = "company_name")
	private String companyName;
	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String adrress) {
		this.address = adrress;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
