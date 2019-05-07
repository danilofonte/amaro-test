package com.example.mystore.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.mystore.dto.ProductRestDto;
import com.example.mystore.model.Product;
import com.example.mystore.repository.ProductRepository;
import com.example.mystore.service.ProductService;

@Service
public class DefaultProductService implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	@Cacheable("productById")
	public Optional<Product> findById(long id) {
		return Optional.ofNullable(this.productRepository.findOne(id));

	}

	@Override
	public Page<Product> list(PageRequest pageRequest) {
		return this.productRepository.findAll(pageRequest);
	}

	@Override
	public List<Product> list() {
		return this.productRepository.findAll();
	}

	@Override
	public List<ProductRestDto> getThreeFirstProductsBySimilarity(List<ProductRestDto> productRestDtos) {
		productRestDtos.sort(Comparator.comparing(ProductRestDto::getSimilarity));
		
		List<ProductRestDto> getFirstThree = new ArrayList<>();
		for (int i = 0; i<=2; i++) {
			getFirstThree.add(productRestDtos.get(i));
		}
		
		return getFirstThree;
	}
	
	@Override
	public Product persist(Product product) {
		return this.productRepository.save(product);
	}

}
