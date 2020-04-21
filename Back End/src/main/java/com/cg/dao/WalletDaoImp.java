package com.cg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.cg.entity.Account;
import com.cg.entity.Transaction;


@Repository
public class WalletDaoImp implements WalletDaoI
{

	@PersistenceContext
	EntityManager em;
	
	@Override
	public void create(Account acc) {
		
		em.persist(acc);
	}

	@Override
	public List retrive() {

		//select s.ac.accountId,s.sender 
		Query q=em.createQuery("from Transaction s");
		return q.getResultList();

	}

	@Override
	public void add(Transaction t) {
		em.persist(t);
	}
	
	@Override
	public List findById(int id) {
		
		//return em.find(Transaction.class, id);
		
		Query q=em.createQuery("from Transaction s where s.sender="+id);
		return q.getResultList();
	}
	
	
	
}


