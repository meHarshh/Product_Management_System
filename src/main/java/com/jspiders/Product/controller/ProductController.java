package com.jspiders.Product.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.Product.dto.ProductDTO;
import com.jspiders.Product.model.Product;
import com.jspiders.Product.service.ProductService;
import com.jspiders.Product.utility.ErrorStructure;
import com.jspiders.Product.utility.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

//@Controller
@RestController
public class ProductController {

	private ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@Operation(description = "The end point is uded to add the new product to the database", responses = {
			@ApiResponse(responseCode = "200", description = "Product added in the db successfully"),
			@ApiResponse(responseCode = "400", description = "Invalid inputs") })
	@PostMapping(value = "products")
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody ProductDTO product) {
		return productService.saveProduct(product);
	}

	@Operation(description = "This end point is used to update the product based on the ID", responses = {
			@ApiResponse(responseCode = "200", description = "Product found and updated"),
			@ApiResponse(responseCode = "404", description = "Product not found by the given id", content = {
					@Content(schema = @Schema(implementation = ErrorStructure.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid Inputs")

	})
	@PutMapping(value = "products/{productId}")
	public ResponseEntity<ResponseStructure<Product>> updateProduct(@PathVariable int productId,
			@RequestBody ProductDTO productDTO) {
		return productService.updateProduct(productId, productDTO);
	}

	@Operation(description = "This end point is used to delete the product based on the ID", responses = {
			@ApiResponse(responseCode = "200", description = "Product deleted"),
			@ApiResponse(responseCode = "404", description = "Product not found by the given id", content = {
					@Content(schema = @Schema(implementation = ErrorStructure.class)) })

	})
	@DeleteMapping(value = "products/{productId}")
	public ResponseEntity<ResponseStructure<Product>> deleteProduct(@PathVariable int productId) {
		return productService.deleteProduct(productId);
	}

	@Operation(description = "This end point is used to fetch the product based on the ID", responses = {
			@ApiResponse(responseCode = "200", description = "Product found"),
			@ApiResponse(responseCode = "404", description = "Product not found by the given id", content = {
					@Content(schema = @Schema(implementation = ErrorStructure.class)) })

	})
	@GetMapping(value = "products/{productId}")
	public ResponseEntity<ResponseStructure<Product>> findProductById(@PathVariable int productId) {
		return productService.findProductById(productId);
	}

	@Operation(description = "This end point is used to fetch all the products", responses = {
			@ApiResponse(responseCode = "200", description = "Products found"),
			@ApiResponse(responseCode = "404", description = "No products in the db")

	})
	@GetMapping(value = "products")
	public ResponseEntity<ResponseStructure<List<Product>>> findAllProducts() {
		return productService.findAllProducts();
	}
}
