package com.practice.day11;

import java.util.Scanner;

public class Pattern4 {

	public static void main(String[] args) {
		System.out.println("Enter count to print 1's 0's down Triangle pattern:");
		Scanner ps=new Scanner(System.in);
		int count=ps.nextInt();
		for(int i=0;i<=count-1;i++) 	//no.of rows
		{
			for(int j=0;j<=i;j++) 	//print space
			{
				System.out.print(" ");
			}
			for(int k=1;k<=count-1-i;k++) 	//to print 1's 0's
			{
				if(i%2==0) {
					System.out.print(0);
				}
				else
					System.out.print(1);
			}
			System.out.println();
		}

	}

}
