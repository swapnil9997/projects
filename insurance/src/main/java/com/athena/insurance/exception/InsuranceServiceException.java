package com.athena.insurance.exception;

public class InsuranceServiceException extends RuntimeException {
	private static final long serialVersionUID = -4423689010505005162L;
	private Error error;

	public InsuranceServiceException(Error error, String cause) {
		super(cause);
		this.error = error;
	}

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}

}
