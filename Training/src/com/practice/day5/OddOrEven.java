package com.practice.day5;

import java.util.Scanner;

public class OddOrEven {

	public static void main(String[] args) {
		
		Scanner ps = new Scanner(System.in);
		System.out.println("Enter the range of numbers:");
		int numbers = ps.nextInt();
		
		int arr[] = new int[numbers];
		System.out.println("Enter the numbers:");
		for (int i = 0; i < numbers; i++) {
			arr[i] = ps.nextInt();
		}
		for (int i = 0; i < numbers; i++) {

			if (arr[i] % 2 == 0) {
				System.out.println("Even Numbers are:" +arr[i]+"");
			}
		}
		for (int i = 0; i < numbers; i++) {
			if (arr[i] % 2 != 0) {
				System.out.println("Odd Numbers are:" + arr[i]+"");
			}
		}
	}

}
