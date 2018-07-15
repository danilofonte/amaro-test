package com.example.mystore.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.mystore.converter.ProductConverter;
import com.example.mystore.dto.ProductStorefrontDto;
import com.example.mystore.model.Product;
import com.example.mystore.service.ProductService;

import command.SearchCommand;

@Controller
public class ProductPageControllerController {

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductConverter productConverter;

	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public String getProduct() {
		return "redirect:/index";
	}

	@RequestMapping("/product/{id}")
	public String getProductById(@PathVariable Long id, Model model) {

		Optional<Product> product = productService.findById(id);

		model.addAttribute("product", productConverter.convertProductToProductStorefrontDto(product.get()));
        model.addAttribute("searchCommand", new SearchCommand());

		return "product";
	}

	@RequestMapping("/product/list")
	public String list(Model model) {

		List<Product> products = productService.list();

		List<ProductStorefrontDto> productsDto = products.stream()
				.map(p -> productConverter.convertProductToProductStorefrontDto(p)).collect(Collectors.toList());

		model.addAttribute("products", productsDto);
        model.addAttribute("searchCommand", new SearchCommand());

		return "list";
	}
	
	@RequestMapping(value="/product/by-id/", method = RequestMethod.POST)
	public String searchProductById(@Valid SearchCommand filter, Model model, BindingResult bindingResult) {

		Optional<Product> product = productService.findById(Long.parseLong(filter.getFilter()));

		model.addAttribute("product", productConverter.convertProductToProductStorefrontDto(product.get()));
        model.addAttribute("searchCommand", new SearchCommand());

		return "product";
	}

}
