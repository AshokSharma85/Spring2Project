package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="sprint_transaction_table")
@SequenceGenerator(name="seq", initialValue=144444444)
public class Transaction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	private int transactionId;
	
	@Column
	private int sender;
	
	@Column
	private int receiver;
	
	@Column
	private double amount;
	
	@Column
	private String time;
	

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="account_id")
	private Account ac=new Account();
	
	


	


	public Transaction(int transactionId, int sender, int receiver, double amount, String time, Account ac) {
		super();
		this.transactionId = transactionId;
		this.sender = sender;
		this.receiver = receiver;
		this.amount = amount;
		this.time = time;
		this.ac = ac;
	}




	public Transaction() {
		super();
	}



	public int getTransactionId() {
		return transactionId;
	}




	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}




	public String getTime() {
		return time;
	}

	public void setTime(String time) {
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
		return amount;
	}



	public void setAmount(double amount) {
		this.amount = amount;
	}



	public Account getAc() {
		return ac;
	}



	public void setAc(Account ac) {
		this.ac = ac;
	}
	
	
	
	
	

}
