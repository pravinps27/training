package com.practice.day6;

import java.util.Scanner;

public class ReverseArray {

	public static void main(String[] args) {
		Scanner ps = new Scanner(System.in);
		System.out.println("Enter the Numbers count:");
		int count = ps.nextInt();
		int arr[] = new int[count];
		int arr2[] = new int[arr.length];
		System.out.println("Enter the Numbers:");
		for (int i = 0; i < count; i++) {
			arr[i] = ps.nextInt();

		}
		for (int i = 0; i < arr.length; i++) {
			arr2[i] = arr[i];
		}
		
		
		System.out.println("Reverse Array:");
		for (int i = arr.length - 1; i >= 0; i--) {

			System.out.println(arr[i] + " ");
		}

	}
}
