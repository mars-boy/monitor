package com.marsboy.monitor.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name = "expenses", catalog = "monitor")
public class Expenses implements java.io.Serializable {

	private int expensesid;
	private Categories categories;
	private User user;
	private String description;
	private Date actionmadedate;
	private boolean status;

	public Expenses() {
	}

	public Expenses(int expensesid, User user, Date actionmadedate, boolean status) {
		this.expensesid = expensesid;
		this.user = user;
		this.actionmadedate = actionmadedate;
		this.status = status;
	}

	public Expenses(int expensesid, Categories categories, User user, String description, Date actionmadedate,
			boolean status) {
		this.expensesid = expensesid;
		this.categories = categories;
		this.user = user;
		this.description = description;
		this.actionmadedate = actionmadedate;
		this.status = status;
	}

	@Id

	@Column(name = "expensesid", unique = true, nullable = false)
	public int getExpensesid() {
		return this.expensesid;
	}

	public void setExpensesid(int expensesid) {
		this.expensesid = expensesid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categoryid")
	public Categories getCategories() {
		return this.categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "description", length = 45)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "actionmadedate", nullable = false, length = 10)
	public Date getActionmadedate() {
		return this.actionmadedate;
	}

	public void setActionmadedate(Date actionmadedate) {
		this.actionmadedate = actionmadedate;
	}

	@Column(name = "status", nullable = false)
	public boolean isStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
