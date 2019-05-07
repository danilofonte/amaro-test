package com.example.mystore.controller.rest;

import java.lang.reflect.InvocationTargetException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

		try {
			response.setData(this.productConverter.convertProductToProductRestDto(product.get()));
		} catch (IllegalAccessException e) {
			return ResponseEntity.badRequest().body(response);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(response);
		} catch (InvocationTargetException e) {
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/calculate/{id}/eucd")
	public ResponseEntity<Response<List<ProductRestDto>>> calculateEuclideanDistance(@PathVariable("id") Long id) {
		Response<List<ProductRestDto>> response = new Response<List<ProductRestDto>>();
		Optional<Product> product = productService.findById(id);

		if (!product.isPresent()) {
			response.getErrors().add("Product not found by id " + id);
			return ResponseEntity.badRequest().body(response);
		}

		List<Product> products = productService.list();

		List<ProductRestDto> productRestDtos = new ArrayList<ProductRestDto>();

		products.stream().filter(p -> p.getTag() != null && p.getId()!=product.get().getId()).forEach(p -> {
			try {
				productRestDtos.add(productConverter.convertProductToProductRestDtoWithSimilarity(product.get(), p));
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
		});

		response.setData(productService.getThreeFirstProductsBySimilarity(productRestDtos));
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
		Page<ProductRestDto> productsDto = products.map(p -> {
			try {
				return this.productConverter.convertProductToProductRestDto(p);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			return null;
		});

		response.setData(productsDto);
		return ResponseEntity.ok(response);
	}
	
	@PostMapping
	public ResponseEntity<Response<ProductRestDto>> register(@Valid @RequestBody ProductRestDto productRestDto,	BindingResult result) throws NoSuchAlgorithmException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Response<ProductRestDto> response = new Response<ProductRestDto>();

		Product product = this.productConverter.convertProductRestDtoToProduct(productRestDto);

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		Optional<Product> productOptional = this.productService.findById(productRestDto.getId());
		this.productService.persist(product);

		response.setData(this.productConverter.convertProductToProductRestDto(product));
		return ResponseEntity.ok(response);
	}


}
