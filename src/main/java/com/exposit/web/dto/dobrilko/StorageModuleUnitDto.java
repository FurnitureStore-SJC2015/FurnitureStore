package com.exposit.web.dto.dobrilko;

public class StorageModuleUnitDto {

	private int id;

	private String moduleName;

	private int moduleId;

	private int count;

	private double fullMargin;

	private double moduleCost;

	public StorageModuleUnitDto(Builder builder) {
		this.id = builder.getId();
		this.count = builder.getCount();
		this.moduleName = builder.getModuleName();
		this.moduleCost = builder.getModuleCost();
		this.fullMargin = builder.getFullMargin();
		this.moduleId = builder.getModuleId();

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

	public static class Builder {

		private int id;

		private String moduleName;

		private int moduleId;

		private int count;

		private double fullMargin;

		private double moduleCost;

		public Builder(int id, int count, String moduleName, double moduleCost,
				int moduleId, double fullMargin) {
			this.id = id;
			this.count = count;
			this.moduleName = moduleName;
			this.moduleCost = moduleCost;
			this.fullMargin = fullMargin;
			this.moduleId = moduleId;
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

		public Builder fullMargin(double fullMargin) {
			this.fullMargin = fullMargin;
			return this;
		}

		public Builder moduleId(int moduleId) {
			this.moduleId = moduleId;
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

		public double getFullMargin() {
			return fullMargin;
		}

		public int getModuleId() {
			return moduleId;
		}

		public StorageModuleUnitDto build() {
			return new StorageModuleUnitDto(this);
		}

	}

}
