package com.crud.ExceptionController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.crud.ExceptionClasses.CustomerNotFOund;
import com.crud.ExceptionClasses.OrderNotFound;

@RestControllerAdvice
public class ExceptionGeneratedClass {

	
@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
@ExceptionHandler(CustomerNotFOund.class)
public Map<String,String> getRatingException(CustomerNotFOund customer){
		
		Map<String,String> error=new HashMap<>();
		error.put("Please check", customer.getMessage());
		return error;
	}


@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
@ExceptionHandler(OrderNotFound.class)
public Map<String,String> getOrderException(OrderNotFound order){
	
	Map<String,String> error=new HashMap<>();
	error.put("Please check", order.getMessage());
	return error;
}
}
