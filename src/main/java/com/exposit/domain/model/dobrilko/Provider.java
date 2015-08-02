package com.exposit.domain.model.dobrilko;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.exposit.domain.model.zanevsky.Module;

@Entity
@Table(name = "provider")
public class Provider {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "provider_id")
	private int id;
	@Column(name = "provider_name", unique = true)
	private String name;
	@Column(name = "provider_email")
	private String email;
	@Column(name = "phone")
	private String phone;
	@Column(name = "zip_code")
	private String zipCode;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "provider",
			orphanRemoval = true)
	private List<Module> modules;

	@OneToMany(mappedBy = "provider", orphanRemoval = true)
	private List<Request> requests;

	@OneToMany(mappedBy = "provider", orphanRemoval = true)
	private List<Shipment> shipments;

	@Column(name = "provider_login", unique = true)
	private String login;

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

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

	public void setShipments(List<Shipment> shipments) {
		this.shipments = shipments;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

}
