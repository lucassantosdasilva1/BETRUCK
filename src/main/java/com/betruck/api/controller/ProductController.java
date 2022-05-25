package com.betruck.api.controller;

import java.util.List;

import com.betruck.api.model.Product;
import com.betruck.api.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping
	public List<Product> listProducts() {
		return clienteRepository.findAll();
	}

}
