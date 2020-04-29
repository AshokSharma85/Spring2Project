package com.cg.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.WalletDaoI;
import com.cg.entity.Account;
import com.cg.entity.Transaction;
import com.cg.entity.User;
import com.cg.exception.WalletServiceException;

@Transactional
@Service
public class WalletServiceImp implements WalletServiceI {

	@Autowired
	WalletDaoI ObjectOfWalletDaoI;
	
	@PersistenceContext
	EntityManager objectOfEntityManager;
	
	
	@Override
	public List retriveTransaction() {
		return ObjectOfWalletDaoI.retriveTransaction();
	}

	
	@Override
	public void addTransaction(Transaction refOfTransaction) throws WalletServiceException {
		Query query=objectOfEntityManager.createQuery("select a.walletBalance from Account a where a.userId="+1002);
        List list=query.getResultList();
        
		if(objectOfEntityManager.find(User.class, 1002)==null)
			{
			   throw new WalletServiceException("User Id is not valid"); 
			}
		
		else if((double)list.get(0)<refOfTransaction.getAmount()) 
			{
				throw new WalletServiceException("Insufficient Balance in your wallet to Transfer"); 
			}
		
		else if(refOfTransaction.getAmount()<=0)
			{
			throw new WalletServiceException("Amount should be more than Zero"); 
	
			}
		
		else
		{
			double walletBalanceOfAccount=((double)list.get(0))-refOfTransaction.getAmount();
			ObjectOfWalletDaoI.addTransaction(refOfTransaction, walletBalanceOfAccount);

		}
		
			
	}

	
}
