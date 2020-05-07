package com.cg.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.exception.loginException.UserException;

@RestControllerAdvice
public class WalletControllerAdviceForLogin {
	
	@ExceptionHandler(value= {UserException.class} )
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public ErrorMessageForLogin handleException(Exception ex)
	{
		return new ErrorMessageForLogin(ex.getMessage());
	}

}



