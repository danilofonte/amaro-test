package com.example.mystore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.mystore.model.Product;

@Transactional(readOnly = true)
public interface ProductRepository extends JpaRepository<Product, Long> {

}
