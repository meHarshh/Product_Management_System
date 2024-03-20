package com.jspiders.Product.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.Product.model.Users;
import com.jspiders.Product.service.UserService;
import com.jspiders.Product.utility.ResponseStructure;

import jakarta.validation.Valid;

@RestController
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping(value = "/users")  
	public ResponseEntity<ResponseStructure<Users>> addUser(@RequestBody @Valid Users user) {
		return userService.addUser(user);
	}
}
