package com.exposit.web.dto.dobrilko;

import java.util.List;

public class RequestUnitDto {

	private int id;

	private int count;

	private String moduleName;

	private double moduleCost;

	private List<String> providerNames;

	private String chosenProvider;

	private RequestUnitDto(Builder builder) {
		this.id = builder.getId();
		this.count = builder.getCount();
		this.moduleName = builder.getModuleName();
		this.moduleCost = builder.getModuleCost();
		this.providerNames = builder.getProviderNames();
	}

	public int getId() {
		return id;
	}

	public int getCount() {
		return count;
	}

	public String getModuleName() {
		return moduleName;
	}

	public double getModuleCost() {
		return moduleCost;
	}

	public List<String> getProviderNames() {
		return providerNames;
	}

	public String getChosenProvider() {
		return chosenProvider;
	}

	public static class Builder {

		private int id;

		private int count;

		private String moduleName;

		private double moduleCost;

		private List<String> providerNames;

		private String chosenProvider;

		public Builder(int id, int count, String moduleName, double moduleCost,
				List<String> providerNames, String chosenProvider) {
			this.id = id;
			this.count = count;
			this.moduleName = moduleName;
			this.moduleCost = moduleCost;
			this.providerNames = providerNames;
			this.chosenProvider = chosenProvider;
		}

		public Builder(int id, int count, String moduleName, double moduleCost,
				List<String> providerNames) {
			this.id = id;
			this.count = count;
			this.moduleName = moduleName;
			this.moduleCost = moduleCost;
			this.providerNames = providerNames;
		}

		public Builder(int count, String moduleName, double moduleCost,
				List<String> providerNames) {

			this.count = count;
			this.moduleName = moduleName;
			this.moduleCost = moduleCost;
			this.providerNames = providerNames;
		}

		public Builder id(Integer id) {
			this.id = id;
			return this;
		}

		public Builder count(Integer count) {
			this.count = count;
			return this;
		}

		public Builder moduleName(String moduleName) {
			this.moduleName = moduleName;
			return this;
		}

		public Builder moduleCost(double moduleCost) {
			this.moduleCost = moduleCost;
			return this;
		}

		public Builder providerNames(List<String> providerNames) {
			this.providerNames = providerNames;
			return this;
		}

		public Builder chosenProvider(String chosenProvider) {
			this.chosenProvider = chosenProvider;
			return this;
		}

		public int getId() {
			return id;
		}

		public int getCount() {
			return count;
		}

		public String getModuleName() {
			return moduleName;
		}

		public double getModuleCost() {
			return moduleCost;
		}

		public String getChosenProvider() {
			return chosenProvider;
		}

		public List<String> getProviderNames() {
			return providerNames;
		}

		public RequestUnitDto build() {
			return new RequestUnitDto(this);
		}

	}
}
