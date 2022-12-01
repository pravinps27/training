package com.practice.day13;

import java.util.Scanner;

public class TestLibrary {

	public static void main(String[] args) throws Exception {
		Library lib = new Library();
		Scanner ps = new Scanner(System.in);
		String ans;
		String reply;
		int rDate;
		//do {

			System.out.println("Enter Book name to search:");
			String bName = ps.nextLine();
			lib.setName(bName);
			//boolean bbName=bName.matches("[a-zA-Z]+");
			lib.validation();	//validate the BookName
			if(lib.validation()) {
				
				switch (bName) {
				case "data structure":
					System.out.println();
					System.out.println("\t**Book Details**");
					System.out.println("Book " + bName + " is available!");
					System.out.println("Author name: Dr.J.Gokul");
					System.out.println("Published on 2010");
					System.out.println("Do you want to read or lend?");
					ans = ps.next();
					if (ans.equals("lend")) {
						System.out.println(bName + " book is issued on 1 dec 2022, kindly return within 7 days.");
						System.out.println(
								"---------------------------------------------------------------------------------------------");
						System.out.println();
						System.out.println("Welcome back...");
						System.out.println("Returning date:");
						rDate = ps.nextInt();
						lib.setReturnDate(rDate);
						if (rDate > 0 && rDate < 30) {
							lib.date(lib.getReturnDate());
							if (rDate > 7) {
								
								System.out.println("You returned " + lib.date(rDate)
								+ " days late, penalty for late return Rs." + lib.fain(rDate));
							} else {
								System.out.println("Thank you, Visit again!");
							}
						} else {
							System.out.println("Enter valid date");
						}
					} else {
						System.out.println("Enjoy your reading time, kindly keep silent reading.");
					}
					break;
				case "java script":
					System.out.println();
					System.out.println("\t**Book Details**");
					System.out.println("Book " + bName + " is available!");
					System.out.println("Author name: Dr.V.Samuel");
					System.out.println("Published on 2012");
					System.out.println("Do you want to read or lend?");
					ans = ps.next();
					if (ans.equals("lend")) {
						System.out.println(bName + " book is issued on 1 dec 2022, kindly return within 7 days.");
						System.out.println(
								"-----------------------------------------------------------------------------------");
						System.out.println();
						System.out.println("Welcome back...");
						System.out.println("Returning date:");
						rDate = ps.nextInt();
						lib.setReturnDate(rDate);
						if (rDate > 0 && rDate < 30) {
							lib.date(lib.getReturnDate());
							if (rDate > 7) {
								
								System.out.println("You returned " + lib.date(rDate)
								+ " days late, penalty for late return Rs." + lib.fain(rDate));
							} else {
								System.out.println("Thank you, Visit again!");
							}
						} else {
							System.out.println("Enter valid date");
						}
					} else {
						System.out.println("Enjoy your reading time, kindly keep silent reading.");
					}
					break;
				default:
					System.out.println(bName + " book is not availbale!");
					break;
					
				}
				//System.out.println("Do you want to Search again?");
				//reply = ps.next();
				//} while (reply.equals("yes"));
			}
			else {
				System.out.println("Enter correct spelling!");
			}
	}
	
}
