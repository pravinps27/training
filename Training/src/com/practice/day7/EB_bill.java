package com.practice.day7;

import java.util.Scanner;

public class EB_bill {

	public static void main(String[] args) {
		Scanner ps = new Scanner(System.in);
		System.out.println("TNEB");
		System.out.println("Enter User Name:");
		String userName = ps.next();

		boolean str = userName.matches("[a-zA-Z]+");
		if (str == true) {
			System.out.println("Enter consumer no. :");
			if (ps.hasNextInt()) {
				int consumerNumber = ps.nextInt();
				System.out.println("Enter Type of customer:");
				System.out.println("1. Domestic('D')\t2. Commercial('C')");
				char type = ps.next().charAt(0);
				if (type == 'd' || type == 'D') {
					System.out.println("Enter the Units Consumed:");
					int units = ps.nextInt();
					System.out.println("EB Bill..");
					if (units > 0 && units <= 100) {
						System.out.println("Rs.0");
						System.out.println("You have consumed below 100 units");
					}
					if(units > 101 && units <= 500) {
						System.out.println("Rs."+units*10);
						System.out.println("Unit cost Rs.10/unit \nYou have consumed between 101 to 500 units");
					}
					if(units > 501 && units <= 700) {
						System.out.println("Rs."+units*19);
						System.out.println("Unit cost Rs.19/unit \nYou have consumed between 501 to 700 units");
					}
					if(units > 701 && units <= 1000) {
						System.out.println("Rs."+units*30);
						System.out.println("Unit cost Rs.30/unit \nYou have consumed between 701 to 1000 units");
					}
					

				}
				else if(type == 'c' || type == 'C'){
					System.out.println("Enter the Units Consumed:");
					int units = ps.nextInt();
					System.out.println("EB Bill..");
					if (units > 0 && units <= 100) {
						System.out.println("coustomer name:"+userName);
						System.out.println("comsumer number:"+consumerNumber);
						System.out.println("Consumer Bill");
						
						System.out.println("Rs."+units*5);
						System.out.println("You have consumed below 100 units");
					}
					if(units > 101 && units <= 500) {
						System.out.println("coustomer name:"+userName);
						System.out.println("comsumer number:"+consumerNumber);
						System.out.println("Consumer Bill");
						System.out.println("Rs."+units*10);
						System.out.println("Unit cost Rs.10/unit \nYou have consumed between 101 to 500 units");
					}
					if(units > 501 && units <= 700) {
						System.out.println("coustomer name:"+userName);
						System.out.println("comsumer number:"+consumerNumber);
						System.out.println("Consumer Bill");
						System.out.println("Rs."+units*19);
						System.out.println("Unit cost Rs.19/unit \nYou have consumed between 501 to 700 units");
					}
					if(units > 701 && units <= 1000) {
						System.out.println("coustomer name:"+userName);
						System.out.println("comsumer number:"+consumerNumber);
						System.out.println("Consumer Bill");
						System.out.println("Rs."+units*30);
						System.out.println("Unit cost Rs.30/unit \nYou have consumed between 701 to 1000 units");
					}
					

				}
				else {
					System.out.println("Enter valid customer type!");
				}


			} 
			else {
				System.out.println("Enter valid Consumer Number!");
			}
		} else {
			System.out.println("User name invalid!");
		}
	}

}
