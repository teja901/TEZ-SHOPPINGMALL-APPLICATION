package com.crud.SecurityAccessController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.FeignClient.Customer_And_OrderFeignClient;
import com.crud.FeignClient.ProductFeign;
import com.crud.ServiceClaasesoFMicroserices.Cust_And_Order;
import com.crud.ServiceClaasesoFMicroserices.CustomerDuplicate;
import com.crud.ServiceClaasesoFMicroserices.Products;
import com.crud.ServiceClaasesoFMicroserices.UserOrders;
import com.crud.UsingRestTemplateservice.CustomerAndOrderRestTemplate;

@RestController
@RequestMapping("/tezmall/membership")
public class SecurityController {

	@Autowired
	private Customer_And_OrderFeignClient customer;

	@Autowired
	private ProductFeign product;
	
	@Autowired
	private CustomerAndOrderRestTemplate co;
	
	@GetMapping("/getUserOrderDetails/{number}")
	@PreAuthorize("hasAuthority('USER')")
	public ResponseEntity<List<Cust_And_Order>> getCustOrderinfo(@PathVariable long number){
		return co.getUserInfoWithOrder(number);
	}
	
	@GetMapping("/getAllUsersOrders")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<List<UserOrders>> getAllUsersOrders(){
		return co.getAllUsersOrders();
	}
	
	
	@GetMapping("/getAllCustomerDetails")
	public List<CustomerDuplicate> getAllCustomerDuplicates(){
		return customer.getAllCustomerDetails();
	}
	
	
	@PostMapping("/saveProduct")
	@PreAuthorize("hasAuthority('OWNER')")
	public Products saveProduct(@RequestBody Products pro) {
		
		return product.saveEntity(pro);
	}
	
	
	@DeleteMapping("/deleteProductbyname/{name}")
	@PreAuthorize("hasAuthority('OWNER')")
	public String deleteProduct(@PathVariable String name) {
		return product.deleteProduct(name);
	}
	
}
