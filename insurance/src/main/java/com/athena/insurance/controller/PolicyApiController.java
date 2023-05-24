package com.athena.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.athena.insurance.dto.PolicyDetailsDto;
import com.athena.insurance.exception.Error;
import com.athena.insurance.exception.PolicyNotFoundException;
import com.athena.insurance.service.PolicyService;

@RestController
@RequestMapping("/policy")
public class PolicyApiController {
	@Autowired
	private PolicyService policyService;

	@GetMapping(value = "/{policyNo}/details", produces = { MediaType.APPLICATION_JSON_VALUE })
	public PolicyDetailsDto getPolicyDetails(@PathVariable("policyNo") int policyNo) throws InterruptedException {
		Thread.sleep(2000); // slow running service
		return policyService.getPolicyDetails(policyNo);
	}

	@ExceptionHandler
	public ResponseEntity<Error> handlePolicyNotFoundException(PolicyNotFoundException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getError());
	}
}
