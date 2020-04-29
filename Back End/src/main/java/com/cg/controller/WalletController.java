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
	WalletServiceI objOfWalletServiceI;
	
	@GetMapping(value="/list")
	public List<Transaction> fetchTransactionDetail()
	{
		return objOfWalletServiceI.retriveTransaction();
	}
	
	@PostMapping(value="/addTransaction",consumes= {"application/json"})
	public String add(@RequestBody Transaction refOfTransaction ) throws WalletServiceException
	{
		objOfWalletServiceI.addTransaction(refOfTransaction);
		return "Transaction Added";		
	}

}
