package com.exposit.web.dto.dobrilko;

import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class RequestUnitDto {

	@NotNull(message = "Modules count is a mandatory.")
	@Max(value = 20, message = "Modules count must be less than 20.")
	@Min(value = 0, message = "Modules count must be greater than 0.")
	private int count;

	private int moduleId;

	@NotEmpty
	private String countString;
	
	private int id;

	private String moduleName;

	private double moduleCost;

	@NotNull(message = "Chosen provider is a mandatory.")
	@NotEmpty
	private String chosenProvider;

	public RequestUnitDto() {

	}

	public RequestUnitDto(Builder builder) {

		this.count = builder.getCount();
		this.moduleName = builder.getModuleName();
		this.moduleCost = builder.getModuleCost();

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

	public void setCount(Integer count) {
		this.count = count;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public void setModuleCost(double moduleCost) {
		this.moduleCost = moduleCost;
	}

	public void setChosenProvider(String chosenProvider) {
		this.chosenProvider = chosenProvider;
	}

	public int getModuleId() {
		return moduleId;
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}

	public String getCountString() {
		return countString;
	}

	public void setCountString(String countString) {
		this.countString = countString;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static class Builder {

		private int moduleId;

		private int count;

		private String countString;

		private String moduleName;

		private double moduleCost;

		private List<String> providerNames;

		private String chosenProvider;

		public Builder() {

		}

		public Builder(int moduleId, int count, String moduleName,
				double moduleCost, List<String> providerNames,
				String chosenProvider) {
			this.moduleId = moduleId;
			this.count = count;
			this.moduleName = moduleName;
			this.moduleCost = moduleCost;
			this.providerNames = providerNames;
			this.chosenProvider = chosenProvider;
			this.moduleId = moduleId;

		}

		public Builder(String countString, String moduleName, Integer moduleId,
				double moduleCost, List<String> providerNames,
				String chosenProvider) {
			this.moduleId = moduleId;
			this.countString = countString;
			this.moduleName = moduleName;
			this.moduleCost = moduleCost;
			this.providerNames = providerNames;
			this.chosenProvider = chosenProvider;
			this.moduleId = moduleId;

		}

		public Builder(int count, String moduleName, Integer moduleId,
				double moduleCost, List<String> providerNames) {

			this.count = count;
			this.moduleName = moduleName;
			this.moduleCost = moduleCost;
			this.providerNames = providerNames;
			this.moduleId = moduleId;

		}

		public Builder moduleId(Integer moduleId) {
			this.moduleId = moduleId;
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

		public int getModuleId() {
			return moduleId;
		}

		public String getCountString() {
			return countString;
		}

		public void setCountString(String countString) {
			this.countString = countString;
		}

	}
}
