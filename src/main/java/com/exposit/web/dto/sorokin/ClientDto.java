package com.exposit.web.dto.sorokin;

import com.exposit.domain.model.sorokin.Client;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

public class ClientDto {
	public Client getProfile() {
		return profile;
	}

	public void setProfile(Client profile) {
		this.profile = profile;
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

	public ClientDto(Client dbClient, byte[] avatar, Integer orderCount) {
		this.profile = dbClient;
		this.encodedAvatar = Base64.encode(avatar);
		this.orderCount = orderCount;
	}

	private Client profile;
	private String encodedAvatar;
	private Integer orderCount;

}
