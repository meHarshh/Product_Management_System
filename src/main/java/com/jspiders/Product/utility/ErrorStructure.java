package com.jspiders.Product.utility;

import org.springframework.stereotype.Component;

@Component
public class ErrorStructure{

	private int statusCode;
	private String message;
	private Object rootCause;
	public int getStatusCode() {
		return statusCode;
	}
	public ErrorStructure setStatusCode(int statusCode) {
		this.statusCode = statusCode;
		return this;
	}
	public String getMessage() {
		return message;
	}
	public ErrorStructure setMessage(String message) {
		this.message = message;
		return this;
	}
	public Object getRootCause() {
		return rootCause;
	}
	public ErrorStructure setRootCause(Object rootCause) {
		this.rootCause = rootCause;
		return this;
	}
	
	
}
