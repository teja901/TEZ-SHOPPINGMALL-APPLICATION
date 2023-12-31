package com.crud.ExceptionController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.crud.Exceptionclass.CustomerNotFound;
import com.crud.Exceptionclass.ProductNotFound;
import com.crud.Exceptionclass.RatingNotFound;

@RestControllerAdvice
public class ExceptionGeneratedClass {

	
	
	
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
@ExceptionHandler(CustomerNotFound.class)
public Map<String,String> getCustomerException(CustomerNotFound customer){
   Map<String,String> bug=new HashMap<>();
   bug.put("Please check", customer.getMessage());
   return bug;
   }
	
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(ProductNotFound.class)
	public Map<String,String> getProductException(ProductNotFound product){
		
		Map<String,String> error=new HashMap<>();
		error.put("Please check", product.getMessage());
		return error;
	}
	
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(RatingNotFound.class)
	public Map<String,String> getRatingException(RatingNotFound rate){
		
		Map<String,String> error=new HashMap<>();
		error.put("Please check", rate.getMessage());
		return error;
	}
	
	

}
