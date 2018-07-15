package com.example.mystore.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3302280386880265560L;

	private Long id;
	private String name;
	private Date date;
	private Product baseProduct;
	private List<Product> products;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "date")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@OneToMany(mappedBy = "baseProduct", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinColumn(name = "baseproduct")
	public Product getBaseProduct() {
		return baseProduct;
	}

	public void setBaseProduct(Product baseProduct) {
		this.baseProduct = baseProduct;
	}

	@PrePersist
	public void prePersist() {
		Date currentDate = new Date();
		date = currentDate;
	}

	@PreUpdate
	public void preUpdate() {
		date = new Date();
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", date=" + date + ", baseProduct=" + baseProduct
				+ ", products=" + products + "]";
	}

}
