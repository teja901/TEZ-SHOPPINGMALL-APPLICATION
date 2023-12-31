package com.crud.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.Entity.Product_Rating;
import com.crud.Entity.Rating;
import com.crud.ExceptionClass.RatingException;
import com.crud.Service.Product_Rating_Service;

@RestController
@RequestMapping("/productRating")
public class Controller {

	
	@Autowired
	private Product_Rating_Service service;
	
	
	@GetMapping("/rating")
	public String add() {
		return "rating";
	}
	
	@PostMapping("/giveRating")
	public String saveRating(@RequestBody Rating rating) {
		
		return service.saveEntity(rating.getProductName(),rating.getRating(),rating.getReviews());
		
	}
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable long id) {
		
		return service.deletebyid(id);
	}
	
	@GetMapping("/getProductRating/{name}")
	public Product_Rating getOne(@PathVariable String name)   {
	          Product_Rating rating= service.getOne(name);
	         return rating;
	          
	}
	
	@GetMapping("/getRangeBetween")
	public List<Product_Rating> getRangeBetween(@RequestParam double min,@RequestParam double max){
		return service.getRangeBetween(min, max);
	}
	
	@GetMapping("/getAllRatings")
	public List<Product_Rating> getRatingAll(){
		return service.getAllRating();
	}
	
	
}
