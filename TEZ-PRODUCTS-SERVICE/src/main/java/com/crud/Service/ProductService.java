package com.crud.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.crud.Entity.Product_Rating;
import com.crud.Entity.Products;
import com.crud.Entity.ProductsWithoutId;
import com.crud.Entity.Products_Duplicate;
import com.crud.ExceptionClass.ProductNotFound;
import com.crud.ExceptionClass.RatingException;
import com.crud.FeignClient.RatingFeignClient;
import com.crud.Repository.ProductRepo;

import feign.FeignException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductRepo repo;
	
	@Autowired
	private RatingFeignClient rate;
	
	public Products saveProduct(Products products) {
		
		Optional<Products> pro=repo.findByProductName(products.getProductName());
		
		if(pro.isPresent()) {

			pro.get().setProductsLeft(pro.get().getProductsLeft()+products.getProductsLeft());
			return repo.save(pro.get());
		}
		else {
		return repo.save(products);
		}
	}
	
	
	public ProductsWithoutId getOne(String name) throws ProductNotFound {
		
		
		Optional<Products> pro= repo.findByProductName(name);
		return new ProductsWithoutId(pro.orElseThrow(()-> new ProductNotFound("Product does not exist : "+name)));
	}
	
	
	public List<ProductsWithoutId> getAll(){
		List<Products> pro=repo.findAll();
		return pro.stream().map(ProductsWithoutId::new).collect(Collectors.toList());
	}
	
	public Products updateProduct(String name,Products products) throws ProductNotFound {
		Optional<Products> pro=repo.findByProductName(name);
		Products pro1=pro.orElseThrow(()-> new ProductNotFound("PRODUCT NOT FOUND WITH NAME :"+name));
		pro1.setProductName(products.getProductName());
		pro1.setProductBrandName(products.getProductBrandName());
		pro1.setProductPrice(products.getProductPrice());
		pro1.setProductsLeft(products.getProductsLeft());
		return repo.save(pro1);
		
	}
	
	@Transactional
	public String deleteProduct(String name) {
		Optional<Products> pro=repo.findByProductName(name);
		if(!pro.isEmpty()) {
		repo.deleteByProductName(name);
		return "Product deleted Succesfully :"+name;
		}
		
		return "No Product is Found to Delete with given name :"+name;
			
	}
	
	@Transactional
	public String productVerification(String name) {
		
		Optional<Products> pro=repo.findByProductName(name);
		if(!pro.isEmpty())
			return "YOU CAN PROCEED PRODUCT IS AVAILABLE";
		else
			return "PRODUCT IS NOT AVAILABLE";
	}
	
	public String deletebyId(long id) {
		Optional<Products> pro=repo.findById(id);
		if(!pro.isEmpty()) {
			repo.deleteById(id);
			return "Id DELETED SUCCESSFULLY";
		}
			else
				return "NO ID Found";
		
	}
	
	
	public Products_Duplicate getRatingOne(String name)   {
		
		     Optional<Products> rates=repo.findByProductName(name);
		      Products_Duplicate ratings=new Products_Duplicate();
		     if(rates.isPresent()) {
		    	ratings=new Products_Duplicate(rates.get());
		    	Optional<Product_Rating> rating= Optional.ofNullable(rate.getRatingOne(name));
		    	if(rating.isPresent()) {
		    	ratings.setRating(rating.get());
		    	}
		    	else {
		    		ratings.setRating(null);
		    	}
		     }
		     return ratings;
	}
	
	public void updateProductAfterOrder(String productName,long quantity) {
		
		Optional<Products> p=repo.findByProductName(productName);
		
		p.get().setProductsLeft(p.get().getProductsLeft()-quantity);
		repo.save(p.get());
		
	}
	
	
}
