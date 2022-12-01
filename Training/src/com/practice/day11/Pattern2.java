package com.practice.day11;

import java.util.Scanner;

public class Pattern2 {

	public static void main(String[] args) {
		Scanner ps=new Scanner(System.in);
		System.out.println("Enter the Number of row to print character:");
		int n=ps.nextInt();
		int i=0;
		int j=0;
		char alpha='A';		//declare a character starting from A
		for(i=0;i<n;i++) {		//no. of rows
			for(j=0;j<i+1;j++) {		//to print A
				System.out.print(alpha);
			}
			alpha++;		//move to next character
			System.out.println();
		}

	}

}
