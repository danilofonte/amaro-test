package com.example.mystore.repository;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ProductRepositoryTest {
	
	@Autowired
	private ProductRepository productRepository;

	@Test
	public void testCountProducts() {
		Long qty = productRepository.count();
		
		assertTrue(qty>5L);
	}
	
}
