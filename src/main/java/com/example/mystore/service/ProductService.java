package com.example.mystore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.example.mystore.dto.ProductRestDto;
import com.example.mystore.model.Product;

public interface ProductService {

	/**
	 * Find product by id
	 * 
	 * @param id
	 * @return
	 */
	Optional<Product> findById(final long id);

	/**
	 * List products
	 * 
	 * @param pageRequest
	 * @return
	 */
	Page<Product> list(PageRequest pageRequest);
	
	/**
	 * 
	 * @return
	 */
	List<Product> list();
	
	List<ProductRestDto> getThreeFirstProductsBySimilarity(List<ProductRestDto> productRestDtos);
	
	Product persist(Product product);

}
