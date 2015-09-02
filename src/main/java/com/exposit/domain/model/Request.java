package com.exposit.domain.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "request")
public class Request {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "request_id")
	private int id;

	@Column(name = "request_date")
	private Date requestDate;

	@ManyToOne
	@JoinColumn(name = "provider_id", nullable = false)
	private Provider provider;

	@OneToMany
	@JoinColumn(name = "request_id")
	private List<RequestUnit> requestUnits;
	
	@Column(name="is_processed")
	private boolean isProcessed;

	public Request() {

	}

	public Request(Date requestDate, Provider provider) {

		this.setProvider(provider);
		this.setRequestDate(requestDate);

	}

	public Request(int id, Date requestDate, Provider provider,
			List<RequestUnit> requestUnits) {
		this.setId(id);
		this.setProvider(provider);
		this.setRequestDate(requestDate);
		this.setRequestUnits(requestUnits);
	}

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

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public void setRequestUnits(List<RequestUnit> requestUnits) {
		this.requestUnits = requestUnits;
	}

	public boolean isProcessed() {
		return isProcessed;
	}

	public void setProcessed(boolean isProcessed) {
		this.isProcessed = isProcessed;
	}
}
