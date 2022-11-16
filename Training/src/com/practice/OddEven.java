package com.practice;

import java.util.Scanner;

public class OddEven {

	public static void main(String[] args) {
		Scanner ps=new Scanner(System.in);
		
		System.out.println("Enter a Number:");
		int num=ps.nextInt();
		if(num%2==0) {
			System.out.println("Given Number "+num+" is Even");
			
		}
		else {
			System.out.println("Given Number "+num+" is Odd");
		}
	}

}
