package com.learning.payment.model;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorMessage {
	private HttpStatus status;
	private String message;

	public ErrorMessage(HttpStatus status, String message) {
		this.status = status;
		this.message = message;
	}
}
