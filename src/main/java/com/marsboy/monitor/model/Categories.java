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
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "categories", catalog = "monitor", uniqueConstraints = @UniqueConstraint(columnNames = "categoryname"))
public class Categories implements java.io.Serializable {

	private Integer categoryid;
	private String categoryname;
	private Set<Expenses> expenseses = new HashSet<Expenses>(0);

	public Categories() {
	}

	public Categories(String categoryname) {
		this.categoryname = categoryname;
	}

	public Categories(String categoryname, Set<Expenses> expenseses) {
		this.categoryname = categoryname;
		this.expenseses = expenseses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "categoryid", unique = true, nullable = false)
	public Integer getCategoryid() {
		return this.categoryid;
	}

	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}

	@Column(name = "categoryname", unique = true, nullable = false)
	public String getCategoryname() {
		return this.categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categories")
	public Set<Expenses> getExpenseses() {
		return this.expenseses;
	}

	public void setExpenseses(Set<Expenses> expenseses) {
		this.expenseses = expenseses;
	}

}
