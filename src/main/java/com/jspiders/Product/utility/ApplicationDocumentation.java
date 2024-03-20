package com.jspiders.Product.utility;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@OpenAPIDefinition
@Configuration
public class ApplicationDocumentation {

	Contact contact() {
		return new Contact().name("Harsh").url(".com").email("meharshhk@gmail.com");
	}

	@Bean
	Info info() {
		return new Info().title("Product Management System").description("Restful API with basic CRUD operations")
				.version("v1").contact(contact());
	}

	@Bean
	OpenAPI openAPI() {
		return new OpenAPI().info(info());
	}

}
