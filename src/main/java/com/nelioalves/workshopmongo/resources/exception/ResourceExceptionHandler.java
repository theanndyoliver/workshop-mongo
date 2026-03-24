package com.nelioalves.workshopmongo.resources.exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nelioalves.workshopmongo.services.exception.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFoundException (ObjectNotFoundException er ,HttpServletRequest request) {
		
		
		StandardError error = new StandardError(Instant.now(),HttpStatus.NOT_FOUND.value(),"Não encontrado!",er.getMessage()
				,request.getRequestURI());
		
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

}
