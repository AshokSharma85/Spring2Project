package com.cg.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.WalletDaoI;
import com.cg.entity.Account;
import com.cg.entity.Transaction;

@Transactional
@Service
public class WalletServiceImp implements WalletServiceI {

	@Autowired
	WalletDaoI wd;
	
	@Override
	public void create(Account ac) {
		wd.create(ac);	
	}

	@Override
	public List retrive() {
		return wd.retrive();
	}

	@Override
	public void add(Transaction t) {
		wd.add(t);
	}

	@Override
	public List findById(int id) {
		return wd.findById(id);
	}

	
}
