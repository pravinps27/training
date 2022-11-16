package com.practice;

import java.util.Scanner;

public class ATM {

	public static void main(String[] args) {
		Scanner ps=new Scanner(System.in);
		System.out.println("Enter pin:");
		int pin=ps.nextInt();
		int balance=250000;
		
		if(pin==2233) {
			System.out.println("Welcome Pravin!");
			System.out.println("Choose operation:\n1)Withdrawal\t2)Check Balance");
			int x=ps.nextInt();
			switch(x) {
			case 1:
				System.out.println("Enter amount:");
				int debit=ps.nextInt();
				if(debit>250000) {
					System.out.println("Insuficient balance");
				}
				else {
				System.out.println("Debited Successfully\n Available balance"+(balance-debit));
				}
				break;
			case 2:
				System.out.println("Available balance:"+balance);
				break;
			default:
				System.out.println("Enter valid option.");
				break;
			}
				
				
			
			}
		else{
			System.out.println("Pin Invalid!");
		}
		}
		
	}


