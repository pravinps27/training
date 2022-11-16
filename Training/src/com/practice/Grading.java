package com.practice;

import java.util.Scanner;

public class Grading {

	public static void main(String[] args) {
		
		Scanner ps=new Scanner(System.in);
		System.out.println("Enter your mark:");
		int mark=ps.nextInt();
		int g=mark;
		if(g<25) {
			System.out.println("Your grade is F");
			}
			else if((g>=25)&&(g<45)) {
				System.out.println("Your grade is E");}
			else if((g>=45)&&(g<50)) {
				System.out.println("Your grade is D");}
			else if((g>=50)&&(g<60)) {
				System.out.println("Your grade is C");}
			else if((g>=60)&&(g<80)) {
				System.out.println("Your grade is B");}
			else if((g>=80)&&(g<=100)) {
				System.out.println("Your grade is E");}
			else {
				System.out.println("Please enter valid mark");
			}				
			}
		
		
		
	}


