package com.cg.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.cg.entity.Transaction;


@Repository
public interface WalletDaoI {

	@SuppressWarnings("rawtypes")
	public List retrieveTransaction();
	public void addTransaction(Transaction transaction,double walletBalanceOfAccount);
	
}

