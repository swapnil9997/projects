package com.yashoda.exception;

public class PolicyNotFoundException extends InsuranceServiceFailureException {
	private static final long serialVersionUID = 4509185819942754028L;

	public PolicyNotFoundException(Error error) {
		super(error);
	}

}
