package com.athena.insurance.exception;

import lombok.Data;

/**
 * @author Neosoft
 *
 */
@Data
public class Error {
	private int errorCode;
	private String errorMessage;

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Error() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Error(int errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "Error [errorCode=" + errorCode + ", errorMessage=" + errorMessage + "]";
	}

}
