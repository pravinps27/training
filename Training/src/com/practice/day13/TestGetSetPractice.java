package com.practice.day13;

import java.util.Scanner;

public class TestGetSetPractice {

	public static void main(String[] args) throws Exception {
		GetSetPractice bank=new GetSetPractice();
		Scanner ps=new Scanner(System.in);
		String ans;
		System.out.println("Enter account holder name:");
		String holderName=ps.next();
		bank.setName(holderName);
		do {
			
			System.out.println("1.Deposit\n2.Withdraw");
			int operation=ps.nextInt();
			switch(operation) {
			case 1:
				System.out.println("Enter amount to deposit:");
				int deposit=ps.nextInt();
				bank.setAmt(deposit);
				
				bank.deposit(bank.getAmt());
				
				System.out.println("Your available balance: Rs."+bank.balance());
				System.out.println("Enter amount to withdraw:");
				int withdrawl=ps.nextInt();
				bank.setAmt(withdrawl);
				bank.withdraw(bank.getAmt());
				System.out.println("Your available balance after withdraw:"+bank.balance());
				break;
			case 2:
				System.out.println("Enter amount to withdraw:");
				int withdraw=ps.nextInt();
				
				bank.withdraw(withdraw);
				System.out.println("Rs. "+bank.withdraw(withdraw)+"Withdraw successfully");
				System.out.println("Your available balance:"+bank.balance());
				break;
			default:
				System.out.println("Enter valid process!");
				
			}
			System.out.println("Do you want to continue?");
			ans=ps.next();
		}while(ans.equals("yes"));
		//System.out.println(bank.getName());

	}

}
