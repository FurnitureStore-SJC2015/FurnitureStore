package com.exposit.domain.model.sorokin;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.exposit.domain.model.zanevsky.Feedback;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

@Entity
@Table(name = "client")
@PrimaryKeyJoinColumn(name = "id")
public class Client extends User {

	@Column(name = "avatar")
	@Lob
	private byte[] avatar;

	public String getAvatar() {
		return Base64.encode(avatar);
	}

	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "bonus_id")
	private Bonus bonus;

	@OneToMany
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "client_id")
	private List<Order> orders;

	@OneToMany(mappedBy = "client")
	private List<Feedback> feedbacks;

	@Column(name = "total_spent")
	private double totalSpent;

	public double getTotalSpent() {
		return totalSpent;
	}

	public void setTotalSpent(Double totalSpent) {
		this.totalSpent += totalSpent;
	}

	public Bonus getBonus() {
		return bonus;
	}

	public void setBonus(Bonus bonus) {
		this.bonus = bonus;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}