package com.practice;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner ps=new Scanner(System.in);
		
		System.out.println("Calculator");
		System.out.println("Enter Number:");
		int num1=ps.nextInt();
		int num2=ps.nextInt();
		System.out.println("Enter Operation:");
		char x=ps.next().charAt(0);
		char y=x;
		switch(y) {
		case '+':
			System.out.println("Addition of two number is:"+(num1+num2));
			break;
		
		case '-':
			System.out.println("Subtration of two number is:"+(num1-num2));
			break;
			
		case '%':
			System.out.println("Percentage of two number is:"+(num1%num2));
			break;
			
		case '/':
			System.out.println("Division of two number is:"+(num1/num2));
			break;
		
		case '*':
			System.out.println("Multiplication of two number is:"+(num1*num2));
			break;
			
		default:
			System.out.println("Enter valid number");
		
		}
	}

}
