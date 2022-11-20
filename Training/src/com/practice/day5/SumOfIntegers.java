package com.practice.day5;

import java.util.Scanner;

public class SumOfIntegers {

	public static void main(String[] args) {
		Scanner ps = new Scanner(System.in);
		System.out.println("Enter the Number count:");
		int count = ps.nextInt();
		int n = 0;
		if (count > 1) {
			for (int i = 1; i <= count; i++) {
				System.out.println(i);
				n = n + i;
			}

			System.out.println("Sum of given numbers:" + n);
			

		} 
		else {
			System.out.println("Enter valid number");

		}

	}

}
