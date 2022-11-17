package com.practice.day5;

import java.util.Scanner;

public class FibonacciSeries {

	public static void main(String[] args) {
		int a=0,b=1,c;
		Scanner ps=new Scanner(System.in);
		System.out.println("Enter the count of Fibonacci Series:");
		int count=ps.nextInt();
		
		for(int i=1;i<=count;i++) {
			System.out.println(a);
			
			c=b;
			b=a;
			a=b+c;
			
			
			
		
		}
	}

}
