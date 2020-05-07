package com.cg.exception.loginException;

public class UnauthorizedAccessException extends RuntimeException {
	public UnauthorizedAccessException(String message)
	{
		super(message);
	}

}
