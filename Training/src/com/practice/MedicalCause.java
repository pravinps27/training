package com.practice;

import java.util.Scanner;

public class MedicalCause {

	public static void main(String[] args) {

		Scanner ps = new Scanner(System.in);
		System.out.println("Enter number of class held:");
		System.out.println("Enter number of class attended");
		float held = ps.nextInt();
		float attended = ps.nextInt();
		float h = held;
		float a = attended;
		float percentage = (a / h) * 100;
		System.out.println("Percentage of attendance:" + percentage);
		/*
		 * if(responce=="yes") {
		 * System.out.println("Sorry due to medical cause you are not allowed"); } else
		 * if(responce=="no") { System.out.println(); }
		 */
		if (percentage <= 75.00) {
			System.out.println("Not allowed to exam your attendance is below 75%");
			
			System.out.println("Have you suffer from any medical cause?");
			System.out.println("Enter 'yes' or 'no' to answer:");
			String responce = ps.next();
			String yn=responce;
		
		
			if (responce.equals("yes")) {
					System.out.println("Submit your medical report and attent exam");
			
			}
					else if(responce.equals("no")) {
					System.out.println("You are not allowed to exam");
		} 
		}
		 else {
			 
			System.out.println("You are allowed to exam");
			
			
		 }
		}
		

	}

