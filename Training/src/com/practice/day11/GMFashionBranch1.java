package com.practice.day11;

public class GMFashionBranch1 extends GMFashion {
	public  static void purchase(String name, int amount, int count) {
		System.out.println("your order: "+name+" is Rs."+amount);
		int total=amount*count;
		float discount=total-100;
		System.out.println("No. of "+name+" is-"+count);
		System.out.println("Your bill-"+total);
		System.out.println("Your bill with discount-"+discount);
	}
	

}
