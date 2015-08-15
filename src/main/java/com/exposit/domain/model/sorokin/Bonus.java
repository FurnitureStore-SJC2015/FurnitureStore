package com.exposit.domain.model.sorokin;

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

	@Column(name = "flag")
	private Boolean flag;

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

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

}
