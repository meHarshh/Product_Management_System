package com.jspiders.Product.exception;

@SuppressWarnings("serial")
public class ProductNotFoundByIdException extends RuntimeException {
	private String message;

	public ProductNotFoundByIdException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	

}
