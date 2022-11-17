package com.practice.day5;

import java.util.Scanner;

public class FizzBuzz {

	public static void main(String[] args) {
		Scanner ps=new Scanner(System.in);
		System.out.println("Enter the Number to play FizzBuzz:");
		int number=ps.nextInt();
		
		if((number%3==0)&&(number%5==0)) {
			System.out.println(number+" is FizzBuzz");
			}
			else if(number%5==0) {
				System.out.println(number+" is Buzz");
			}
			else if(number%3==0) {
				System.out.println(number+" is Fizz");	
			}	
			else {
				System.out.println(number);
			}
			
		}
	}


