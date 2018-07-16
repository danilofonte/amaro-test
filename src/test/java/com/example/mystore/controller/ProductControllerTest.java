package com.example.mystore.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ProductControllerTest {

	@Autowired
	private MockMvc mvc;

	private static final String FIND_PRODUC_BY_ID = "/api/product/by-id/";
	private static final Long ID = 8796093054977L;
	private static final String PRODUCT_NAME = "hybris Munich, Germany";

	@Test
	@WithMockUser
	public void testFindProductById() throws Exception {

		mvc.perform(MockMvcRequestBuilders.get(FIND_PRODUC_BY_ID + 1).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.errors").value("Product not found by id 1"));
	}

	@Test
	@WithMockUser
	public void testFindProductWithId() throws Exception {

		mvc.perform(MockMvcRequestBuilders.get(FIND_PRODUC_BY_ID + ID).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$.data.id").value(ID))
				.andExpect(jsonPath("$.data.name", equalTo(PRODUCT_NAME))).andExpect(jsonPath("$.errors").isEmpty());
	}

}
