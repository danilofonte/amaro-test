package com.example.mystore.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.example.mystore.model.Product;

public interface ProductService {

	/**
	 * Find product by id
	 * 
	 * @param id
	 * @return
	 */
	Optional<Product> findById(final Long id);

	/**
	 * List products
	 * 
	 * @param pageRequest
	 * @return
	 */
	Page<Product> list(PageRequest pageRequest);

}
