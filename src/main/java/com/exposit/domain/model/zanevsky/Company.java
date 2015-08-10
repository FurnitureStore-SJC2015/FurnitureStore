package com.exposit.domain.model.zanevsky;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.exposit.domain.model.sorokin.User;

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
	
	
}
