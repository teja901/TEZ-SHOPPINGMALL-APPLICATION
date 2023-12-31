package com.crud.CustomerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.DuplicateEntityClases.CustomerDuplicate;
import com.crud.Entity.CustomerDetails;
import com.crud.ExceptionClasses.CustomerNotFOund;
import com.crud.Repository.CustomerRepo;

@Service
public class CustomerServiceLayer {

	@Autowired
	private CustomerRepo repo;
	
	public CustomerDuplicate saveCustomer(CustomerDetails details) {
		
		CustomerDetails customer=repo.save(details);
		return new CustomerDuplicate(customer);
	}
	
	public CustomerDuplicate getOneCustomerInfo(long number) throws CustomerNotFOund {
		Optional<CustomerDetails> details=Optional.ofNullable(repo.findByMobileNumber(number));
		CustomerDetails custmrdtils=details.orElseThrow(()->  new CustomerNotFOund("No Customer with : "+number));
		return new CustomerDuplicate(custmrdtils);
		
	}
	
	public List<CustomerDuplicate> getAllCustomerDetails(){
		List<CustomerDetails> details=repo.findAll();
		return details.stream().map(CustomerDuplicate::new).collect(Collectors.toList());
		
	}
	
	public String deleteCustomerId(long id) {
		Optional<CustomerDetails> details=repo.findById(id);
		if(details.isPresent()) {
			repo.deleteById(id);
			return "DELETED SUCCESSFULLY";
		}
		return "NO RECORD FOUNDED";
	}
	
	
	public String UpdateCustDetails(long number,CustomerDuplicate details) {
		Optional<CustomerDetails> customer=Optional.ofNullable(repo.findByMobileNumber(number));
		if(customer.isPresent()) {
			customer.get().setName(details.getName());
			customer.get().setEmail(details.getEmail());
			customer.get().setMobileNumber(details.getMobileNumber());
			repo.save(customer.get());
			return "Updated Successfully";
		}
		else 
			return "No Customer Details Founded";
		
	}
	
	
}
