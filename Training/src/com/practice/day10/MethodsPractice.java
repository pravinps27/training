package com.practice.day10;

import java.util.Scanner;

public class MethodsPractice {

	public static void main(String[] args) {
		Scanner ps=new Scanner(System.in);
		verification();
		//validation();
		work();
		//again();
		System.out.println("How many days to complete?");
		int day=ps.nextInt();
		System.out.println("put notes");
		String notes=ps.next();
		days(day,notes);
		
		
		
	}
	public static void verification() {
		Scanner ps=new Scanner(System.in);
		System.out.println("\t \t Welcome");
		System.out.println("Enter your name?");
		String name=ps.next();
		System.out.println("your Id?");
		int id=ps.nextInt();
		//validation();
		System.out.println("Aunthentication verified!");
	}
	public static void work() {
		Scanner ps=new Scanner(System.in);
		System.out.println("List of tasks:");
		System.out.println("1.Create method \n2.Reporting to client\n3.Design FrontEnd");
		int task=ps.nextInt();
		switch(task) {
		case 1:
			System.out.println("Go to eclipes and create new project");
			break;
		case 2:
			System.out.println("Go to meet and explain project to client");
			break;
		case 3:
			System.out.println("Go to Figma and make design");
			break;
		default:
			System.out.println("You have only 3 tasks");
				
				
				
			
			
		}
			
		}
	public static void again() {
		Scanner ps=new Scanner(System.in);
		String ans;
		do {
			verification();
			work();
			System.out.println("Check next task?");
			ans=ps.next();
		}
		while(ans=="yes");
	}
	
	public static void validation() {
		Scanner ps=new Scanner(System.in);
		 while(ps.hasNextInt()) {
			 verification();
		 }
			 
		 
	}
	public static void days(int day, String notes) {
		Scanner ps=new Scanner(System.in);
		//System.out.println("How many days to complete?");
		 day=ps.nextInt();
		 System.out.println(day);
		// System.out.println("put notes");
		 notes=ps.next();
		 System.out.println(notes);
		
	}
}
