package com.crud.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.crud.OtherMicroservicesClasses.ProductsWithoutId;


@FeignClient(url = "http://localhost:8082/products",name="order-Client")
public interface ProductFeignClient{
	
	
	@GetMapping("/get/{name}")
	public ProductsWithoutId getOneProduct(@PathVariable String name);
	
	
	@PostMapping("/UpdateProductAfterOrder/{name}/{quantity}")
	public void updatingAfterOrder(@PathVariable String name,@PathVariable long quantity);
}