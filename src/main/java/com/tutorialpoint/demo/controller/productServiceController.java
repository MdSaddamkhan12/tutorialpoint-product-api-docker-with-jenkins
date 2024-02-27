package com.tutorialpoint.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tutorialpoint.demo.exception.ProductNotFoundException;
import com.tutorialpoint.demo.model.Product;
import com.tutorialpoint.demo.service.ProductService;

@RestController
public class productServiceController {

	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/products")
	public ResponseEntity<Object> getProduct(){
		
		return new ResponseEntity<>(productService.getProducts(),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public ResponseEntity<Object> createProduct(@RequestBody Product product){
		
		productService.createProduct(product);
		
		return new ResponseEntity<>("product is created successfully",HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateProduct(@PathVariable("id") String id ,@RequestBody Product product){
		
		
		productService.updateProduct(id, product);
		
		return new ResponseEntity<>("product is updated successfully",HttpStatus.OK);
	}
	@RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable("id") String id){
		
		productService.deleteProduct(id);
		
		return new ResponseEntity<>("product is deleted successfully",HttpStatus.OK);
	}
}
