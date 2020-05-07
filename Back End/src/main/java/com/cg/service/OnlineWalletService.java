package com.cg.service;


import com.cg.entity.WalletUser;
import com.cg.exception.loginException.UserException;

public interface OnlineWalletService {
	
	boolean addUser(WalletUser user);
	String login(String phoneNumber, String password) throws UserException;
	String updatePassword(WalletUser user) throws UserException;

	
	

}
  