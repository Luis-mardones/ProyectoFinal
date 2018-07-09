package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.repositories.ProductRepository;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/products")
	public List<Product> getProducts(){
		return productRepository.findAll();
	}

	@GetMapping("/product/{id}")
	public Optional<Product> getProduct(@PathVariable Long id){
		return productRepository.findById(id);
	} 
	
	
	@DeleteMapping("/product/{id}")
	public boolean deleteProduct(@PathVariable Long id){
	boolean status;	
		
	try {	
		productRepository.deleteById(id);
		status = true;
	}
	catch(Exception e) {
		status = false;
	}
	return status;
	
	}
	
	@PostMapping("/product")
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}
	
	@PutMapping("/product")
	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}
	
	
}
