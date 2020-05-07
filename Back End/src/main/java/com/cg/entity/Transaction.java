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
@SequenceGenerator(name="transactionIdGenerator", initialValue=144444444)
public class Transaction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="transactionIdGenerator")
	private int transactionId;
	
	@Column(name="MOBILE_NO_OF_SENDER")
	private Long sender;
	
	@Column(name="MOBILE_NO_OF_RECEIVER")
	private Long receiver;
	
	@Column(name="NAME_OF_RECEIVER")
	private String nameOfReceiver;
	
	@Column(name="AMOUNT")
	private double amount;
	
	@Column(name="DATE_OF_TRANSACTION")
	private String date;
	
	

	@ManyToOne
	@JoinColumn(name="WALLET_ID")
	@JsonBackReference
	private WalletAccount walletAccount=new WalletAccount();
	

	public Transaction(int transactionId, Long sender, Long receiver, String nameOfReceiver, double amount, String date,
			WalletAccount walletAccount) {
		super();
		this.transactionId = transactionId;
		this.sender = sender;
		this.receiver = receiver;
		this.nameOfReceiver = nameOfReceiver;
		this.amount = amount;
		this.date = date;
		this.walletAccount = walletAccount;
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





	

	public String getNameOfReceiver() {
		return nameOfReceiver;
	}




	public void setNameOfReceiver(String nameOfReceiver) {
		this.nameOfReceiver = nameOfReceiver;
	}




	public String getDate() {
		return date;
	}




	public void setDate(String date) {
		this.date = date;
	}




	public Long getSender() {
		return sender;
	}



	public void setSender(Long sender) {
		this.sender = sender;
	}



	public Long getReceiver() {
		return receiver;
	}



	public void setReceiver(Long receiver) {
		this.receiver = receiver;
	}



	public double getAmount() {
		return amount;
	}



	public void setAmount(double amount) {
		this.amount = amount;
	}




	public WalletAccount getWallet() {
		return walletAccount;
	}




	public void setWallet(WalletAccount walletAccount) {
		this.walletAccount = walletAccount;
	}



	
	
	
	

}
