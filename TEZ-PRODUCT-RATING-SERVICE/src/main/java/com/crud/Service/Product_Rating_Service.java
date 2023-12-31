package com.crud.Service;

import java.math.BigDecimal;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.Entity.Product_Rating;
import com.crud.Entity.Rating;
import com.crud.ExceptionClass.RatingException;
import com.crud.Repository.RatingRepo;

@Service
public class Product_Rating_Service {
	
	@Autowired
	private RatingRepo repo;

	public String saveEntity(String name,double stars,String review) {
		
		Product_Rating rate=repo.findByProductName(name);
		
	    if(rate==null) {
	    	 rate=new Product_Rating();
	    	rate.setProductName(name);
	    	rate.setRating(stars);
           List<String> reviews= rate.getReviews();
           reviews.add(review);
           rate.setReviews(reviews);
	    	rate.setNo_Of_People_Rated(1l);
	    	
	    	repo.save(rate);
	    	System.out.println("Rated Succesfully");
	    }
	    else {
	    	long no_of_people=rate.getNo_Of_People_Rated();
	    	double newAvgRating=(rate.getRating() * no_of_people +stars) /
	    			(no_of_people+1);

	    	String changer=String.format("%.1f",newAvgRating);
	    	double avgRate=Double.parseDouble(changer);
	    	rate.setRating(avgRate);
	    	rate.setNo_Of_People_Rated(++no_of_people);
	        rate.getReviews().add(review);
	    	repo.save(rate);
	    	
	    }
	
		return "RATED SUCCESSFULLY";
		
	}
	
	public String deletebyid(long id) {
		Optional<Product_Rating> rating=repo.findById(id);
		if(rating.isPresent()) {
		repo.deleteById(id);
		return "DELETED SUCCESSFULLY";
		}
		else {
			return "No Id Founded";
		}
	}
	
	public Product_Rating getOne(String name)  {
		Product_Rating rating=repo.findByProductName(name);
		
		return rating;
	}
	
	public List<Product_Rating> getRangeBetween(double min,double max){
		
		return repo.findByRatingBetween(min,max);
	}
	
	public List<Product_Rating> getAllRating(){
		return repo.findAll();
	}
	

}
