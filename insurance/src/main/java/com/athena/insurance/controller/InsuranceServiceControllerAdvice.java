package com.athena.insurance.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.athena.insurance.exception.Error;
import com.athena.insurance.exception.InsuranceServiceException;

@ControllerAdvice
public class InsuranceServiceControllerAdvice {

	@ExceptionHandler
	public ResponseEntity<Error> handleGlobalException(Throwable t) {
		Error error = new Error();
		error.setErrorCode(-1);
		error.setErrorMessage("Unknown error");
		return ResponseEntity.internalServerError().body(error);
	}

	@ExceptionHandler
	public ResponseEntity<Error> handleInsuranceServiceException(InsuranceServiceException e) {
		return ResponseEntity.internalServerError().body(e.getError());
	}

}
