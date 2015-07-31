package com.exposit.domain.model.dobrilko;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.exposit.domain.model.zanevsky.Module;

public class Provider {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "provider_id")
	private int id;
	@Column(name = "provider_name")
	private String name;
	@Column(name = "provider_email")
	private String email;
	@Column(name = "phone")
	private String phone;
	@Column(name = "zip_code")
	private String zipCode;
	/*
	 * @ManyToMany(fetch = FetchType.LAZY)
	 * 
	 * @JoinTable(name = "provider_module", joinColumns = { @JoinColumn( name =
	 * "provider_id", nullable = false) }, inverseJoinColumns = {
	 * 
	 * @JoinColumn(name = "module_id", nullable = false) })
	 * 
	 * @Cascade({ CascadeType.SAVE_UPDATE, CascadeType.DELETE }) private
	 * List<Module> modules;
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "provider",
			orphanRemoval = true)
	private List<Request> requests;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "provider",
			orphanRemoval = true)
	private List<Shipment> shipments;
	@Column(name = "login")
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

	/*
	 * public List<Module> getModules() { return modules; }
	 * 
	 * public void setModules(List<Module> modules) { this.modules = modules; }
	 */

	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

	public List<Shipment> getShipments() {
		return shipments;
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
