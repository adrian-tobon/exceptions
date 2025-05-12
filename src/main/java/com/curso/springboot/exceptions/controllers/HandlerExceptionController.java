package com.curso.springboot.exceptions.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.curso.springboot.exceptions.models.Error;


@RestControllerAdvice
public class HandlerExceptionController {

	
	@ExceptionHandler({java.lang.ArithmeticException.class})
	public ResponseEntity<Error> divisionByZero(Exception exception){
		Error error = new Error();
		error.setDate(new Date());
		error.setError("Error division por cero");
		error.setMessage(exception.getMessage());
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		
		
		//return ResponseEntity.internalServerError().body(error);		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);
		
	}
	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<Error> notFound(NoHandlerFoundException exception){
		Error error = new Error();
		error.setDate(new Date());
		error.setError("Pagina no encontrada");
		error.setMessage(exception.getMessage());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		
		
		//return ResponseEntity.internalServerError().body(error);		
		return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
		
	}
	
	@ExceptionHandler(NumberFormatException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String,Object> numberFormat(NumberFormatException exception){
		Map<String,Object> error = new HashMap<>();
		
		error.put("date", new Date());
		error.put("error", "El valor no cumple el formato numerico");
		error.put("message", exception.getMessage());
		error.put("status", HttpStatus.BAD_REQUEST.value());
		
		//return ResponseEntity.internalServerError().body(error);		
		return error;
		
	}
	
}
