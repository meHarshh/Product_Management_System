package com.jspiders.Product.service;

import org.springframework.http.ResponseEntity;

import com.jspiders.Product.model.Users;
import com.jspiders.Product.utility.ResponseStructure;

public interface UserService {

	ResponseEntity<ResponseStructure<Users>> addUser(Users user);

}
