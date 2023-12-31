package com.crud.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.Entity.Product_Rating;
@Repository
public interface RatingRepo extends JpaRepository<Product_Rating, Long>{

	public Product_Rating findByProductName(String name);
	
	public List<Product_Rating> findByRatingBetween(double min,double max);
}
