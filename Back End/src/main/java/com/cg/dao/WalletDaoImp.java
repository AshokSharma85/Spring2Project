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
	
	/*
	 *This method will retrieve data from transaction table of logged in user 	 
	 */

	@Override
	public List retrieveTransaction() {

		int id=1011;
		
		/*
		 * This method will return the transaction history as return type list
		 */
		
		Query query=entityManager.createQuery("from Transaction where sender="+id);
		
		return query.getResultList();
		

	}

	@Override
	public void addTransaction(Transaction transaction,double walletBalanceOfAccount) {
		
		/*
		 * This will give the current time and date
		 */
		Date dateNow = new Date( );
	    
		/*
		 * To set date in specific format
		 */
		SimpleDateFormat objectOfSimpleDateFormat =new SimpleDateFormat ("hh:mm a',' E dd MMM yyyy");
	    transaction.setTime(objectOfSimpleDateFormat.format(dateNow));

	    /*
	     * This will set the Id of sender in transaction table
	     */
	    
	    transaction.setSender(1011);
		
	    /*
	     * This query will give you the account Id of sender which we can set in transaction table 
	     */
		Query query1=entityManager.createQuery("select accountId from Account where userId="+1002);
        List list1=query1.getResultList();
        transaction.getAc().setAccountId((int)list1.get(0));
		
       /*
        * from this query we will update the wallet balance of sender's Id 
        */
        
        Query query2=entityManager.createQuery("UPDATE Account SET walletBalance =" +walletBalanceOfAccount+"WHERE userId="+1002);
        query2.executeUpdate();
        
        /*
         *By using this query we will get the wallet balance of receiver and store the updated value in variable 
         * name walletBalanceOfAccountForReceiver
         */
        
        Query query3=entityManager.createQuery("select walletBalance from Account where userId="+transaction.getReceiver());
        List list2=query3.getResultList();
        double walletBalanceOfAccountForReceiver=((double)list2.get(0))+transaction.getAmount();
        
        /*
         *This query will set the updated balance of receiver's Id in Account table 
         */
        
        Query query4=entityManager.createQuery("UPDATE Account  SET walletBalance =" +walletBalanceOfAccountForReceiver+"WHERE userId="+transaction.getReceiver());
        query4.executeUpdate();
      
        
        entityManager.persist(transaction);
		
	}
		
}


