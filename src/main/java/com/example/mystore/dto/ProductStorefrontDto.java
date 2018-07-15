package com.example.mystore.dto;

import java.util.Date;

public class ProductStorefrontDto extends AbstractDto {
	
	private String venue;
	private long baseBaseProduct;
	private Date date;
	
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public long getBaseBaseProduct() {
		return baseBaseProduct;
	}
	public void setBaseBaseProduct(long baseBaseProduct) {
		this.baseBaseProduct = baseBaseProduct;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	
}
