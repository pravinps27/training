package com.practice.day11;

import java.util.Scanner;

public class Pattern3 {

	public static void main(String[] args) {
		Scanner ps=new Scanner(System.in);
		System.out.println("Enter the number:");
		int n=ps.nextInt();
		for (int i=1;i<n;i++) {		//no. of rows
			for(int j=n-i;j>1;j--) {		//no. of space
				System.out.print(" ");
				
			}
			for(int k=0;k<i;k++) {		//to print numbers
				System.out.print(i+" ");
			}
			System.out.println();
		}

	}

}
