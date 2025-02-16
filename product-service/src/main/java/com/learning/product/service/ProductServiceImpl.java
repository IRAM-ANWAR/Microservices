package com.learning.product.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.product.entity.Product;
import com.learning.product.error.ProductServiceCustomException;
import com.learning.product.model.ProductRequest;
import com.learning.product.model.ProductResponse;
import com.learning.product.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Override
	public long addProduct(ProductRequest productRequest) {
		log.info("Adding Product..");

		Product product = Product.builder().productName(productRequest.getName()).quantity(productRequest.getQuantity())
		        .price(productRequest.getPrice()).build();

		this.productRepository.save(product);

		log.info("Product Created");
		return product.getProductId();
	}

	@Override
	public ProductResponse getProductById(long productId) {
		log.info("Get the product for productId: {}", productId);

		Product product = this.productRepository.findById(productId).orElseThrow(
		        () -> new ProductServiceCustomException("Product with given id not found", "PRODUCT_NOT_FOUND"));
		Optional<Product> productOptional = this.productRepository.findById(productId);
		productOptional.map(p -> p.getProductName());
		ProductResponse productResponse = new ProductResponse();

		BeanUtils.copyProperties(product, productResponse);

		return productResponse;
	}

	@Override
	public void reduceQuantity(long productId, long quantity) {
		log.info("Reduce Quantity {} for Id: {}", quantity, productId);

		Product product = this.productRepository.findById(productId).orElseThrow(
		        () -> new ProductServiceCustomException("Product with given Id not found", "PRODUCT_NOT_FOUND"));

		if (product.getQuantity() < quantity)
			throw new ProductServiceCustomException("Product does not have sufficient Quantity",
			        "INSUFFICIENT_QUANTITY");

		product.setQuantity(product.getQuantity() - quantity);
		this.productRepository.save(product);
		log.info("Product Quantity updated Successfully");
	}
}
