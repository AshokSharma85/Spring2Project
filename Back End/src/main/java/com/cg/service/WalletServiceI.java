package com.cg.service;

import java.util.List;

import com.cg.entity.Transaction;
import com.cg.exception.WalletServiceException;

public interface WalletServiceI {

	@SuppressWarnings("rawtypes")
	public List retrieveTransaction(Long loggedInIdForTransactionHistory);
	public void addTransaction(Transaction transaction) throws WalletServiceException;

	

}

