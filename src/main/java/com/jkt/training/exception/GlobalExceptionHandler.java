package com.jkt.training.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value=Exception.class)
	public ResponseEntity<Object> AllException(Exception e){
		ErrorDetails error=new ErrorDetails(e.getMessage());
		return new ResponseEntity<Object>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = NotFoundException.class)
	public ResponseEntity<Object> resourcenotfound(NotFoundException e){
		ErrorDetails error=new ErrorDetails(e.getMessage());
		return new ResponseEntity<Object>(error,HttpStatus.NOT_FOUND);
	}
}
