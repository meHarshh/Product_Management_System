package com.jspiders.Product;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
//		Product product = null;
//		Optional.of(product).map(o -> {
//			System.out.println("Inside Map");
//			return o;
//		}).orElseThrow(() -> new RuntimeException());
		
		
	}

}
