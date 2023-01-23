package com.chainsys.project.NGO;

public class Account {
	Long accountNo;
	String holderName;
	Float balance;
	
	//constructor
	
	public Account() {
		
	}
	public Account(Long accountNo, String holderName, Float balance) {
		super();
		this.accountNo = accountNo;
		this.holderName = holderName;
		this.balance = balance;
	}
	
	//getter and setters
	public Long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public Float getBalance() {
		return balance;
	}
	public void setBalance(Float balance) {
		this.balance = balance;
	}
	
	//toString
	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", holderName=" + holderName + ", balance=" + balance + "]";
	}
	
	
	
	
}
