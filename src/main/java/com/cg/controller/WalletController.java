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
/*
 * add data me account nahi aa raha hai
 * fetch karte time account column nahi aa rhi hai
 * sender ke through data kese fetch kare 
	
*/	@Autowired
	WalletServiceI ws;
	
	@GetMapping(value="/list")
	public List<Transaction> fetchStudent()
	{
		return ws.retrive();
	}
	
	@PostMapping(value="/new",consumes= {"application/json"})
	public String add(@RequestBody Transaction t,@RequestBody Account a )
	{
		t.setTime(new Date());
		ws.add(t);
		System.out.println(t.getAc().getAccountId());
		
		return "Transaction Added"+t.getAc().getAccountId();
		
	}
	
	@GetMapping(value="/find/{id}")
	public List fetchTransaction(@PathVariable int id)
	{
		//System.out.println(ws.findById(id).getAc().getUserofbank().getUsername());
		
		return ws.findById(id);
	}
}
