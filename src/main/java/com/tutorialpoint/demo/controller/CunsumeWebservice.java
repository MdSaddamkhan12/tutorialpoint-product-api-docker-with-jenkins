package com.tutorialpoint.demo.controller;



import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tutorialpoint.demo.model.Product;

@RestController
public class CunsumeWebservice {

	@Autowired
	RestTemplate restTemplate;
	
	// Get all products
	@RequestMapping(value = "/template/products")
	public String getProductList() {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		return restTemplate.exchange("http://localhost:9090/products", 
				HttpMethod.GET, entity, String.class).getBody();
	}
	
	// Create new product
	@RequestMapping(value = "/template/products", method = RequestMethod.POST)
	public String createProduct(@RequestBody Product product) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity<Product> entity = new HttpEntity<Product>(product,headers);
		return restTemplate.exchange("http://localhost:9090/products", 
				HttpMethod.POST, entity, String.class).getBody();
	}
	
	//Update product
	@RequestMapping(value = "/template/products/{id}", method = RequestMethod.PUT)
	public String updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity<Product> entity = new HttpEntity<Product>(product,headers);
		return restTemplate.exchange("http://localhost:9090/products/"+id, 
				HttpMethod.PUT, entity, String.class).getBody();
	}
	//delete product
	@RequestMapping(value = "/template/products/{id}", method = RequestMethod.DELETE)
	public String deleteProduct(@PathVariable("id") String id) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity<Product> entity = new HttpEntity<Product>(headers);
		return restTemplate.exchange("http://localhost:9090/products/"+id, 
				HttpMethod.DELETE, entity, String.class).getBody();
	}
	
}
