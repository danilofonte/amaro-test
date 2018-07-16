package com.example.mystore.controller.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mystore.converter.ProductConverter;
import com.example.mystore.dto.ProductRestDto;
import com.example.mystore.model.Product;
import com.example.mystore.response.Response;
import com.example.mystore.service.ProductService;

@RestController
@RequestMapping("/api/product")
@CrossOrigin(origins = "*")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductConverter productConverter;

	@Value("${pagination.qty_per_page}")
	private int qtyPerPage;

	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/by-id/{id}")
	public ResponseEntity<Response<ProductRestDto>> findProductById(@PathVariable("id") Long id) {
		Response<ProductRestDto> response = new Response<ProductRestDto>();
		Optional<Product> product = productService.findById(id);

		if (!product.isPresent()) {
			response.getErrors().add("Product not found by id " + id);
			return ResponseEntity.badRequest().body(response);
		}

		response.setData(this.productConverter.convertProductToProductRestDto(product.get()));
		return ResponseEntity.ok(response);
	}

	/**
	 * 
	 * @param pag
	 * @param ord
	 * @param dir
	 * @return
	 */
	@GetMapping(value = "/list")
	public ResponseEntity<Response<Page<ProductRestDto>>> list(@RequestParam(value = "pag", defaultValue = "0") int pag,
			@RequestParam(value = "ord", defaultValue = "id") String ord,
			@RequestParam(value = "dir", defaultValue = "DESC") String dir) {
		Response<Page<ProductRestDto>> response = new Response<Page<ProductRestDto>>();

		PageRequest pageRequest = new PageRequest(pag, this.qtyPerPage, Direction.valueOf(dir), ord);
		Page<Product> products = this.productService.list(pageRequest);
		Page<ProductRestDto> productsDto = products.map(p -> this.productConverter.convertProductToProductRestDto(p));

		response.setData(productsDto);
		return ResponseEntity.ok(response);
	}

}
