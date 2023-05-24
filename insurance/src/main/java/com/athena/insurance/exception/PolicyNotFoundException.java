package com.athena.insurance.exception;

public class PolicyNotFoundException extends InsuranceServiceException {
	private static final long serialVersionUID = 7518609536488095063L;

	public PolicyNotFoundException(String cause, Error error) {
		super(error, cause);
	}
}
