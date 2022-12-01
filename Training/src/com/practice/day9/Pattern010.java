package com.practice.day9;

public class Pattern010 {

	public static void main(String[] args) {
		int n=4;
		for(int i=0;i<n;i++)	// no. of rows
		{
			for(int j=i;j<4;j++)		//no. of space in a line
			{
				System.out.print(" ");
				
			}
		for(int j=4;j<=n;j--)
		{
			System.out.print("1 ");
		}
		System.out.println();
		}
		
	}

}
