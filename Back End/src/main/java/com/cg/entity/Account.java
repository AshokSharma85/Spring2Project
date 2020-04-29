package com.cg.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="sprint_account_table")
public class Account {

	@Id
	@Column(name="account_id")
	private int accountId;
	
	/*@Id
	@Column(name="wallet_id")
	private int walletId;*/
	
	@OneToOne
	@JoinColumn(name="User_id")
	private User userId;
	
	@Column(name="wallet_balance")
	private double walletBalance;
	
	@JsonManagedReference
	@OneToMany(targetEntity = Transaction.class,mappedBy ="ac" ,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Transaction> transaction;
	
	

	

	public Account() {
		super();
	}





	public Account(int accountId, User userId, double walletBalance, Set<Transaction> transaction) {
		super();
		this.accountId = accountId;
		this.userId = userId;
		this.walletBalance = walletBalance;
		this.transaction = transaction;
	}





	public int getAccountId() {
		return accountId;
	}





	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}





	public User getUserId() {
		return userId;
	}





	public void setUserId(User userId) {
		this.userId = userId;
	}





	public double getWalletBalance() {
		return walletBalance;
	}





	public void setWalletBalance(double walletBalance) {
		this.walletBalance = walletBalance;
	}





	public Set<Transaction> getTransaction() {
		return transaction;
	}





	public void setTransaction(Set<Transaction> transaction) {
		this.transaction = transaction;
	}





	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", walletBalance=" + walletBalance + "]";
	}





	

	
	
	
}
