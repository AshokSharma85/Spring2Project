package com.cg.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.exception.WalletErrorMessage;
import com.cg.exception.WalletServiceException;

@RestControllerAdvice
public class WalletControllerAdvice {

	@ExceptionHandler(value= {WalletServiceException.class})
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public WalletErrorMessage  handelWalletServiceException(WalletServiceException exception) {
		return new WalletErrorMessage(exception.getMessage());
	}

}
