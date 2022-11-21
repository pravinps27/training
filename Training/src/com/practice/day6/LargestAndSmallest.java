package com.practice.day6;

import java.util.Scanner;

public class LargestAndSmallest {

	public static void main(String[] args) {
		Scanner ps=new Scanner(System.in);
		System.out.println("Enter the array count:");
		int count=ps.nextInt();
		int arr[]=new int [count];
		System.out.println("Enter the numbers:");
		for(int i=0;i<arr.length;i++) {
			arr[i]=ps.nextInt();
		}
		int largest=arr[0];
		int smallest=arr[0];
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>largest)
				largest=arr[i];
			else if(arr[i]<smallest)
				smallest=arr[i];
		}
		System.out.println("Largest number in the array :"+largest);
		System.out.println("Smallest number in the array :"+smallest);
		
		
		
		
	}

}
