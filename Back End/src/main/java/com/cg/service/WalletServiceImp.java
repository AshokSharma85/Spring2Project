package com.cg.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.WalletDaoI;
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
	
	/*
	 * This method will call the DAO class to get the transaction history 
	 */
	
	@Override
	public List retrieveTransaction() {
		return ObjectOfWalletDaoI.retrieveTransaction();
	}

	
	@Override
	public void addTransaction(Transaction refOfTransaction) throws WalletServiceException {
		
		Query query=objectOfEntityManager.createQuery("select a.walletBalance from Account a where a.userId="+1002);
        List list=query.getResultList();
        
        /*
         *This condition will check the presence of user to transfer the money 
         * if user is present in database than only it will go further
         */
        
		if(objectOfEntityManager.find(User.class, 1002)==null)
			{
			   throw new WalletServiceException("User Id is not valid"); 
			}
		
		/*
		 * This condition will check if that much amount is there in user's wallet as much user wants to send
		 * if not then it will throw the exception 
		 */
		
		else if((double)list.get(0)<refOfTransaction.getAmount()) 
			{
				throw new WalletServiceException("Insufficient Balance in your wallet to Transfer"); 
			}
		
		/*
		 * This condition will check if entered amount by user is not less than zero 
		 * if amount is less than zero or zero then it will throw exception
		 */
		
		else if(refOfTransaction.getAmount()<=0)
			{
			throw new WalletServiceException("Amount should be more than Zero"); 
	
			}
		
		/*
		 * If all condition go well than this will find the amount which we can update in sender's wallet balance 
		 */
		
		
		else
		{
			double walletBalanceOfAccount=((double)list.get(0))-refOfTransaction.getAmount();
			ObjectOfWalletDaoI.addTransaction(refOfTransaction, walletBalanceOfAccount);

		}
		
			
	}

	
}
