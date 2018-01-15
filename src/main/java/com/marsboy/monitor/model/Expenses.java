package com.marsboy.monitor.model;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "expenses", catalog = "monitor")
public class Expenses implements java.io.Serializable {

	private Integer expensesid;
	private Categories categories;
	private User user;
	private int amount;
	private String description;
	@org.springframework.format.annotation.DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date actionmadedate;
	private boolean status;

	public Expenses() {
	}

	public Expenses(User user, int amount, Date actionmadedate, boolean status) {
		this.user = user;
		this.amount = amount;
		this.actionmadedate = actionmadedate;
		this.status = status;
	}

	public Expenses(Categories categories, User user, int amount, String description, Date actionmadedate,
			boolean status) {
		this.categories = categories;
		this.user = user;
		this.amount = amount;
		this.description = description;
		this.actionmadedate = actionmadedate;
		this.status = status;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "expensesid", unique = true, nullable = false)
	public Integer getExpensesid() {
		return this.expensesid;
	}

	public void setExpensesid(Integer expensesid) {
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

	@Column(name = "amount", nullable = false)
	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
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
