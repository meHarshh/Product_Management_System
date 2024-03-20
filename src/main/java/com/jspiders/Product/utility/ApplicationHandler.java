package com.jspiders.Product.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jspiders.Product.exception.ProductNotFoundByIdException;

@RestControllerAdvice
public class ApplicationHandler {

	@ExceptionHandler
	public ResponseEntity<ErrorStructure> productNotFoundById(ProductNotFoundByIdException e){
		ErrorStructure er = new ErrorStructure();
		er.setStatusCode(HttpStatus.NOT_FOUND.value());
		er.setMessage(e.getMessage());
		er.setRootCause("Invalid userId");
		
		return new ResponseEntity<ErrorStructure>(er,HttpStatus.NOT_FOUND);
		
		
	}
}
