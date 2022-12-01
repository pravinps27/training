package com.practice.day11;

import java.util.Scanner;

public class FascinatingNumber {

	public static void main(String[] args) {
		Scanner ps=new Scanner(System.in);
		int num1;
		int num2;
	
		System.out.println("Enter number:");
		int num=ps.nextInt();
		if(num>2) {
			
			num1=num*2;
			num2=num*3;
			
			String concatenate=num+""+num1+num2;	//concatenate all numbers
			
			boolean answer=true;
			
			for (char a='1'; a<'9';a++) 	//check digit present or not
			{
				int count=0;
				for(int i=0;i<concatenate.length();i++) 	//count each number digit
				{
					char ch=concatenate.charAt(i);
					if(ch==a) 		//compare character with concatenate
					{
						count++;
					}
				}
				if(count>1||count==0)	//check same character present
				{
					answer=false;
					
				}
				
			}
			if(answer) {
				System.out.println(num+"is a fascianting number");
			}
			else {
				System.out.println(num+"is not a fascianting number");
			}
		}
		else {
			System.out.println("Enter minimum 3 value!");
		}
		

	}

}
