package com.betruck.api.controller;

import java.util.List;

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

	@GetMapping("/products")
	public List<ProductModel> listProducts() {
		return productRepository.findAll();
	}

	@GetMapping("/")
	public String apiWorking() {
		return "RN Challenge 20220523 Running";
	}

	@GetMapping("products/{id}")
	public ResponseEntity<ProductModel> productConsult(@PathVariable("id") Long id) {
		return productRepository.findById(id)
				.map(record -> ResponseEntity.ok().body((record)))
				.orElse(ResponseEntity.notFound().build());
	}

	@PutMapping("/products/:productId")
	public ProductModel edit(@RequestBody ProductModel product) {
		return productRepository.save(product);
	}

	@DeleteMapping("/products/{id}")
	public ResponseEntity<Long> delete(@PathVariable("id") Long id){
		return new ResponseEntity<>(id, HttpStatus.OK);
	}

	//-----------------------------------------------------
	@PostMapping("/products/save")
	public ProductModel save(@RequestBody ProductModel product) {
		return productRepository.save(product);
	}

}