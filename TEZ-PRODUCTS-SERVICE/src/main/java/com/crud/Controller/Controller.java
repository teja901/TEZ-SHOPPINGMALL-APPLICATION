package com.crud.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.Entity.Product_Rating;
import com.crud.Entity.Products;
import com.crud.Entity.ProductsWithoutId;
import com.crud.Entity.ProductsWithoutId;
import com.crud.Entity.Products_Duplicate;
import com.crud.Entity.Products_Plus_Rating;
import com.crud.ExceptionClass.ProductNotFound;
import com.crud.ExceptionClass.RatingException;
import com.crud.FeignClient.RatingFeignClient;
import com.crud.Repository.ProductRepo;
import com.crud.Service.ProductService;

@RestController
@RequestMapping("/products")
public class Controller {

	@Autowired
	private ProductService service;
	
	@Autowired
	private ProductRepo repo;
	
	@Autowired
	private RatingFeignClient rate;
	
	@GetMapping("/GetChance")
	public String add() {
		return "One Chance";
	}
	
	@PostMapping("/save")
	public Products save(@RequestBody Products products) {
		return service.saveProduct(products);
	}
	
	@GetMapping("/get/{name}")
	public ProductsWithoutId getOneProduct(@PathVariable String name) throws ProductNotFound {
		System.out.println("***************************");
		return service.getOne(name);
	}
	
	
	@GetMapping("/getAllProducts")
	public List<ProductsWithoutId> getAll(){
		return  service.getAll();
		
	}
	
	@DeleteMapping("/delete/{name}")
	public String deleteProduct(@PathVariable String name) {
		
		return service.deleteProduct(name);
	}
	
	@PutMapping("/update/{name}")
	public Products updateProduct(@PathVariable String name,@RequestBody Products product) throws ProductNotFound {
		return service.updateProduct(name,product);
	}
	
	@GetMapping("/verify/{name}")
	public String productVerification(@PathVariable String name) {
		return service.productVerification(name);
	}
	
	@DeleteMapping("/deleteid/{id}")
	public String deletebyId(@PathVariable long id) {
		return service.deletebyId(id);
	}
	

	
	@GetMapping("/getProductRating/{name}")
	public String getOneRating(@PathVariable String name) throws ProductNotFound, RatingException {
		Products_Duplicate pro= service.getRatingOne(name);
		  if(pro.getProductBrandName()==null) {
			  return ""+new ProductNotFound("No Product with name of : "+name).getMessage();
		  }
		  else if(pro.getProductName()!=null && pro.getRating()==null) {
			  return pro.toStrings() +""+new RatingException(" :-  Rating Not Given for this Product : "+name).getMessage();
		  }
		  else {
			  return ""+ pro.toString();
		  }
	}
	
	@GetMapping("/getAllproductsPlusRating")
	public List<Products_Plus_Rating> getAllProductsPlusRating(){
	List<Products> pro=repo.findAll();
	List<Products_Plus_Rating> productRatings1=new ArrayList<>();
	for(Products p:pro) {
		productRatings1.add(new Products_Plus_Rating(p,rate.getRatingOne(p.getProductName())));
	}
	    return productRatings1;
	}

	
	@PostMapping("/UpdateProductAfterOrder/{name}/{quantity}")
	public void updatingAfterOrder(@PathVariable String name,@PathVariable long quantity){
		System.out.println("Updated Succesfully>.................");
		 service.updateProductAfterOrder(name, quantity);
		
		
	}
}
