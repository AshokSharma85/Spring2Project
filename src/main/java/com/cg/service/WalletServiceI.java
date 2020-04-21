package com.cg.service;

import java.util.List;

import com.cg.entity.Account;
import com.cg.entity.Transaction;

public interface WalletServiceI {

	public void create(Account ac);
	public List retrive();
	public void add(Transaction t);
	public List findById(int id);

	

}

