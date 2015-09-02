package com.exposit.web.dto;

import com.exposit.domain.model.Client;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

public class ClientDto {

	private Client profile;
	private Integer orderCount;

	private ClientDto(Builder builder) {
		this.profile = builder.getProfile();
		this.orderCount = builder.getOrderCount();
	}

	public Client getProfile() {
		return profile;
	}

	public Integer getOrderCount() {
		return orderCount;
	}

	public static class Builder {

		private Client profile;
		private Integer orderCount;

		public Builder(Client profile, Integer orderCount) {
			this.profile = profile;
			this.orderCount = orderCount;
		}

		public Builder profile(Client profile) {
			this.profile = profile;
			return this;
		}

		public Builder orderCount(Integer orderCount) {
			this.orderCount = orderCount;
			return this;
		}

		public Client getProfile() {
			return profile;
		}

		public Integer getOrderCount() {
			return orderCount;
		}

		public ClientDto build() {
			return new ClientDto(this);
		}

	}

}
