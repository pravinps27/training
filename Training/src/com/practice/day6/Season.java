package com.practice.day6;

import java.util.Scanner;

public class Season {

	public static void main(String[] args) {
		
		Scanner ps=new Scanner(System.in);
		System.out.println("Enter the Month number:");
		int month=ps.nextInt();
		switch(month) {
		case 1,2,3:
			System.out.println("Spring Season");
		break;
		case 4,5,6:
			System.out.println("Summer Season");
		break;
		case 7,8,9:
			System.out.println("Monsoon Season");
		break;
		case 10,11,12:
			System.out.println("Winter Season");
		break;
		default:
			System.out.println("Enter valid month number:");
			break;
		}
	}

}
