package com.crud.FeignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.crud.ServiceClaasesoFMicroserices.CustomerDetails;
import com.crud.ServiceClaasesoFMicroserices.CustomerDuplicate;


@FeignClient(url = "localhost:8084/customerLogin",value = "CustomerOrder-feignClient")
public interface Customer_And_OrderFeignClient {

	@PostMapping("/saveCustomer")
	public CustomerDuplicate saveCustomer(@RequestBody CustomerDuplicate details);
	
	
	@GetMapping("/getCustomerInfo/{number}")
	public CustomerDuplicate getCustomerInfo(@PathVariable long number);
	
	
	@GetMapping("/getAllCustomerDetails")
	public List<CustomerDuplicate> getAllCustomerDetails();
	
	
@PutMapping("/updateCustomerDeatils/{number}")
public String updateCustomerDeatils(@PathVariable long number,@RequestBody CustomerDuplicate details);
		
	
	@PostMapping("/placeOrder")
	public String placeOrder(@RequestBody CustomerDetails customers);
	
	
}
