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
import com.cg.entity.WalletAccount;
import com.cg.exception.WalletServiceException;

@Transactional
@Service
public class WalletServiceImp implements WalletServiceI {

	@Autowired
	WalletDaoI walletDaoI;
	
	@PersistenceContext
	EntityManager entityManager;
	
	
	/**********************************************************************************************************************
	 * Method: retrieveTransaction
	 * Description: This method will call the DAO class to get the transaction history
	 * @return :   It returns the list which will store the all transaction   
	 * Created By: Ashok Sharma 
	 * Created Date: 25-Apr-2020
	 * *********************************************************************************************************************
	 */
	
	@SuppressWarnings("rawtypes")
	@Override
	public List retrieveTransaction(Long loggedInIdForTransactionHistory) {
		return walletDaoI.retrieveTransaction(loggedInIdForTransactionHistory);
	}

	/***********************************************************************************************************************
	 * Method: addTransaction
	 * Description: This method will check all the details enter by user and if everything is right then 
	 *                 it will send the data to dao layer
	 * @return :   It returns nothing   
	 * Created By: Ashok Sharma 
	 * Created Date: 25-Apr-2020
	 * **********************************************************************************************************************
	 */
	
	@SuppressWarnings("rawtypes")
	@Override
	public void addTransaction(Transaction transaction) throws WalletServiceException {
		
		Query query=entityManager.createQuery("select walletBalance from WalletAccount  where walletId="+transaction.getSender());
        List list=query.getResultList();
        
        /**************************************************************************
         *This condition will check the presence of user to transfer the money 
         * if user is present in database than only it will go further
         ****************************************************************************/
        
		if(entityManager.find(WalletAccount.class,transaction.getReceiver())==null)
			{
			   throw new WalletServiceException("Mobile Number does not exists to transfer"); 
			}
		
		/******************************************************************************
		 * This will check if user is not trying to send money to himself/herself.
		 *******************************************************************************/
		
		else if(transaction.getReceiver().equals(transaction.getSender()))
		{
			throw new WalletServiceException("Please Enter Correct Mobile Number");
		}
		
		/***************************************************************************************************************
		 * This condition will check if that much amount is there in user's wallet as much user wants to send
		 * if not then it will throw the exception 
		 ****************************************************************************************************************/
		
		else if((double)list.get(0)<transaction.getAmount()) 
			{
				throw new WalletServiceException("Insufficient Balance in your wallet to Transfer"); 
			}
		
		/*****************************************************************************************************
		 * This condition will check if entered amount by user is not less than zero 
		 * if amount is less than zero or zero then it will throw exception
		 ******************************************************************************************************/
		
		else if(transaction.getAmount()<=0)
			{
			throw new WalletServiceException("Amount should be more than Zero"); 
	
			}
		
		/*********************************************************************************************************
		 * If all condition go well than this will find the amount which we can update in sender's wallet balance 
		 **********************************************************************************************************/
		
		
		else
		{
			double walletBalance=((double)list.get(0))-transaction.getAmount();
			walletDaoI.addTransaction(transaction, walletBalance);

		}
		
			
	}

	
}
