package com.jspiders.Product.serviceimpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jspiders.Product.model.Users;
import com.jspiders.Product.repository.UserRepository;
import com.jspiders.Product.service.UserService;
import com.jspiders.Product.utility.ResponseStructure;

@Service
public class UserServiceImpl implements UserService {
	ResponseStructure<Users> responseStructure;
	private UserRepository  userRepository;
	
	public UserServiceImpl(ResponseStructure<Users> responseStructure, UserRepository userRepository) {
		super();
		this.responseStructure = responseStructure;
		this.userRepository = userRepository;
	}

	@Override
	public ResponseEntity<ResponseStructure<Users>> addUser(Users user) {
		return ResponseEntity.ok(responseStructure.setStatusCode(HttpStatus.OK.value()).setMessage("User added ")
				.setData(userRepository.save(user)));   
		
	}




}
