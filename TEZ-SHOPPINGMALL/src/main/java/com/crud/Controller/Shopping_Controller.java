package com.crud.Controller;

import java.util.List;


import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.Exceptionclass.CustomerNotFound;
import com.crud.Exceptionclass.ProductNotFound;
import com.crud.Exceptionclass.RatingNotFound;
import com.crud.FeignClient.Customer_And_OrderFeignClient;
import com.crud.FeignClient.ProductFeign;
import com.crud.FeignClient.RatingFeignClient;
import com.crud.ServiceClaasesoFMicroserices.Cust_And_Order;
import com.crud.ServiceClaasesoFMicroserices.CustomerDetails;
import com.crud.ServiceClaasesoFMicroserices.CustomerDuplicate;
import com.crud.ServiceClaasesoFMicroserices.Product_Rating;
import com.crud.ServiceClaasesoFMicroserices.Products;
import com.crud.ServiceClaasesoFMicroserices.Products_Duplicate_Withoud_Id;
import com.crud.ServiceClaasesoFMicroserices.Products_Plus_Rating;
import com.crud.ServiceClaasesoFMicroserices.Rating;
import com.crud.ServiceClaasesoFMicroserices.UserInfo;
import com.crud.ServiceClaasesoFMicroserices.UserOrders;
import com.crud.UserInfoRepo.UserInfoRepo;
import com.crud.UsingRestTemplateservice.CustomerAndOrderRestTemplate;

@RestController
@RequestMapping("/tezmall")
public class Shopping_Controller {
	
	@Autowired
	private UserInfoRepo userRepo;

@Autowired
private ProductFeign product;

@Autowired
private RatingFeignClient rating;

@Autowired
private Customer_And_OrderFeignClient customer;


@Autowired
private CustomerAndOrderRestTemplate co;


@GetMapping("/hi")
@Cacheable(cacheNames = "cache1",key = "'#key'")
public String add()  {
	
	return  "HI SIR";
}

@GetMapping("/getProduct/{name}")
public Products getProduct(@PathVariable String name) throws ProductNotFound {
	
	try {
	Optional<Products> pro=Optional.of(product.getProduct(name));
	return pro.get();
	}
	catch(Exception e) {
		 throw new ProductNotFound("PRODUCT DOES NOT EXIST");
	}
	
}






@DeleteMapping("/deleteProductbyid/{id}")
@CacheEvict(cacheNames = "product",key = "#id")
public String deletebyId(@PathVariable long id) {
	return product.deleteProductById(id);
}

@GetMapping("/getAllProducts")
@Cacheable(cacheNames = "cache1",key = "'#key'")
public List<Products_Duplicate_Withoud_Id> displayAllProducts(){
	List<Products> p=product.getAllProducts();
	return p.stream().map(Products_Duplicate_Withoud_Id::new).collect(Collectors.toList());
	
}



//           //Rating Controllers Mapping........//



@PostMapping("/giveProductRating")
public String saveRating(@RequestBody Rating rate) {
	return rating.saveRating(rate);
	
}

@GetMapping("/getProductRating/{name}")
public Product_Rating getOneRating(@PathVariable String name) throws RatingNotFound {
	Optional<Product_Rating> rate=Optional.ofNullable(rating.getOne(name));
	
		return rate.orElseThrow(()-> new RatingNotFound("Rating Not Found given : "+name));
	
}

@DeleteMapping("/deleteRatingid/{id}")
@CacheEvict(cacheNames = "productrating",key = "#id")
public String deleteRating(@PathVariable long id) throws RatingNotFound {
	Optional<String> rate=Optional.ofNullable(rating.delete(id));
	return rate.get();
	
}


//                ProductPlusRating................          ///


@GetMapping("/getProductPlusRating/{name}")
public String productPlusRating(@PathVariable String name) {
	
	return product.getOneRating(name);
}

@GetMapping("/getAllProductPlusRating")
public List<Products_Plus_Rating> products_Plus_Ratings(){
	return product.getAllProductsPlusRating();
}




//..................//CustomerDetails//....................//

@PostMapping("/customerLogin")
public CustomerDuplicate saveCustomerDetails(@RequestBody CustomerDuplicate details) {
	return customer.saveCustomer(details);
}

@GetMapping("/getCustomerInfo/{number}")
public CustomerDuplicate getCustomerDetails(@PathVariable long number) throws CustomerNotFound {
	try {
	return customer.getCustomerInfo(number);
	}
	catch(Exception e) {
		throw new CustomerNotFound("No Customer with :"+number);
	}
	
}



@PutMapping("/updateCustomerDeatils/{number}")
public String updateCustomerDetails(@PathVariable long number,@RequestBody CustomerDuplicate duplicate) {
	
	return customer.updateCustomerDeatils(number, duplicate);
}

@PostMapping("/placeOrder")
public String placeOrder(@RequestBody CustomerDetails details) {
	return customer.placeOrder(details);
}


@DeleteMapping("/deleteCustomerWithId/{id}")
@CacheEvict(cacheNames = "customer",key = "#id")
public ResponseEntity<String> deleteCustomerWithId(@PathVariable long id) {
	return co.deleteCustomer(id);
}




@GetMapping("/getUserInfo/{name}")
public UserInfo userGet(@PathVariable String name) {
	
	return userRepo.findByusername(name).get();
}


@GetMapping("/getOrderDemo")
public ResponseEntity<String> getOrderDemo() {
	return co.getDemo();
}

}
