package com.practice.day5;

import java.util.Scanner;

public class TwoLargeNumArray {

	public static void main(String[] args) {
		Scanner ps = new Scanner(System.in);
		System.out.println("Enter the Count Number in Array:");
		int count = ps.nextInt();
		int arr[] = new int[count];
		System.out.println("Enter the numbers:");

		for (int i = 0; i < arr.length; i++) {
			arr[i] = ps.nextInt();

		}
		int l1, l2, temp;

		l1 = arr[0];
		l2 = arr[1];

		if (l1 < l2) {
			temp = l1;
			l1 = l2;
			l2 = temp;
		}
		for (int i = 2; i < arr.length; i++) {
			if (arr[i] > l1) {
				l2 = l1;
				l1 = arr[i];
			} else if (arr[i] > l2&& arr[i] != l1 ) {
				l2 = arr[i];
			}
		}
		System.out.println("First largest number is:" + l1);
		System.out.println("Second largest number is:" + l2);
	}

}
