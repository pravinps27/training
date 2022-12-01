package com.practice.day13;

import java.util.Scanner;

public class TestAbstractionBank {

	public static void main(String[] args) {
		
		AbstractionBank1 bank=new AbstractionBank1();
		bank.accName();
		bank.loan();
		bank.accountNo(0);
		Scanner ps=new Scanner(System.in);
		
		System.out.println("Enter your name:");
		String name=ps.next();
		
		System.out.println("Enter your phone number:");
		Integer phone=ps.nextInt();
		
		String phoneNumber=Integer.toString(phone);
		
		if(phoneNumber.length()==10) {
			System.out.println(phoneNumber);

		}
		else {
			System.out.println("Not a  number");
		}
	}

}
