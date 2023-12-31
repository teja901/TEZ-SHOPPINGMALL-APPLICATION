package com.crud.ExceptionController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.crud.ExceptionClass.RatingException;

@RestControllerAdvice
public class ExceptionController {

	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(RatingException.class)
	public List<String> exceptionHandler(RatingException rating){
		List<String> error=new ArrayList<>();
		 error.add(rating.getMessage());
		return error;
	}
}
