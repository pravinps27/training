package com.practice.day11;

public class GMFashion {
		public static void purchase(String name, int amount, int count) {
			System.out.println("your order: "+name+" is Rs."+amount);
			int total=amount*count;
			System.out.println("No. of "+name+" is-"+count);
			System.out.println("Your bill-"+total);
		}
		public  void purchase(String name, float amount, int count) {
			System.out.println("your order: "+name+" is Rs."+amount);
			float total=amount*count;
			System.out.println("No. of "+name+" is-"+count);
			System.out.println("Your bill-"+total);
		}
		public  void purchase(String name, float amount, float count) {
			System.out.println("your order: "+name+" is Rs."+amount);
			float total=amount*count;
			System.out.println("No. of "+name+" is-"+count);
			System.out.println("Your bill-"+total);
		}

}
