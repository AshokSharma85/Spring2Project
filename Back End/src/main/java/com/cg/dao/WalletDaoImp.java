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
	
	@Autowired
	User u;
	
	@Override
	public void create(Account acc) {
		
		em.persist(acc);
	}

	@Override
	public List retrive() {

		int id=1001;
		
		Query q=em.createQuery("from Transaction s where s.sender="+id);
		
		return q.getResultList();
		

	}

	@Override
	public void add(Transaction t,double walletBalanceOfAccount) {
		Date dNow = new Date( );
	    
		//To set date in specific format
		SimpleDateFormat ft =new SimpleDateFormat ("hh:mm a',' E dd MMM yyyy");
	    String a=ft.format(dNow);
		t.setTime(ft.format(dNow));
		
		t.setSender(1011);
		
		Query q1=em.createQuery(" select a.accountId from Account a where a.userId="+1002);
        List l=q1.getResultList();
		t.getAc().setAccountId((int)l.get(0));
		
		Query q2=em.createQuery("select a.walletBalance from Account a where a.userId="+1002);
        List l1=q2.getResultList();
        double walletBalance=((double)l1.get(0))-t.getAmount();
       
        Query q3=em.createQuery("UPDATE Account a SET a.walletBalance =" +walletBalance+"WHERE a.userId="+1002);
        q3.executeUpdate();
      
		em.persist(t);
		
	}
	
	@Override
	public List findById(int id) {

		System.out.println(em.find(Account.class, 2));
		
		Query q=em.createQuery("from Transaction s where s.sender="+id);  

		Query query = em.createQuery("FROM Account a where a.userId="+1002);
	      List<Account> resultList = query.getResultList();
	      System.out.println(resultList.get(0));
	      resultList.forEach(System.out::println);
		return q.getResultList();
	}
	
	
	
}


