package com.crud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.DuplicateEntityClases.CustomerDuplicate;
import com.crud.Entity.CustomerDetails;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerDetails, Long> {
      
	
	
	public CustomerDetails findByMobileNumber(long number);
	
	
	

}
