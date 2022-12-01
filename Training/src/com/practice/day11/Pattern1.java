package com.practice.day11;

import java.util.Scanner;

public class Pattern1 {

	public static void main(String[] args) {
		Scanner ps=new Scanner(System.in);
		System.out.println("Enter the number of *:");
		int n=ps.nextInt();
		for(int i=0;i<n;i++) {	//no of rows
			for(int j=0;j<=i;j++) {		//to print *
				System.out.print("* ");
			}
			System.out.println();
		}

	}

}
