package com.practice;

import java.util.Scanner;

public class Square {

	public static void main(String[] args) {
		Scanner ps=new Scanner(System.in);
		System.out.println("Enter the length:");
		float length=ps.nextFloat();
		System.out.println("Enter the breath:");
		float breath=ps.nextFloat();
		if(length==breath) {
			System.out.println("It is a Square");
		}
		else {
			System.out.println("It is not a Square");
		}
	}

}
