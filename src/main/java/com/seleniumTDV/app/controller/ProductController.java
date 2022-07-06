package com.seleniumTDV.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.seleniumTDV.app.model.DTOProductMoreSelling;
import com.seleniumTDV.app.model.Product;
import com.seleniumTDV.app.service.ProductServiceImpl;



@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductServiceImpl productService;
	
	// create a new product
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Product p) {
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(p));
	}
	
	// List of products
	
	@GetMapping
	public List<Product> findAll(){
		return productService.findAll();
	}
	
	// read an product
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		Optional<Product> oProduct = productService.findById(id);
			
		if(!oProduct.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oProduct);
	}
	
	// update an product
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Product p, @PathVariable Long id) {
		Optional<Product> oProduct = productService.findById(id);
		
		if(!oProduct.isPresent()) {
			return ResponseEntity.notFound().build();
		}
			
		oProduct.get().setName(p.getName());
		oProduct.get().setPrice(p.getPrice());
		oProduct.get().setQuantity(p.getQuantity());
			
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(oProduct.get()));
	}
	
	// delete an product
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Optional<Product> oProduct = productService.findById(id);
			
		if(!oProduct.isPresent()) {
			return ResponseEntity.notFound().build();
		}
			
		productService.deleteById(id);
		return ResponseEntity.ok().build();
	}
	/*
	@GetMapping(value = "/report")
	public DTOProductMoreSelling getReportProductBestSelling() {
		return productService.getMoreSelling();
	}*/
}
