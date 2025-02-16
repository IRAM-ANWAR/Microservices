package com.learning.payment.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.learning.payment.model.ErrorMessage;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessage employeeNotFoundHandler(EmployeeNotFoundException exception) {
		log.error("Exception", exception);
		return new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
	}

	@ExceptionHandler(Exception.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorMessage genericExceptionHandler(Exception exception) {
		log.error("Exception", exception);
		return new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
	}
}