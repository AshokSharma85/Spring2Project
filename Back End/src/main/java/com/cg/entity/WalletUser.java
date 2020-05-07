package com.cg.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="sprint_login_user")
@SequenceGenerator(name="user_seq", initialValue=444444)
public class WalletUser {
	
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="user_seq")
	private int userID;
	
	@NotEmpty(message="username is mandatory")
	@Size(min=3, max=20, message="length can be between 3 and 20")
	@Pattern(regexp="([A-Za-z]+)|([A-Za-z]+[ ][A-Za-z]+)", message=": Only alphabets and one space is allowed")
	private String userName;
	
	@NotEmpty(message="password is mandatory")
	@Pattern(regexp="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,14}$", message=": Password must contain one number,one alphabet,one special character and size should be at least 8 and not more than 14 characters")
	private String password;
	
	@Column(unique = true)
	@Pattern(regexp="[1-9][0-9]{9}", message=": Phone number must contain 10 digits")
	@Id
	private String phoneNumber;
	
	@Column
	@NotEmpty(message="email id is mandatory")
	@Email
	private String email;	
	
	
	

	public WalletUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public WalletUser(String userName, String password, String phoneNumber, String email) {
		super();
		this.userName = userName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	@Override
	public String toString() {
		return "WalletUser [userID=" + userID + ", userName=" + userName + ", password=" + password + ", phoneNumber="
				+ phoneNumber + ", email=" + email + "]";
	}

	
	
	

	
	
	
}
