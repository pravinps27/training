package com.practice.day11;

import java.util.Arrays;
import java.util.Scanner;

public class AdjacentOf2Numbers {

	public static void main(String[] args) {
		Scanner ps=new Scanner(System.in);
		System.out.println("Enter the No. of Numbers to find product:");
		int count=ps.nextInt();
		int arr[]=new int[count];
		System.out.println("Enter the numbers:");
		for(int i=0;i<arr.length;i++) {
			arr[i]=ps.nextInt();
		}
		Arrays.sort(arr);	//Sort the given array
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		
		//declare two smallest array value
		int small1=arr[0];		
		int small2=arr[1];
		
		//declare two largest array value
		int large1=arr[arr.length-1];
		int large2=arr[arr.length-2];
		
		//calculate product value of smallest and largest value
		int product1=arr[0]*arr[1];
		int product2=arr[arr.length-1]*arr[arr.length-2];
		
		if(product2>=product1) {
			int adjacent1=arr[arr.length-1], adjacent2=arr[arr.length-2];
			
			System.out.println("Maximum product is: "+adjacent1+", "+adjacent2+"= "+adjacent1*adjacent2);
		}
		else {
			int adjacent1=arr[0], adjacent2=arr[1];
			System.out.println("Maximum product is: "+adjacent1+", "+adjacent2+"= "+adjacent1*adjacent2);
			
		}
		
		

	}

}
