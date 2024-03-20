package com.jspiders.Product.utility;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	private ErrorStructure errorStructure;

	public ApplicationExceptionHandler(ErrorStructure errorStructure) {
		super();
		this.errorStructure = errorStructure;
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
//		List<ObjectError> errors = ex.getAllErrors();
//		List<String> messages = new ArrayList<String>();
		Map<String, String> messages = new HashMap<>();
		ex.getAllErrors().forEach(error -> {
			FieldError fe = (FieldError) error;
//			String message = error.getDefaultMessage();
			messages.put(fe.getField(), error.getDefaultMessage());
		});

		return ResponseEntity.badRequest().body(errorStructure.setMessage("Inavlid inputs")
				.setStatusCode(HttpStatus.BAD_GATEWAY.value()).setRootCause(messages));
	}
}
