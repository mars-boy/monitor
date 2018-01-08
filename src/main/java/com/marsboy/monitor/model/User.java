package com.marsboy.monitor.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user", catalog = "monitor")
public class User implements java.io.Serializable {

	private Long userid;
	private Roles roles;
	private String username;
	private String password;
	private Boolean active;
	private Set<Expenses> expenseses = new HashSet<Expenses>(0);

	public User() {
	}

	public User(Roles roles, String username, String password) {
		this.roles = roles;
		this.username = username;
		this.password = password;
	}

	public User(Roles roles, String username, String password, Boolean active, Set<Expenses> expenseses) {
		this.roles = roles;
		this.username = username;
		this.password = password;
		this.active = active;
		this.expenseses = expenseses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "userid", unique = true, nullable = false)
	public Long getUserid() {
		return this.userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role", nullable = false)
	public Roles getRoles() {
		return this.roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	@Column(name = "username", nullable = false)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 400)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "active")
	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Expenses> getExpenseses() {
		return this.expenseses;
	}

	public void setExpenseses(Set<Expenses> expenseses) {
		this.expenseses = expenseses;
	}

}
