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

@Transactional
@Service
public class WalletServiceImp implements WalletServiceI {

	@Autowired
	WalletDaoI wd;
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public void create(Account ac) {
		wd.create(ac);	
	}

	@Override
	public List retrive() {
		return wd.retrive();
	}

	@Override
	public void add(Transaction t) {
		Query q2=em.createQuery("select a.walletBalance from Account a where a.userId="+1002);
        List l1=q2.getResultList();
        
		if(em.find(User.class, 1002)==null)
			{
			  System.out.println("User Id is not valid");
			}
		else if((double)l1.get(0)>t.getAmount()) 
		{
	       double walletBalance=((double)l1.get(0))-t.getAmount();
	       wd.add(t,walletBalance);
	    }
		else
		{
			System.out.println("Insufficient Balance in your wallet to Transfer");
		}
		
			
	}

	@Override
	public List findById(int id) {
		return wd.findById(id);
	}

	
}
