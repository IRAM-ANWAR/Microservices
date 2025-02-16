package com.learning.product.error;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductServiceCustomException extends RuntimeException {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String errorCode;

	public ProductServiceCustomException(String message, String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}
}