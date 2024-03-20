package com.jspiders.Product.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.jspiders.Product.dto.ProductDTO;
import com.jspiders.Product.model.Product;
import com.jspiders.Product.utility.ResponseStructure;

public interface ProductService {

	public ResponseEntity<ResponseStructure<Product>> saveProduct(ProductDTO product);

	public ResponseEntity<ResponseStructure<Product>> updateProduct(int productId, ProductDTO productDTO);

	public ResponseEntity<ResponseStructure<Product>> deleteProduct(int productId);

	public ResponseEntity<ResponseStructure<Product>> findProductById(int productId);

	public ResponseEntity<ResponseStructure<List<Product>>> findAllProducts();

}