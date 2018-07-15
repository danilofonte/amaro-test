package com.example.mystore.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.mystore.model.Product;
import com.example.mystore.repository.ProductRepository;
import com.example.mystore.service.ProductService;

@Service
public class DefaultProductService implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	@Cacheable("productById")
	public Optional<Product> findById(Long id) {
		return Optional.ofNullable(this.productRepository.findOne(id));

	}

	@Override
	public Page<Product> list(PageRequest pageRequest) {
		return this.productRepository.findAll(pageRequest);
	}

}
