package com.cg.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.entity.Account;
import com.cg.entity.Transaction;
import com.cg.entity.User;


@Repository
public class WalletDaoImp implements WalletDaoI
{

	@PersistenceContext
	EntityManager em;
	

	@Override
	public List retriveTransaction() {

		int id=1011;
		
		Query q=em.createQuery("from Transaction s where s.sender="+id);
		
		return q.getResultList();
		

	}

	@Override
	public void addTransaction(Transaction t,double walletBalanceOfAccount) {
		Date dNow = new Date( );
	    
		//To set date in specific format
		SimpleDateFormat ft =new SimpleDateFormat ("hh:mm a',' E dd MMM yyyy");
	    String a=ft.format(dNow);
		t.setTime(ft.format(dNow));
		
		t.setSender(1011);
		
		Query query1=em.createQuery(" select a.accountId from Account a where a.userId="+1002);
        List l=query1.getResultList();
		t.getAc().setAccountId((int)l.get(0));
		
       
        Query query2=em.createQuery("UPDATE Account a SET a.walletBalance =" +walletBalanceOfAccount+"WHERE a.userId="+1002);
        query2.executeUpdate();
        
        Query query3=em.createQuery("UPDATE Account a SET a.walletBalance =" +walletBalanceOfAccount+"WHERE a.userId="+t.getReceiver());
        query2.executeUpdate();
      
		em.persist(t);
		
	}
	

	
	
	
}


