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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="sprint_wallet_table")
public class WalletAccount {

	
	@Id
	@Column(name="WALLET_ID")
	private Long walletId;
	
//	@OneToOne
//	@JoinColumn(name="User_id")
//	private User userId;
	
	@Column(name="WALLET_BALANCE")
	private double walletBalance;
	
	
	@OneToMany(targetEntity = Transaction.class,mappedBy ="walletAccount" ,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonIgnore
    private Set<Transaction> transaction;
	
	

	

	public WalletAccount() {
		super();
	}





	public WalletAccount(Long walletId, double walletBalance, Set<Transaction> transaction) {
		super();
		this.walletId = walletId;
		this.walletBalance = walletBalance;
		this.transaction = transaction;
	}





	public Long getWalletId() {
		return walletId;
	}





	public void setWalletId(Long walletId) {
		this.walletId = walletId;
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

	
}
