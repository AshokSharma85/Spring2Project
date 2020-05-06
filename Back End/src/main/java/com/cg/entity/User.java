package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

@Entity
@Table(name="sprint_user_table")
@Repository
public class User {

	@Id
	@Column(name="MOBILE_NUMBER")
	private Long mobileNumber;
	
	@Column(name="USER_NAME")
	private String userName;
	
	@Column(name="PASSWORD")
	private String password;

	public User() {
		super();
	}

	
	public User(Long mobileNumber, String userName, String password) {
		super();
		this.mobileNumber = mobileNumber;
		this.userName = userName;
		this.password = password;
	}


	

	public Long getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
}

