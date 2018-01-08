package com.marsboy.monitor.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles", catalog = "monitor")
public class Roles implements java.io.Serializable {

	private Byte roleid;
	private String rolename;
	private Set<User> users = new HashSet<User>(0);

	public Roles() {
	}

	public Roles(String rolename) {
		this.rolename = rolename;
	}

	public Roles(String rolename, Set<User> users) {
		this.rolename = rolename;
		this.users = users;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "roleid", unique = true, nullable = false)
	public Byte getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Byte roleid) {
		this.roleid = roleid;
	}

	@Column(name = "rolename", nullable = false)
	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "roles")
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
