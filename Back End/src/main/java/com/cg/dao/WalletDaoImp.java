package com.cg.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.cg.entity.Transaction;


@Repository
public class WalletDaoImp implements WalletDaoI
{

	@PersistenceContext
	EntityManager entityManager;
	
	
	/**********************************************************************************************************************
	 * Method: retrieveTransaction
	 * Description: This method will retrieve data from transaction table of logged in user 
	 * @return :   It returns the list which will store the all transaction   
	 * Created By: Ashok Sharma 
	 * Created Date: 25-Apr-2020
	 * *********************************************************************************************************************
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public List retrieveTransaction() {

		
		
		/********************************************************************************
		 * This Query will return the transaction history from transaction table
		 **********************************************************************************/
		
		Query query=entityManager.createQuery("from Transaction where sender="+8504930595L);
		
		return query.getResultList();
		

	}

	
	/***********************************************************************************************************************
	 * Method: addTransaction
	 * Description: This method will update and set the required data to the table in database
	 * @return :   It returns nothing   
	 * Created By: Ashok Sharma 
	 * Created Date: 25-Apr-2020
	 * **********************************************************************************************************************
	 */
	
	@SuppressWarnings("rawtypes")
	@Override
	public void addTransaction(Transaction transaction,double walletBalanceOfWallet) {
		
		/*****************************************************************************************************************
		 * This will give the current time and date
		 **************************************************************************************************************/
		Date dateNow = new Date( );
	    
		/*************************************************************************************************************
		 * To set date in specific format
		 **************************************************************************************************************/
		SimpleDateFormat objectOfSimpleDateFormat =new SimpleDateFormat ("hh:mm a',' E dd MMM yyyy");
	    transaction.setDate(objectOfSimpleDateFormat.format(dateNow));

	    /**************************************************************************************************************
	     * This will set the Id of sender in transaction table
	     ****************************************************************************************************************/
	    
	   
	    transaction.setSender(8504930595L);
	    
		
	    /****************************************************************************************************************
	     * This will set the wallet Id of sender which we can set in transaction table 
	     ******************************************************************************************************/
		
        transaction.getWallet().setWalletId(8504930595L);
		
       /*********************************************************************************************************
        * from this query we will update the wallet balance of sender's Id 
        *******************************************************************************************************/
        
        Query query1=entityManager.createQuery("UPDATE Wallet SET walletBalance =" +walletBalanceOfWallet+"WHERE walletId="+8504930595L);
        query1.executeUpdate();
        
        
        /********************************************************************************************************************
         *By using this query we will get the wallet balance of receiver and store the updated value in variable 
         * name walletBalanceOfAccountForReceiver
         ******************************************************************************************************************/
        
        Query query2=entityManager.createQuery("select walletBalance from Wallet where walletId="+transaction.getReceiver());
        List list1=query2.getResultList();
        double walletBalanceOfWalletForReceiver=((double)list1.get(0))+transaction.getAmount();
        
        
        /*********************************************************************************************************************
         *This query will set the updated balance of receiver's Id in Account table 
         *********************************************************************************************************************/
        
        Query query3=entityManager.createQuery("UPDATE Wallet  SET walletBalance =" +walletBalanceOfWalletForReceiver+"WHERE walletId="+transaction.getReceiver());
        query3.executeUpdate();
      
        Query query4=entityManager.createQuery("select userName from User where mobileNumber="+transaction.getReceiver());
        List list2=query4.getResultList();
        System.out.println((String)list2.get(0));
        transaction.setNameOfReceiver((String)list2.get(0));
        
        entityManager.persist(transaction);
		
	}
		
}


