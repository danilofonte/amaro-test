package com.example.mystore.dto;

import java.util.List;

public class ProductRestDto extends AbstractDto {

	private long id;
	private String name;
	private List<String> tags;
	private Double similarity;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public Double getSimilarity() {
		return similarity;
	}

	public void setSimilarity(Double similarity) {
		this.similarity = similarity;
	}

	
	
	
	
	

}
