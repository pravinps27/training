package com.practice.day5;

import java.util.Scanner;

public class LeapYear {

	public static void main(String[] args) {
		Scanner ps=new Scanner(System.in);
		System.out.println("Enter the year:");
		int year=ps.nextInt();
		if(year%4==0) {
			System.out.println(year+" is a Leap Year");
			
		}
		else {
			System.out.println(year+" is Not a Leap Year");
		}

	}

}
