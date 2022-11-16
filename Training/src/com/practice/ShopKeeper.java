package com.practice;

import java.util.Scanner;

public class ShopKeeper {

	public static void main(String[] args) {
		
		Scanner ps=new Scanner(System.in);
		System.out.println("Welcome to Candy Shop");
		System.out.println("Each just $100 only");
		System.out.println("How many pieces you want?");
		int want=ps.nextInt();
		int price=want*100;
		
		if (want>=10) {
			System.out.println("Congrats you got 10% discount for purchasing $1000 above");
			int total=price-(price/100*10);
			System.out.println("Bill:"+total);
		}
		else {
			System.out.println("Bill:"+price);
		}

	}

}
