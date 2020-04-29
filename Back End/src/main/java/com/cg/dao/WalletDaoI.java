package com.cg.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.cg.entity.Transaction;


@Repository
public interface WalletDaoI {

	public List retriveTransaction();
	public void addTransaction(Transaction t,double walletBalanceOfAccount);
	
}

