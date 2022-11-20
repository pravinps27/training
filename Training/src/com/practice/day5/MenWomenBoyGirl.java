package com.practice.day5;

import java.util.Scanner;

public class MenWomenBoyGirl {

	public static void main(String[] args) {
		Scanner ps=new Scanner (System.in);
		System.out.println("Enter the Gender 'Male' or 'female':");
		String gender=ps.next();
		System.out.println("Enter the age:");
		int age=ps.nextInt();
		if(gender.equals("male")&&age>=25) {
			System.out.println("Man");
		}
			else if(gender.equals("male")&&age<25) {
				System.out.println("Boy");		
			}
			else if(gender.equals("female")&&age>=20) {
				System.out.println("Women");
			}
			else if(gender.equals("female")&&age>20) {
				System.out.println("Girl");
			}
			else {
				System.out.println("Enter valid data!");
			}
			
			
			
		}
		
	}


