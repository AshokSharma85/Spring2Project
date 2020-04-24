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
		// where s.sender="+id
		Query q=em.createQuery("from Transaction s");
		
		return q.getResultList();
		

	}

	@Override
	public void add(Transaction t) {
		Date dNow = new Date( );
	    
		//To set date in specific format
		SimpleDateFormat ft =new SimpleDateFormat ("hh:mm a',' E dd MMM yyyy");
	    String a=ft.format(dNow);
		t.setTime(ft.format(dNow));
		
		t.setSender(1011);
		
		Query q1=em.createQuery(" select a.accountId from Account a where a.userId="+1002);
        List l=q1.getResultList();
		t.getAc().setAccountId((int)l.get(0));
		//System.out.println(em.find(Account.class, 2));
		
		/*Query q2=em.createQuery("select a.walletbalance from Account a where a.userofbank="+2);
        List l1=q2.getResultList();
        double walletBalance=((double)l1.get(0))-t.getAmount();
        System.out.println(walletBalance);
        t.getAc().setWalletbalance(walletBalance);
        System.out.println(t.getAc().getTransaction());*/
       
        
        
       /* Query q3=em.createQuery("update Account a set a.walletbalance="+walletBalance+"where a.userofbank="+2);
        System.out.println(q3.toString());
        */
        
        //em.persist(q3);
       // em.persist("update Account a set u.walletBalance="+walletBalance);
        
		em.persist(t);
		
	}
	
	@Override
	public List findById(int id) {

		Query q=em.createQuery("from Transaction s where s.sender="+id);  
		
		/*Account a=em.find(Account.class,150);
		if(a==null)
		{
			System.out.println("NoT valid");
		}
		else
		{
			System.out.println("Present");
		}
		JPa Inbuild FUnctions
		*/
		System.out.println("Data are"+em.find(Account.class, 2));
		return q.getResultList();
	}
	
	
	
}


