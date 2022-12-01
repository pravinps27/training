package com.practice.day11;

public class Candy {

	
	public static void buy(int amount, String name, int count ) {
		System.out.println("Your order"+name+"is Rs."+amount);
		int total=amount*count;
		System.out.println(" Your Bill "+total);
	}
	public  void buy(float amount, String name, int count) {
		System.out.println("Your order"+name+"is Rs."+amount);
		float total=amount*count;
		System.out.println(" Your Bill "+total);
		
	}
	public  void buy(int amount, String name, float count) {
		System.out.println("Your order"+name+"is Rs."+amount);
		float total=amount*count;
		System.out.println(" Your Bill "+total);
		
	}
	
}
