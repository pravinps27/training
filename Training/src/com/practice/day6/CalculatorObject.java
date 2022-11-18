package com.practice.day6;

public class CalculatorObject {

	public static void main(String[] args) {
		addition();
		subtraction();
		division();

	}
	public static void addition() {
		int num1=10;
		int num2=20;
		System.out.println("Sum of 10 and 20 is:"+(num1+num2));
	}
	public static void subtraction() {
		int num1=10;
		int num2=20;
		System.out.println("Difference of 10 and 20 is:"+(num1-num2));
	}
	public static void division() {
		int num1=10;
		int num2=20;
		System.out.println("Division of 10 and 20 is:"+(num1/num2));
		}

}
