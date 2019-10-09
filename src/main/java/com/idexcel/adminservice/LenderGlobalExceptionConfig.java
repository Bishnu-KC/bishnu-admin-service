package com.idexcel.adminservice;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.idexcel.adminservice.exception.LenderAlreadyExistsException;
import com.idexcel.adminservice.exception.LenderErrorResponse;
import com.idexcel.adminservice.exception.LenderNotFoundException;

@Configuration
@ControllerAdvice
public class LenderGlobalExceptionConfig {

	@ExceptionHandler
	public ResponseEntity<LenderErrorResponse> handleException(Exception exec) {

		LenderErrorResponse error = new LenderErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exec.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler
	public ResponseEntity<LenderErrorResponse> handleException(LenderAlreadyExistsException exec) {

		LenderErrorResponse error = new LenderErrorResponse();
		error.setStatus(HttpStatus.CONFLICT.value());
		error.setMessage(exec.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.CONFLICT);
	}

	@ExceptionHandler
	public ResponseEntity<LenderErrorResponse> handleException(LenderNotFoundException exec) {

		LenderErrorResponse error = new LenderErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exec.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

}
