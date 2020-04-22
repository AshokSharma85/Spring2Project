package com.cg.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
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

		int id=10;
		Query q=em.createQuery("from Transaction s where s.sender="+id);
		return q.getResultList();

	}

	@Override
	public void add(Transaction t) {
		Date dNow = new Date( );
	    SimpleDateFormat ft =new SimpleDateFormat ("hh:mm a',' E dd MMM yyyy");
	    String a=ft.format(dNow);
		t.setTime(ft.format(dNow));
		t.setSender(1010);
		em.persist(t);
	}
	
	@Override
	public List findById(int id) {

		Query q=em.createQuery("from Transaction s where s.sender="+id);
		return q.getResultList();
	}
	
	
	
}


