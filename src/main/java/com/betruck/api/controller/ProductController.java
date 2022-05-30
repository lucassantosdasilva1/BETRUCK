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

	//funcionando
	@GetMapping("/products")
	public List<ProductModel> listProducts() {
		return productRepository.findAll();
	}

	//funcionando
	@GetMapping("")
	public String apiWorking() {
		return "RN Challenge 20220523 Running";
	}

	//funcionando
	@GetMapping("products/{id}")
	public ResponseEntity<ProductModel> productConsult(@PathVariable("id") Long id) {
		return productRepository.findById(id)
				.map(record -> ResponseEntity.ok().body((record)))
				.orElse(ResponseEntity.notFound().build());
	}

	//FUNCIONANDO
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

	@DeleteMapping("/products/{id}")
	public ResponseEntity<Long> deleteById(@PathVariable("id") Long id) {
		return productRepository.findById(id)
				.map(record -> {
					productRepository.deleteById(id);
					return new ResponseEntity<>(id, HttpStatus.OK);
				}).orElse(ResponseEntity.notFound().build());
	}


	@PostMapping("/products/save")
	public ProductModel save(@RequestBody ProductModel product) {

		return productRepository.save(product);
	}

}
