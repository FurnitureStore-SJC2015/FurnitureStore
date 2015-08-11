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

@Entity
@Table(name = "client")
@PrimaryKeyJoinColumn(name = "id")
public class Client extends User {

	@Column(name = "avatar")
	@Lob
	private byte[] avatar;

	public byte[] getAvatar() {
		return avatar;
	}

	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "bonus_id", insertable = false, updatable = false,
			columnDefinition = "int default 2")
	private Bonus bonus;

	@OneToMany
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "client_id")
	private List<Order> orders;

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