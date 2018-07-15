package com.example.mystore.dto;

import java.util.Date;

public class ProductStorefrontDto extends AbstractDto {
	
	private String venue;
	private Long baseProduct;
	private Date date;
	private Long id;
	
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public Long getBaseProduct() {
		return baseProduct;
	}
	public void setBaseProduct(Long baseProduct) {
		this.baseProduct = baseProduct;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	

	
}
