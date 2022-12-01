package com.practice.day12;

import java.util.Scanner;

public class TestBank {

	public static void main(String[] args) {
		Bank b1=new Bank();
		Scanner ps=new Scanner(System.in);
		System.out.println("Enter your name:");
		String uname=ps.next();
		b1.setUserName(uname);
		System.out.println("Enter your pin:");
		int upasscode=ps.nextInt();
		b1.setTxPassword(upasscode);
		System.out.println(b1.getUserName());
		System.out.println(b1.getTxPassword());
	}

}
