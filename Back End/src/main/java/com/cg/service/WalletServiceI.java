package com.cg.service;

import java.util.List;

import com.cg.entity.Account;
import com.cg.entity.Transaction;
import com.cg.exception.WalletServiceException;

public interface WalletServiceI {

	public List retriveTransaction();
	public void addTransaction(Transaction t) throws WalletServiceException;

	

}

