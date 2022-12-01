package com.practice.day9;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.transform.Source;

public class TrainBooking {

	public static void main(String[] args) {
		Scanner ps=new Scanner(System.in);
		//userData();
		
		String name;
		String email;
		//String startingPoint;
		//Scanner ps=new Scanner(System.in);
		System.out.println("\t \t ***Training Ticket Booking***");
		System.out.println("Enter your name?");
		name=ps.next();
		String regex="^(.+)@(.+)$";
		Pattern pattern=Pattern.compile(regex);
		if(name.matches("[a-zA-Z]+")) {
			System.out.println("Enter your email:");
			email=ps.next();
			Matcher matcher=pattern.matcher(email);
			if(matcher.matches()==true) {
				//System.out.println("valid");
		//	System.out.println("Enter Starting point:");
			//String startingPoint=ps.next();
				source(null);		//calling source method
				
				destination(null);		//calling destination method
				
				date(0, 0);		//calling date method
				
				
				System.out.println();
				
			}
			else {
				System.out.println("Enter valid email!");
			}
		}
		else {
			System.out.println("Enter valid name!");
		}
	}
	public static void source(String startingPoint) {
		Scanner ps=new Scanner(System.in);
		System.out.println("Enter your Starting Point:");
		if(ps.hasNext("[a-zA-Z]+")) {
		startingPoint=ps.next();
		System.out.println("Your Starting Point:"+startingPoint);
		//destination("null");
		}
		else {
		System.out.println("Enter valid City!");
		}
		
			
		
	}
	public static void destination(String destination) {
		Scanner ps=new Scanner(System.in);
		do {
			
			System.out.println("Enter your destination Point:");
			if(ps.hasNext("[a-zA-Z]+")) {
				destination=ps.next();
				//source(null);
				
				System.out.println("Your Destination point: "+destination);
				//destination("null");
			}
			else {
				System.out.println("Enter valid City!");
			}
		}while(destination==ps.hasNext("[a-zAZ]+"));
		
		
	}
	public static void date(int startDate, int endDate) {
		Scanner ps=new Scanner(System.in);
		System.out.println("Journey start date:");
		if(ps.hasNextInt()) {
		startDate=ps.nextInt();
		}
		else {
			System.out.println("Enter valid date!");
		}
		System.out.println("Journey end date:");
		if(ps.hasNextInt()) {
			endDate=ps.nextInt();
			
			System.out.println("**********************************************************");
			System.out.println("Your ticket is booked!");
			System.out.println("Cost Rs.450");
			System.out.println("Train name- Pallavan Express No.23INC4567");
		}
		else {
			System.out.println("Journey end date:");
			
		}
		
		
		
	}
	

}
