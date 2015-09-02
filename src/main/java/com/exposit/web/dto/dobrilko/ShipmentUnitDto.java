package com.exposit.web.dto.dobrilko;

public class ShipmentUnitDto {

	private int id;

	private int count;

	private String moduleName;

	private double moduleCost;
	
	private double cost;

	private ShipmentUnitDto(Builder builder) {
		this.id = builder.getId();
		this.count = builder.getCount();
		this.moduleName = builder.getModuleName();
		this.moduleCost = builder.getModuleCost();
		this.cost =  builder.getCost();

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
	
	public double getCost() {
		return cost;
	}

	public static class Builder {

		private int id;

		private int count;

		private String moduleName;

		private double moduleCost;
		
		private double cost;

		public Builder(int id, int count, String moduleName, double moduleCost, double cost) {
			this.id = id;
			this.count = count;
			this.moduleName = moduleName;
			this.moduleCost = moduleCost;
			this.cost = cost;
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
		
		public Builder cost(double moduleCost) {
			this.cost = moduleCost;
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
		
		public double getCost() {
			return cost;
		}

		public ShipmentUnitDto build() {
			return new ShipmentUnitDto(this);
		}

	}
}
