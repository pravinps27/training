package com.practice.day13;

public abstract class AbstractionBank {
	
	public int accountNo(int num) {
		System.out.println("Account Number");
		return num;
	}
	
	public abstract  int loan() ;
		
	public abstract String accName();
}