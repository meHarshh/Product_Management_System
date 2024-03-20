package com.jspiders.Product.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jspiders.Product.dto.ProductDTO;
import com.jspiders.Product.exception.ProductNotFoundByIdException;
import com.jspiders.Product.model.Product;
import com.jspiders.Product.repository.ProductRepository;
import com.jspiders.Product.service.ProductService;
import com.jspiders.Product.utility.ResponseStructure;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;
	private ResponseStructure<Product> responseStructure;
	private ResponseStructure<List<Product>> responseStructure2;

	public ProductServiceImpl(ProductRepository productRepository, ResponseStructure<Product> responseStructure,
			ResponseStructure<List<Product>> responseStructure2) {
		super();
		this.productRepository = productRepository;
		this.responseStructure = responseStructure;
		this.responseStructure2 = responseStructure2;
	}

	@Override
	public ResponseEntity<ResponseStructure<Product>> saveProduct(ProductDTO product) {
		return ResponseEntity.ok(responseStructure.setStatusCode(HttpStatus.OK.value())
				.setMessage("Data added in the db")
				.setData(productRepository.save(mapToProduct(product))));
	}

	private Product mapToProduct(ProductDTO productDTO){
		return Product.builder().productName(productDTO.getProductName())
				.productPrice(productDTO.getProductPrice())
				.productType(productDTO.getProductType()).build();
	}

	@Override
	public ResponseEntity<ResponseStructure<Product>> updateProduct(int productId, ProductDTO productDTO) {
		Product product = mapToProduct(productDTO);
		return productRepository.findById(productId).map(exProduct -> {
			product.setProductID(exProduct.getProductID());
			exProduct = productRepository.save(product);
			return ResponseEntity.ok(responseStructure.setStatusCode(HttpStatus.OK.value())
					.setMessage("Product Updated Sucessfully").setData(exProduct));
		}).orElseThrow(() -> new ProductNotFoundByIdException("INvalid id"));
	}

	@Override
	public ResponseEntity<ResponseStructure<Product>> deleteProduct(int productId) {
		Optional<Product> optional = productRepository.findById(productId);
		return optional.map(product -> {
			productRepository.delete(product);
			return ResponseEntity.ok(responseStructure.setStatusCode(HttpStatus.OK.value())
					.setMessage("Product Deleted Sucessfully").setData(product));
		}).orElse(null);

	}

	@Override
	public ResponseEntity<ResponseStructure<Product>> findProductById(int productId) {
		return productRepository.findById(productId)
				.map(product -> ResponseEntity.ok(responseStructure.setStatusCode(HttpStatus.OK.value())
						.setMessage("Data Found").setData(product)))
				.orElseThrow(() -> new ProductNotFoundByIdException("Data not found"));
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Product>>> findAllProducts() {
		return ResponseEntity.ok(responseStructure2.setStatusCode(HttpStatus.OK.value()).setMessage("Data Fetched")
				.setData(productRepository.findAll()));

	}
}