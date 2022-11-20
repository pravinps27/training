package com.practice.day6;

import java.util.Scanner;

public class SumAndProduct {

	public static void main(String[] args) {
		Scanner ps=new Scanner(System.in);
		System.out.println("Enter the a count of numbers:");
		int count=ps.nextInt();
		int arr1[]=new int[count];
		int sum=0,product=1;
		System.out.println("Enter the numbers:");
		for(int i=0;i<count;i++) {
			arr1[i]=ps.nextInt();
			sum=sum+arr1[i];
			product=product*arr1[i];
			
		}
		System.out.println("Sum of Array:"+sum);
		System.out.println("Sum of Array:"+product);
		
		

	}

}
