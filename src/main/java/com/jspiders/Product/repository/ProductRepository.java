package com.jspiders.Product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jspiders.Product.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
