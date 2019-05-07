package com.example.mystore.converter;

import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.mystore.dto.ProductRestDto;
import com.example.mystore.dto.ProductStorefrontDto;
import com.example.mystore.model.Product;
import com.example.mystore.stereotypes.ConverterComponent;
import com.example.mystore.strategy.EuclideanDistanceCalculation;

@ConverterComponent
public class ProductConverter {

	@Autowired
	private TagConverter tagConverter;
	
	@Autowired
	private EuclideanDistanceCalculation euclideanDistanceCalculation;

	/**
	 * Converts product to dto
	 * 
	 * @param product
	 * @return
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public ProductRestDto convertProductToProductRestDto(final Product product)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		ProductRestDto productRestDto = new ProductRestDto();
		productRestDto.setId(product.getId());
		productRestDto.setName(product.getName());
		if (product.getTag() != null) {
			productRestDto.setTags(tagConverter.convertTagToTagList(product.getTag()));
		}

		return productRestDto;
	}

	/**
	 * Converts product dto to product
	 * 
	 * @param product
	 * @return
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public ProductRestDto convertProductRestDtoToProduct(final ProductRestDto productRestDto)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Product product = new Product();
		product.setName(productRestDto.getName());

		product.setTag(tagConverter.convertTagListToTag(productRestDto.getTags(), product));

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
		productStorefrontDto.setId(product.getId());
		productStorefrontDto.setName(product.getName());

		return productStorefrontDto;
	}
	
	/**
	 * Convert product to dto
	 * 
	 * @param product
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	public ProductRestDto convertProductToProductRestDtoWithSimilarity(final Product product, Product product2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if (product.getId() != product2.getId()) {
			ProductRestDto productRestDto = new ProductRestDto();
			productRestDto.setId(product2.getId());
			productRestDto.setName(product2.getName());
			if (product2.getTag() != null) {
				productRestDto.setTags(tagConverter.convertTagToTagList(product2.getTag()));
			}
			
			productRestDto.setSimilarity(euclideanDistanceCalculation.calculateDistance(tagConverter.convertTagToTagListInt(product.getTag()), tagConverter.convertTagToTagListInt(product2.getTag())));
			return productRestDto;

		}
		
		return null;

	}

}
