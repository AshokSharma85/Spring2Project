package com.cg;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.dao.WalletDaoI;
import com.cg.entity.Account;
import com.cg.entity.Transaction;

@SpringBootApplication
public class EwalletProject  implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(EwalletProject.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*
     System.out.println("hello");
		
		Set s = new HashSet<Transaction>();
		
	
		Account ac = new Account();
		Date d=new Date();
		s.add(new Transaction(103,1001,1002,10000,d, ac));
		s.add(new Transaction(104,1001,1002,12000,d, ac));

		ac.setAccountId(3);
		ac.setWalletbalance(5033);
		ac.setTransaction(s);
		
		acc.create(ac);	*/	
		
	}

}
