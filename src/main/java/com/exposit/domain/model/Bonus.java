package com.exposit.domain.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bonus")
public class Bonus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bonus_id")
	private Integer id;

	@Column(name = "sum_bound")
	private double sumBound;

	@Column(name = "percentage")
	private double percentage;

	// TODO the same question!
	private List<User> users;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
