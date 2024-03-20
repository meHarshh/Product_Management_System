package com.jspiders.Product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jspiders.Product.model.Users;


@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

}
