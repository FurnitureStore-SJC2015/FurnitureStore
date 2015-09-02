package com.exposit.web.dto;

public class StorageModuleUnitDto {

	private int id;

	private String moduleName;

	private int moduleId;

	private int count;

	private double fullMargin;

	private double moduleCost;

	private String image;

	public StorageModuleUnitDto(Builder builder) {
		this.id = builder.getId();
		this.count = builder.getCount();
		this.moduleName = builder.getModuleName();
		this.moduleCost = builder.getModuleCost();
		this.fullMargin = builder.getFullMargin();
		this.moduleId = builder.getModuleId();
		this.image = builder.getImage();

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

	public String getImage() {
		return image;
	}

	public int getModuleId() {
		return moduleId;
	}

	public static class Builder {

		private int id;

		private String moduleName;

		private int moduleId;

		private int count;

		private double fullMargin;

		private double moduleCost;

		private String image;

		public Builder(int id, int count, String moduleName, double moduleCost,
				int moduleId, double fullMargin, String image) {
			this.id = id;
			this.count = count;
			this.moduleName = moduleName;
			this.moduleCost = moduleCost;
			this.fullMargin = fullMargin;
			this.moduleId = moduleId;
			this.image = image;
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

		public String getImage() {
			return image;
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
