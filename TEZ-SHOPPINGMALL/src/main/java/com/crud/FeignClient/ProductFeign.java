package com.crud.FeignClient;

import java.util.List;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.crud.ServiceClaasesoFMicroserices.Products;
import com.crud.ServiceClaasesoFMicroserices.Products_Plus_Rating;

@FeignClient(url = "localhost:8082/products",value="Product-Feign")
public interface ProductFeign {

	@PostMapping("/save")
	public Products saveEntity(@RequestBody Products pro);
	
	@GetMapping("/get/{name}")
	public Products getProduct(@PathVariable String name);
	
	@DeleteMapping("/delete/{name}")
	public String deleteProduct(@PathVariable String name);
	
	@DeleteMapping("/deleteid/{id}")
	public String deleteProductById(@PathVariable long id);
	
	@GetMapping("/getAllProducts")
	public List<Products> getAllProducts();
	
	
	@GetMapping("/getProductRating/{name}")
	public String getOneRating(@PathVariable String name);
	
	
	
	@GetMapping("/getAllproductsPlusRating")
	public List<Products_Plus_Rating> getAllProductsPlusRating();
}
