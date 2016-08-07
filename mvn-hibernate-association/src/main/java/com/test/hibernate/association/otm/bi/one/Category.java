package com.test.hibernate.association.otm.bi.one;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "OTMBiOne_CATEGORY")
@Table(name = "OTMBiOne_CATEGORY")
public class Category {

	@Id
	@Column(name = "CATEGORY_ID")
	@GeneratedValue
	private long id;

	private String name;

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private Set<Product> products;

	public Category() {
	}

	public Category(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products2) {
		this.products = products2;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setId(long id) {
		this.id = id;
	}

}