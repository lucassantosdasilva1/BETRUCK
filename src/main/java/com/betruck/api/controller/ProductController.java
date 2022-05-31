package com.betruck.api.controller;

import java.util.List;
import java.util.Optional;

import com.betruck.api.model.ProductModel;
import com.betruck.api.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	//List all of products
	@GetMapping("/products")
	public List<ProductModel> listProducts() {
		return productRepository.findAll();
	}

	//It is Api Welcome
	@GetMapping("")
	public String apiWorking() {
		return "RN Challenge 20220523 Running. Hello!";
	}

	//List product by ID
	@GetMapping("products/{id}")
	public ResponseEntity<ProductModel> productConsult(@PathVariable("id") Long id) {
		return productRepository.findById(id)
				.map(record -> ResponseEntity.ok().body((record)))
				.orElse(ResponseEntity.notFound().build());
	}

	//Edit product by ID
	@PutMapping("/products/{id}")
	public ProductModel updateById(@RequestBody ProductModel product, @PathVariable("id") Long id) {
		Optional<ProductModel> productModelOptional = productRepository.findById(id);

		ProductModel productToSave = productModelOptional.get();

		productToSave.setPrice(product.getPrice());
		productToSave.setTitle(product.getTitle());
		productToSave.setType(product.getType());

		productRepository.save(productToSave);
		return productToSave;
	}

	//Delete product by ID
	@DeleteMapping("/products/{id}")
	public ResponseEntity<Long> deleteById(@PathVariable("id") Long id) {
		return productRepository.findById(id)
				.map(record -> {
					productRepository.deleteById(id);
					return new ResponseEntity<>(id, HttpStatus.OK);
				}).orElse(ResponseEntity.notFound().build());
	}

	//Save new Product
	@PostMapping("/products/save")
	public ProductModel save(@RequestBody ProductModel product) {

		return productRepository.save(product);
	}

}
