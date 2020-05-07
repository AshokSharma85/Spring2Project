package com.cg.dao;

import com.cg.entity.WalletUser;
import com.cg.entity.Transaction;
import com.cg.entity.WalletAccount;

public interface OnlineWalletDao {
	void persistAccount(WalletAccount account);
	void persistTransaction(Transaction transaction);
	void flush();


	boolean addUser(WalletUser user);

	boolean checkUserByEmail(String phoneNumber);
	
	WalletUser getUserByEmail(String phoneNumber);
	
	WalletUser viewUser(String phoneNumber);
	String updatePassword(WalletUser user);


	
}
