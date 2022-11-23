package com.practice.day8;

import java.util.Scanner;

public class GSTBillTest {
	

	public static void main(String[] args) {
		Scanner ps = new Scanner(System.in);
		System.out.println("\t \t **Welcome to PS Mall**");
		int billNo=1;
		int total1=0;
		int total2=0;
		int total3=0;
		
		//billNo=billNo+1;
		//++billNo;
		System.out.println("Bill Number: "+billNo+"\t \t \t \t   GST No.GSTS12442");
		System.out.println("------------------------------------------------------------");
		String ans;
		String rply;
		System.out.println("Enter your name:");
		String name = ps.next(); // get user name
		Boolean uname = name.matches("[a-zA-Z]+"); // validate user name as only letter
		//do {
		if (uname == true) // loop start if only letter
			{
				System.out.println("Categories:");
				System.out.println("1. Food");
				System.out.println("2. Groceries");
				System.out.println("3. Cloth");
				System.out.println("4. Furniture");
				if (ps.hasNextInt()) {

					int categories = ps.nextInt();
					if (categories > 0) {
						switch (categories) {	//switch starts
						case 1: {
							
							do {
								
								System.out.println("Food List:");
								System.out.println("1. Idly-Rs.20");
								System.out.println("2. Dosa-Rs.40");
								System.out.println("3. Puuri-Rs.55");
								if (ps.hasNextInt()) {
									int foodList = ps.nextInt();
									if (foodList > 0&&foodList<=3) {
										if (foodList == 1) {
											System.out.println("How many idly you ordered:");
											if (ps.hasNextInt()) {
												int orderCount=ps.nextInt();
												if(orderCount>0) {
													
													System.out.println("Idly- "+orderCount);
													total1=orderCount*20;		//total ordered amount
													System.out.println("Total=Rs."+total1);	//print order amount
													//System.out.println("GST 5%");
													//float billAmount=(total1+((total1)*5/100));//bill amount
													//System.out.println("Bill Amount="+billAmount);
													int coupon=(int)((float)Math.random()*100);
													//System.out.println("Coupon id:"+coupon);
													//System.out.println("**Thank you visit again**");
												}
												else {
													System.out.println("Kindly give positive count");
												}
												
												
												
											} else {
												System.out.println("Enter valid count!");
											}
											
										}
										if(foodList == 2) {
											System.out.println("How many Dosa you ordered:");
											if (ps.hasNextInt()) {
												int orderCount=ps.nextInt();
												if(orderCount>0) {
													
													System.out.println("Dosa- "+orderCount);
													total2=orderCount*40;		//total ordered amount
													System.out.println("Total=Rs."+total2);	//print order amount
													//System.out.println("GST 5%");
													//float billAmount=(total2+((total2)*5/100));//bill amount
													//System.out.println("Bill Amount="+billAmount);
													int coupon=(int)((float)Math.random()*100);
													//System.out.println("Coupon id:"+coupon);
													//System.out.println("**Thank you visit again**");
												}
												else {
													System.out.println("Kindly give positive count");

												}
												
												
												
											} else {
												System.out.println("Enter valid count!");
											}
											
										}
										if(foodList == 3) {
											System.out.println("How many puuri you ordered:");
											if (ps.hasNextInt()) {
												int orderCount=ps.nextInt();
												if(orderCount>0) {
													
													System.out.println("Puuri- "+orderCount);
													total3=orderCount*55;		//total ordered amount
													System.out.println("Total=Rs."+total3);	//print order amount
													//System.out.println("GST 5%");
													//float billAmount=(total3+((total3)*5/100));//bill amount
													//System.out.println("Bill Amount="+billAmount);
													int coupon=(int)((float)Math.random()*100);
													//System.out.println("Coupon id:"+coupon);
													//System.out.println("**Thank you visit again**");
												}
												else {
													System.out.println("Kindly give positive count");

												}
												
												
												
											} else {
												System.out.println("Enter valid count!");
											}
											
										}
										
									} 
									
									else {
										System.out.println("Please choose only above list!");
									}
								} 
								else {
									System.out.println("Please enter only valid list!");
									
								}
								System.out.println("Do you want add more?");
								rply=ps.next();
							}
							while(rply.equals("yes"));
							System.out.println("------------------------------------------------------------");

							System.out.println("GST 5%");
							int total=(total1+total2+total3);		//total of amount
							System.out.println("Total Amount=Rs."+total);
							float billAmount=(total+((total)*5/100));		//GST calculation
							System.out.println("Bill Amount=Rs."+billAmount);
							
							break;
						}//case 1 end
						case 2:{	//groceries categories
							do {
								
								System.out.println("Groceries List:");
								System.out.println("1. Sugar-Rs.40/Kg");
								System.out.println("2. Dhal-Rs.60/Kg");
								System.out.println("3. Rice-Rs.80/Kg");
								if (ps.hasNextInt()) {
									int groceriesList = ps.nextInt();
									if (groceriesList > 0) {
										if (groceriesList == 1) {
											System.out.println("Sugar how many Kg you ordered:");
											if (ps.hasNextInt()) {
												int orderCount=ps.nextInt();
												if(orderCount>0) {
													
													System.out.println("Sugar-"+orderCount+"Kg");
													total1=orderCount*40;		//total ordered amount
													System.out.println("Total=Rs."+total1);	//print order amount
													//System.out.println("GST 18%");
													//float billAmount=(total1+((total1)*18/100));//bill amount
													//System.out.println("Bill Amount="+billAmount);
													int coupon=(int)((float)Math.random()*100);
													//System.out.println("Coupon id:"+coupon);
													//System.out.println("**Thank you visit again**");
												}
												else {
													System.out.println("Kindly give positive count");

												}
												
												
											} else {
												System.out.println("Enter valid count!");
											}
											
										}
										if(groceriesList == 2) {
											System.out.println("Dhal how many Kg you ordered:");
											if (ps.hasNextInt()) {
												int orderCount=ps.nextInt();
												if(orderCount>0) {
													
													System.out.println("Dhal-"+orderCount+"Kg");
													total2=orderCount*60;		//total ordered amount
													System.out.println("Total=Rs."+total2);	//print order amount
													//System.out.println("GST 18%");
													//float billAmount=(total2+((total2)*18/100));//bill amount
													//System.out.println("Bill Amount="+billAmount);
													int coupon=(int)((float)Math.random()*100);
													//System.out.println("Coupon id:"+coupon);
													//System.out.println("**Thank you visit again**");
												}
												else {
													System.out.println("Kindly give positive count");

												}
												
												
											} else {
												System.out.println("Enter valid count!");
											}
											
										}
										if(groceriesList == 3) {
											System.out.println("Rice how many Kg you ordered:");
											if (ps.hasNextInt()) {
												int orderCount=ps.nextInt();
												if(orderCount>0) {
													
													System.out.println("Rice-"+orderCount+"Kg");
													total3=orderCount*80;		//total ordered amount
													System.out.println("Total=Rs."+total3);	//print order amount
													//System.out.println("GST 18%");
													//float billAmount=(total3+((total3)*18/100));//bill amount
													//System.out.println("Bill Amount="+billAmount);
													int coupon=(int)((float)Math.random()*100);
													//System.out.println("Coupon id:"+coupon);
													//System.out.println("**Thank you visit again**");
												}
												else {
													System.out.println("Kindly give positive count");

												}
												
												
												
											} else {
												System.out.println("Enter valid count!");
											}
											
										}
										
									} else {
										System.out.println("Please choose only above list!");
									}
								} else {
									System.out.println("Please enter only valid list!");
								}
								System.out.println("Do you want add more?");
								rply=ps.next();
							}
							while(rply.equals("yes"));
							System.out.println("------------------------------------------------------------");

							System.out.println("GST 18%");
							int total=(total1+total2+total3);
							System.out.println("Total Amount=Rs."+total);
							float billAmount=(total+((total)*18/100));
							System.out.println("Bill Amount=Rs."+billAmount);
							
							
						}	//case 2 end
						break;
						
						case 3:{	//Cloths categories
							do {
								
								System.out.println("Cloth List:");
								System.out.println("1. Shirt-Rs.700");
								System.out.println("2. Phant-Rs.1200");
								System.out.println("3. Blazer jacket-Rs.2000");
								if (ps.hasNextInt()) {
									int clothsList = ps.nextInt();
									if (clothsList > 0) {
										if (clothsList == 1) {
											System.out.println("How many shirt you ordered:");
											if (ps.hasNextInt()) {
												int orderCount=ps.nextInt();
												if(orderCount>0) {
													
													System.out.println("Shirt-"+orderCount);
													total1=orderCount*700;		//total ordered amount
													System.out.println("Total=Rs."+total1);	//print order amount
													//System.out.println("GST 12%");
													//float billAmount=(total1+((total1)*12/100));//bill amount
													//System.out.println("Bill Amount="+billAmount);
													int coupon=(int)((float)Math.random()*100);
													//System.out.println("Coupon id:"+coupon);
													//System.out.println("**Thank you visit again**");
												}
												else {
													System.out.println("Kindly give positive count");

												}
												
												
											} else {
												System.out.println("Enter valid count!");
											}
											
										}
										if(clothsList == 2) {
											System.out.println("How many phant you ordered:");
											if (ps.hasNextInt()) {
												int orderCount=ps.nextInt();
												if(orderCount>0) {
													
													System.out.println("Phant-"+orderCount);
													total2=orderCount*1200;		//total ordered amount
													System.out.println("Total=Rs."+total2);	//print order amount
													//System.out.println("GST 12%");
													//float billAmount=(total2+((total2)*12/100));//bill amount
													//System.out.println("Bill Amount="+billAmount);
													int coupon=(int)((float)Math.random()*100);
													//System.out.println("Coupon id:"+coupon);
													//System.out.println("**Thank you visit again**");
												}
												else {
													System.out.println("Kindly give positive count");

												}
												
												
											} else {
												System.out.println("Enter valid count!");
											}
											
										}
										if(clothsList == 3) {
											System.out.println("How many blazer jacket you ordered:");
											if (ps.hasNextInt()) {
												int orderCount=ps.nextInt();
												if(orderCount>0) {
													
													System.out.println("Blazer jacket-"+orderCount);
													total3=orderCount*2000;		//total ordered amount
													System.out.println("Total=Rs."+total3);	//print order amount
													//System.out.println("GST 12%");
													//float billAmount=(total3+((total3)*12/100));//bill amount
													//System.out.println("Bill Amount="+billAmount);
													int coupon=(int)((float)Math.random()*100);
													//System.out.println("Coupon id:"+coupon);
													//System.out.println("**Thank you visit again**");
												}
												else {
													System.out.println("Kindly give positive count");

												}
												
												
											} else {
												System.out.println("Enter valid count!");
											}
											
										}
										
									} else {
										System.out.println("Please choose only above list!");
									}
								} else {
									System.out.println("Please enter only valid list!");
								}
								System.out.println("Do you want add more?");
								rply=ps.next();
							}
							while(rply.equals("yes"));
							System.out.println("------------------------------------------------------------");

							System.out.println("GST 12%");
							int total=(total1+total2+total3);
							System.out.println("Total Amount=Rs."+total);
							float billAmount=(total+((total)*12/100));
							System.out.println("Bill Amount=Rs."+billAmount);
							
						}	//case 3 end
						break;
						
						case 4:{	//furniture categories
							do {
								
								System.out.println("Furniture List:");
								System.out.println("1. Sofa-Rs.15000");
								System.out.println("2. Bed-Rs.8000");
								System.out.println("3. Dinning table-Rs.6000");
								if (ps.hasNextInt()) {
									int furnitureList = ps.nextInt();
									if (furnitureList > 0) {
										if (furnitureList == 1) {
											System.out.println("How many sofa you ordered:");
											if (ps.hasNextInt()) {
												int orderCount=ps.nextInt();
												if(orderCount>0) {
													
													System.out.println("Sofa-"+orderCount);
													total1=orderCount*15000;		//total ordered amount
													System.out.println("Total=Rs."+total1);	//print order amount
													//System.out.println("GST 12%");
													//float billAmount=(total1+((total1)*12/100));//bill amount
													//System.out.println("Bill Amount="+billAmount);
													int coupon=(int)((float)Math.random()*100);
													//System.out.println("Coupon id:"+coupon);
													//System.out.println("**Thank you visit again**");
												}
												else {
													System.out.println("Kindly give positive count");

												}
												
												
											} else {
												System.out.println("Enter valid count!");
											}
											
										}
										if(furnitureList == 2) {
											System.out.println("How many bed you ordered:");
											if (ps.hasNextInt()) {
												int orderCount=ps.nextInt();
												if(orderCount>0) {
													
													System.out.println("Bed-"+orderCount);
													total2=orderCount*8000;		//total ordered amount
													System.out.println("Total=Rs."+total2);	//print order amount
													//System.out.println("GST 12%");
													//float billAmount=(total2+((total2)*12/100));//bill amount
													//System.out.println("Bill Amount="+billAmount);
													int coupon=(int)((float)Math.random()*100);
													//System.out.println("Coupon id:"+coupon);
													//System.out.println("**Thank you visit again**");
												}
												else {
													System.out.println("Kindly give positive count");

												}	
												
												
												
											} else {
												System.out.println("Enter valid count!");
											}
											
										}
										if(furnitureList == 3) {
											System.out.println("How many dinning table you ordered:");
											if (ps.hasNextInt()) {
												int orderCount=ps.nextInt();
												if(orderCount>0) {
													
													System.out.println("Dinning table-"+orderCount);
													total3=orderCount*6000;		//total ordered amount
													System.out.println("Total=Rs."+total3);	//print order amount
													//System.out.println("GST 12%");
													//float billAmount=(total3+((total3)*12/100));//bill amount
													//System.out.println("Bill Amount="+billAmount);
													int coupon=(int)((float)Math.random()*100);
													//System.out.println("Coupon id:"+coupon);
													//System.out.println("**Thank you visit again**");
												}
												else {
													System.out.println("Kindly give positive count");

												}
												
												
												
											} else {
												System.out.println("Enter valid count!");
											}
											
										}
										
									} else {
										System.out.println("Please choose only above list!");
									}
								} else {
									System.out.println("Please enter only valid list!");
								}
								System.out.println("Do you want add more?");
								rply=ps.next();
							}
							while(rply.equals("yes"));
							System.out.println("------------------------------------------------------------");

							System.out.println("GST 12%");
							int total=(total1+total2+total3);
							System.out.println("Total Amount=Rs."+total);
							float billAmount=(total+((total)*12/100));
							System.out.println("Bill Amount=Rs."+billAmount);
							
						}	//case 4 end
						break;
						default:		//default statement
							System.out.println("Please choose above 4 categories!");
							
							
						}//switch end
					} else {
						System.out.println("enter valid categories");
					}
				} else {
					System.out.println("Please select above categories!");
				}

			} else {
				System.out.println("Please type original name!");
			}
			System.out.println("------------------------------------------------------------");
			System.out.println("\t \t**Thank you visit again**");
			//System.out.println("Do you want to continue?"); // ask to continue again
			//ans = ps.next();
		//} while (ans.equals("yes"));

	}

}

