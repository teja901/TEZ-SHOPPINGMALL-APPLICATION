package com.crud.Controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.crud.CustomerService.CustomerServiceLayer;
import com.crud.DuplicateEntityClases.CustomerDuplicate;
import com.crud.Entity.Cust_And_Order;
import com.crud.Entity.CustomerDetails;
import com.crud.Entity.UserOrders;
import com.crud.ExceptionClasses.CustomerNotFOund;
import com.crud.ExceptionClasses.OrderNotFound;
import com.crud.FeignClient.ProductFeignClient;
import com.crud.OrderMailService.MailService;
import com.crud.OtherMicroservicesClasses.ProductsWithoutId;
//import com.crud.FeignClient.ProductFeignClient;
import com.crud.Repository.CustomerRepo;
import com.crud.Repository.OrderRepository;

@RestController
@RequestMapping("/customerLogins")
public class Controller {

	@Autowired
	private CustomerServiceLayer customer;
	
	@Autowired
	private CustomerRepo custRepo;
	
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private ProductFeignClient productClient;
	
	@Autowired
	private MailService mailService;
	
	@GetMapping("/demo")
	public String demo() {
		return "DEMO";
	}
	
	@PostMapping("/saveCustomer")
	public CustomerDuplicate saveCustomer(@RequestBody CustomerDetails details) {
		
		return customer.saveCustomer(details);
	}
	
	@GetMapping("/getCustomerInfo/{number}")
	public CustomerDuplicate getCustomerInfo(@PathVariable long number) throws CustomerNotFOund  {
	    return customer.getOneCustomerInfo(number);
	          
	}
	
	@GetMapping("/getAllCustomerDetails")
	public List<CustomerDuplicate> getAllCustomerDetails(){
		
		return customer.getAllCustomerDetails();
	}
	
	@DeleteMapping("/deleteCustomerDetails/{id}")
	public String deleteCustomerId(@PathVariable long id) {
		return customer.deleteCustomerId(id);
	}
	
	
	@PutMapping("/updateCustomerDeatils/{number}")
	public String updateCustomerDeatils(@PathVariable long number,@RequestBody CustomerDuplicate details) {
		return customer.UpdateCustDetails(number, details);
	}
	
	
	
	//..///
	
	@PostMapping("/placeOrder")
	public String placeOrder(@RequestBody CustomerDetails customers) throws OrderNotFound
	{
		
		            
		            
                     List<UserOrders> user= customers.getOrders();
                     for(UserOrders u:user) {
                    	 try {
                    	 ProductsWithoutId id=productClient.getOneProduct(u.getProductName());
      
                    	 if(id.getQuantity()>0 && u.getQuantity()<=id.getQuantity()&&u.getQuantity()>0) {
                    		 productClient.updatingAfterOrder(u.getProductName(),u.getQuantity());
                    		 custRepo.save(customers);
                    
                    	 }
                    	 
                    	 else {
                    		 return "No STOCK AVAILABLE OF "+u.getProductName() +"  STOCK LEFT : - "+id.getQuantity();
                    	 }
                    	 }
                    	 catch(Exception e) {
                    		 System.out.println(e.getMessage());
                    		return "NO PRODUCT with NAME OF "+u.getProductName();
                    	 }
                     }
                     
		
		mailService.sendMail(customers.getEmail(),"TEZMALL" ,"YOUR ORDER PLACED SUCCESFULLY");
		 return "Ordered Placed Successfully";
		
	}
	
	
	
	@DeleteMapping("/deleteCustomerInfo/{id}")
	public String deleteCustomer(@PathVariable long id ) {
		Optional<CustomerDetails> details=custRepo.findById(id);
		
		if(details.isPresent()) {
			custRepo.deleteById(id);
			return "DELTED SUCCESFULLY";
		}
		else {
			return "No RECORD FOUND";
		}
	}
	
	//.......ORDER.............
	@GetMapping("/getUserOrderDetails/{number}")
	public List<Cust_And_Order> userDetails(@PathVariable long number) {
		return orderRepo.findByMobileNumber(number);
	}
	
	@GetMapping("/getAllOrderDetails")
	public List<UserOrders> getOrder() {
		return orderRepo.findAll();
	}
	
	
	
}

