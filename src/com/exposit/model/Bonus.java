package com.exposit.model;

import java.util.List;

public class Bonus {

	private int id;
	private double sumBound;
	private double percentage;
	private List<User> users;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSumBound() {
		return sumBound;
	}

	public void setSumBound(double sumBound) {
		this.sumBound = sumBound;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
