package com.yashoda.exception;

public class InsuranceServiceFailureException extends RuntimeException {
	private static final long serialVersionUID = -6848531681814876802L;
	private Error error;

	public InsuranceServiceFailureException(Error error) {
		this.error = error;
	}

	public Error getError() {
		return error;
	}

}
