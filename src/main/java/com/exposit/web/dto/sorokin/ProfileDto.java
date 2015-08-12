package com.exposit.web.dto.sorokin;

import com.exposit.domain.model.sorokin.Client;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

public class ProfileDto {

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getEncodedAvatar() {
		return encodedAvatar;
	}

	public void setEncodedAvatar(String encodedAvatar) {
		this.encodedAvatar = encodedAvatar;
	}

	public Integer getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(Integer orderCount) {
		this.orderCount = orderCount;
	}

	private Client client;

	private String encodedAvatar;

	private Integer orderCount;

	public ProfileDto(Client client, byte[] avatar, Integer orderCount) {
		this.client = client;
		this.encodedAvatar = new String(Base64.encode(avatar));
		this.orderCount = orderCount;
	}

}
