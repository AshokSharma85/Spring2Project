package com.cg.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.Account;
import com.cg.entity.Transaction;


@Repository
public interface WalletDaoI {

	public void create(Account acc);
	public List retrive();
	public void add(Transaction t);
	public List findById(int id);
	
}

