package com.cg.controller;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Account;
import com.cg.entity.Transaction;
import com.cg.service.WalletServiceI;

@CrossOrigin
@RestController
public class WalletController {
	
	@Autowired
	WalletServiceI ws;
	
	@GetMapping(value="/list")
	public List<Transaction> fetchStudent()
	{
		return ws.retrive();
	}
	
	@PostMapping(value="/addTransaction",consumes= {"application/json"})
	public String add(@RequestBody Transaction t )
	{
		//ws.findById(id) ye vali id kese lau
		ws.add(t);
		return "Transaction Added";		
	}
	
	@GetMapping(value="/find/{id}")
	public List fetchTransaction(@PathVariable int id)
	{		
		return ws.findById(id);
	}
}
