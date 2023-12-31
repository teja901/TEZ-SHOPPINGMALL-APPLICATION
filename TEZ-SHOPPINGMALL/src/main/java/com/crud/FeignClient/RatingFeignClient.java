package com.crud.FeignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.crud.ServiceClaasesoFMicroserices.Product_Rating;
import com.crud.ServiceClaasesoFMicroserices.Products;
import com.crud.ServiceClaasesoFMicroserices.Rating;


@FeignClient(url="localhost:8083/product",value="Rating-Client")
public interface RatingFeignClient {
 
	@PostMapping("/giveRating")
	public String saveRating(@RequestBody Rating rating);

	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable long id);
	
	
	
	@GetMapping("/getProductRating/{name}")
	public Product_Rating getOne(@PathVariable String name);

	
	
}
