package com.crud.FeignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.crud.Entity.Product_Rating;

@FeignClient(url = "http://localhost:8083/product",name="Rating-Client")
public interface RatingFeignClient {

	
	
	@GetMapping("/getProductRating/{name}")
	public Product_Rating getRatingOne(@PathVariable String name);
	
	@GetMapping("/getAllRatings")
	public List<Product_Rating> getAllRating();
	
	
		
	
}
