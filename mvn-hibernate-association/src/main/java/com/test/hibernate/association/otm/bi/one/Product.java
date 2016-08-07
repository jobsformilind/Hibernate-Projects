package com.test.hibernate.association.otm.bi.one;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "OTMBiOne_PRODUCT")
@Table(name = "OTMBiOne_PRODUCT")
public class Product {
	@Id
	@Column(name = "PRODUCT_ID")
	@GeneratedValue
	private long id;

	@ManyToOne
	@JoinColumn(name = "CATEGORY_ID")
	private Category category;

	private String name;
	private String description;
	private float price;

	public Product() {
	}

	public Product(String name, String description, float price, Category category) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
	}

	public long getId() {
		return id;
	}

	public Category getCategory() {
		return category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}