package com.example.mystore.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mystore.converter.ProductConverter;
import com.example.mystore.dto.ProductStorefrontDto;
import com.example.mystore.model.Product;
import com.example.mystore.service.ProductService;

import command.SearchCommand;

@Controller
public class IndexController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductConverter productConverter;

	@RequestMapping({ "/", "index" })
	public String getIndex(Model model) {
		
		List<Product> products = productService.list();
		
		List<ProductStorefrontDto> productsDto = products.stream().map(p -> productConverter.convertProductToProductStorefrontDto(p)).collect(Collectors.toList());

		
        model.addAttribute("products", productsDto);
        
        model.addAttribute("searchCommand", new SearchCommand());


		return "index";
	}

}
