package com.learning.order.error;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CustomException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String errorCode;
	private int status;

	public CustomException(String message, String errorCode, int status) {
		super(message);
		this.errorCode = errorCode;
		this.status = status;
	}
}