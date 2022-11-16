package com.practice;

import java.util.Scanner;

public class Attendance {

	public static void main(String[] args) {
		
		Scanner ps=new Scanner(System.in);
		System.out.println("Enter number of class held:");
		System.out.println("Enter number of class attended");
		float held=ps.nextInt();
		float attended=ps.nextInt();
		float h=held;
		float a=attended;
		float percentage=(a/h)*100;
		System.out.println("Percentage of attendance:"+percentage);
		if(percentage>=75.00) {
			System.out.println("You are allowed to exam");
		}
		else {
			System.out.println("Not allowed to exam your attendance is below 75%");
		}
		
	}

}
