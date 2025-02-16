package com.learning.product.service;

import com.learning.product.model.ProductRequest;
import com.learning.product.model.ProductResponse;

public interface ProductService {

	long addProduct(ProductRequest productRequest);

	ProductResponse getProductById(long productId);

	void reduceQuantity(long productId, long quantity);
}