package com.practice;

import java.util.Scanner;

public class LoanCalculator {

	public static void main(String[] args) {
		Scanner ps=new Scanner(System.in);
		System.out.println("Enter loan amount:");
		int loan=ps.nextInt();
		
		System.out.println("Enter interest:");
		int rate=ps.nextInt();
		
		System.out.println("EMI period:");
		int year=ps.nextInt();
		
		int interest=((loan/100)*rate);//1000
		//System.out.println(interest);
		int totalInterest=(year/12)*interest;//5000
		System.out.println("Total Interest:"+totalInterest);
		int totalAmount=loan+totalInterest;//15000
		System.out.println("Total amount to be pay:"+totalAmount);
		int emi=totalAmount/year; //250
		//System.out.println(interest);
		//int emi=total/year;
		
		for(int i =totalAmount;i>=0;) {
			System.out.println(i);
			i=i-emi;
			//int balance=loan-payment; //1000 to 9000
			//loan=balance; //9000
			
		}
		
	}
}


