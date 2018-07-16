package com.example.mystore.converter;

import com.example.mystore.dto.ProductRestDto;
import com.example.mystore.dto.ProductStorefrontDto;
import com.example.mystore.model.Product;
import com.example.mystore.stereotypes.ConverterComponent;

@ConverterComponent
public class ProductConverter {

	/**
	 * Converts product to dto
	 * 
	 * @param product
	 * @return
	 */
	public ProductRestDto convertProductToProductRestDto(final Product product) {
		ProductRestDto productRestDto = new ProductRestDto();
		productRestDto.setId(product.getId());
		productRestDto.setName(product.getP_VENUE());

		return productRestDto;
	}

	/**
	 * Convert product to dto
	 * 
	 * @param product
	 * @return
	 */
	public ProductStorefrontDto convertProductToProductStorefrontDto(final Product product) {
		ProductStorefrontDto productStorefrontDto = new ProductStorefrontDto();
		productStorefrontDto.setBaseProduct(product.getP_BASEPRODUCT());
		productStorefrontDto.setDate(product.getP_DATE());
		productStorefrontDto.setVenue(product.getP_VENUE());
		productStorefrontDto.setId(product.getId());

		return productStorefrontDto;
	}

}
