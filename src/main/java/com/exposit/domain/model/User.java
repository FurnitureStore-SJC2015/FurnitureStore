package com.exposit.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "user", uniqueConstraints = { @UniqueConstraint(columnNames = {
		"login", "email" }) })
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Integer id;

	@Size(min = 3, max = 10,
			message = "*Name must be between 3 and 10 characters long.")
	@Pattern(regexp = "[a-zA-Z]*",
			message = "*Name must be alphanumeric with no spaces.")
	@Column(name = "name")
	private String name;

	@Size(min = 3, max = 10,
			message = "*Surname must be between 3 and 10 characters long.")
	@Pattern(regexp = "[a-zA-Z]*",
			message = "*Surname must be alphanumeric with no spaces.")
	@Column(name = "surname")
	private String surname;
	@Size(min = 3, max = 10,
			message = "*Login must be between 3 and 10 characters long.")
	@Pattern(regexp = "[a-zA-Z0-9_-]*",
			message = "*Login must be alphanumeric with digits and dashes.")
	private String login;

	private String password;

	@Pattern(
			regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})",
			message = "*Not valid email.")
	@Column(name = "email")
	private String email;

	@ManyToOne(fetch = FetchType.EAGER)
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "role_id", referencedColumnName = "role_id")
	private Role role;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
