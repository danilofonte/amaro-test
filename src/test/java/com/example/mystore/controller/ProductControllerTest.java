package com.example.mystore.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.mystore.model.Product;
import com.example.mystore.service.ProductService;

public class ProductControllerTest {
	

	@Autowired
	private MockMvc mvc;

	@MockBean
	private ProductService productService;

	private static final String FIND_PRODUC_BY_ID = "/api/product/by-id/";
	private static final int ID = 1;
	private static final String PRODUCT_NAME = "sapato";

	@Test
	@WithMockUser
	public void testFindProductById() throws Exception {
		BDDMockito.given(this.productService.findById(Mockito.anyInt())).willReturn(Optional.empty());

		mvc.perform(MockMvcRequestBuilders.get(FIND_PRODUC_BY_ID + ID).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.errors").value("Product not found for id " + ID));
	}

	@Test
	@WithMockUser
	public void testFindProductWithId() throws Exception {
		BDDMockito.given(this.productService.findById(Mockito.anyInt()))
				.willReturn(Optional.of(this.initProduct()));

		mvc.perform(MockMvcRequestBuilders.get(FIND_PRODUC_BY_ID + ID)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.data.id").value(ID))
				.andExpect(jsonPath("$.data.name", equalTo(PRODUCT_NAME)))
				.andExpect(jsonPath("$.errors").isEmpty());
	}

	private Product initProduct() {
		Product product = new Product();
		product.setId(ID);
		product.setP_VENUE(PRODUCT_NAME);
		return product;
	}

}
