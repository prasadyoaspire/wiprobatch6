package com.abc.mobileservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> hanldeResourceNotFoundException(Exception ex) {
		
		ResponseEntity<String> responseEntity = new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
		return responseEntity;
	}
}
