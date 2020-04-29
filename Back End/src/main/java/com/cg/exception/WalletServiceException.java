package com.cg.exception;

public class WalletServiceException extends Exception {

	String message;

	
	
	public WalletServiceException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
