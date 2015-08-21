package com.exposit.domain.model.dobrilko;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.exposit.domain.model.sorokin.User;
import com.exposit.domain.model.zanevsky.Module;

@Entity
@Table(name = "provider")
@PrimaryKeyJoinColumn(name="provider_id")
public class Provider extends User {

	@Pattern(regexp = "[A-Z][a-zA-Z|| ||\\-||&||\"||0-9]*]*",
			message = "Provider name should: 1. Start from capital letter"
					+ "2. Contain only letters, numeric symbols, spaces,"
					+ " quotes, dashes and ampersand.")
	@Size(max = 50, message = "Provider name lenght must be less than 50.")
	@NotNull(message = "Provider name is a mandatory.")
	@Column(name = "provider_name", unique = true)
	private String providerName;

	@Pattern(regexp = "^[0-9]{12}$",
			message = "Phone number must be 12 digits string!")
	@Column(name = "phone")
	private String phone;
	@Pattern(regexp = "^[0-9]{6}$",
			message = "Zip code must be 6 digits string!")
	@Column(name = "zip_code")
	private String zipCode;

	@OneToMany(mappedBy = "provider", orphanRemoval = true)
	private List<Module> modules;

	@OneToMany(mappedBy = "provider", orphanRemoval = true)
	private List<Request> requests;

	@OneToMany(mappedBy = "provider", orphanRemoval = true)
	private List<Shipment> shipments;

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

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

}
