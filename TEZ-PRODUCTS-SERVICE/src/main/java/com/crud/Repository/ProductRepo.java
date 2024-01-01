package com.crud.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.crud.Entity.Products;
import com.crud.Entity.ProductsWithoutId;

@Repository
public interface ProductRepo  extends JpaRepository<Products, Long>{

	
	public  Optional<Products> findByProductName( String name);
	
    public void deleteByProductName(String name);
    
   
    
   
}
