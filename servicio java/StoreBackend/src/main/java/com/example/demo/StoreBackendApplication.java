package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Product;
import com.example.demo.repositories.ProductRepository;

@SpringBootApplication
public class StoreBackendApplication implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(StoreBackendApplication.class, args);
		
		
	}
	
	
	public void run(String... args)throws Exception{
		productRepository.save(new Product("ABC1", "Serrucho",10000));
		productRepository.save(new Product("XZAA", "Martillo",5000));
		productRepository.save(new Product("JKML", "Alargador",3000));
		productRepository.save(new Product("AD3F", "Sierra",25000));
		productRepository.save(new Product("M1RD", "Destornillador",2000));
		productRepository.save(new Product("PEPO", "Hacha",8000));
		
	}
	
}
