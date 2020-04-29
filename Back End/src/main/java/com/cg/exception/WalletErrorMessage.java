package com.cg.exception;

public class WalletErrorMessage {

	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public WalletErrorMessage(String message) {
		super();
		this.message = message;
	}

	public WalletErrorMessage() {
		super();
	}
	
}
