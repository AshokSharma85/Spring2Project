package com.cg.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="account2")
public class Account {

	@Id
	private int accountId;
	
	@OneToOne
	@JoinColumn
	private User userofbank;
	
	private int walletbalance;
	
	@JsonManagedReference
	@OneToMany(targetEntity = Transaction.class,mappedBy ="ac" ,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Transaction> transaction;
	
	
	
	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getWalletbalance() {
		return walletbalance;
	}

	public void setWalletbalance(int walletbalance) {
		this.walletbalance = walletbalance;
	}

	public Set<Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(Set<Transaction> transaction) {
		this.transaction = transaction;
	}

	public Account(int accountId, int walletbalance, Set<Transaction> transaction) {
		super();
		this.accountId = accountId;
		this.walletbalance = walletbalance;
		this.transaction = transaction;
	}

	public Account() {
		super();
	}

	public User getUserofbank() {
		return userofbank;
	}

	public void setUserofbank(User userofbank) {
		this.userofbank = userofbank;
	}

	
	
	
	
	
	
	
}
