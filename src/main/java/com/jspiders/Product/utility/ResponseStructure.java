package com.jspiders.Product.utility;

import org.springframework.stereotype.Component;

@Component
public class ResponseStructure<E> {
	private int statusCode;
	private String message;
	private E data;
	public int getStatusCode() {
		return statusCode;
	}
	public ResponseStructure<E> setStatusCode(int statusCode) {
		this.statusCode = statusCode;
		return this;
	}
	public String getMessage() {
		return message;
	}
	public ResponseStructure<E> setMessage(String message) {
		this.message = message;
		return this;
	}
	public E getData() {
		return data;
	}
	public ResponseStructure<E> setData(E data) {
		this.data = data;
		return this;
	}
		
	

}
