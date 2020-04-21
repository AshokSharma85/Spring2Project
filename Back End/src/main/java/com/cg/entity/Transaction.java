package com.cg.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="trans2")
public class Transaction {
	
	@Id
	private int transactionid;
	
	@Column
	private int sender;
	
	@Column
	private int receiver;
	
	@Column
	private double Amount;
	
	@Column
	private Date time;
	

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="account_id")
	private Account ac;
	
	
	
	
	



	public Transaction(int transactionid, int sender, int receiver, double amount, Date time, Account ac) {
		super();
		this.transactionid = transactionid;
		this.sender = sender;
		this.receiver = receiver;
		Amount = amount;
		this.time = time;
		this.ac = ac;
	}

	


	public Transaction() {
		super();
	}




	public int getTransactionid() {
		return transactionid;
	}

	
	
	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}


	

	public int getSender() {
		return sender;
	}



	public void setSender(int sender) {
		this.sender = sender;
	}



	public int getReceiver() {
		return receiver;
	}



	public void setReceiver(int receiver) {
		this.receiver = receiver;
	}



	public double getAmount() {
		return Amount;
	}



	public void setAmount(double amount) {
		Amount = amount;
	}



	public Account getAc() {
		return ac;
	}



	public void setAc(Account ac) {
		this.ac = ac;
	}
	
	
	
	
	

}
