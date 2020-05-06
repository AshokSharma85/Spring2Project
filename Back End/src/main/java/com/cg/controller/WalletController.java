package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Transaction;
import com.cg.exception.WalletServiceException;
import com.cg.service.WalletServiceI;

@CrossOrigin
@RestController
public class WalletController {
	
	@Autowired
	WalletServiceI walletServiceI;
	/*
	 * This method will return the transaction history  of user
	 */
	@SuppressWarnings("unchecked")
	@GetMapping(value="/viewTransactionHistory")
	public List<Transaction> fetchTransactionDetail()
	{
		return walletServiceI.retrieveTransaction();
	}
	
	/*
	 * This method will add the transaction into transaction table if user enter all correct data
	 */
	@PostMapping(value="/addTransaction",consumes= {"application/json"})
	public void add(@RequestBody Transaction transaction ) throws WalletServiceException
	{
		walletServiceI.addTransaction(transaction);
	}

}
