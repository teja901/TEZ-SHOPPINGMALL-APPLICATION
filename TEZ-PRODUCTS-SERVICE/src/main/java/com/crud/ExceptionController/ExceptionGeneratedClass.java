package com.crud.ExceptionController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.crud.ExceptionClass.ProductNotFound;
import com.crud.ExceptionClass.RatingException;

@RestControllerAdvice
public class ExceptionGeneratedClass {

	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(ProductNotFound.class)
	public Map<String,String> getException(ProductNotFound product){
		
		Map<String,String> error=new HashMap<>();
		error.put("Please check", product.getMessage());
		return error;
	}
	
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(RatingException.class)
	public List<String> exceptionHandler(RatingException rating){
		List<String> error=new ArrayList<>();
		 error.add(rating.getMessage());
		return error;
	}
}
