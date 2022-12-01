package com.practice.day12;

import java.util.Scanner;

public class EmployeeGrossPay {
	public static void main(String[] args) {
		Scanner ps=new Scanner(System.in);
		System.out.println("Enter Number of employee:");
		int empCount=ps.nextInt();
		String name[]=new String[empCount];
		float pakkage[]=new float[empCount];
		for (int i=0;i<name.length;i++) //storing employee name in array
		{
			System.out.println("Enter the employee "+(i+1)+" name:");
		 name[i]=ps.next();	
		 for(int j=i;j<i+1;j++) //storing employee package
		 {
			 System.out.println("Enter employee "+name[i]+"'s Yearly package:");
			 pakkage[j]=ps.nextFloat();
		 }
		}
		System.out.println("\t \t ***Employees Package details***");
		System.out.println();
		for (int k=0;k<name.length;k++)	//display employee package details 
		{
			System.out.println("Employee name: "+name[k]);
			//System.out.println(pakkage[k]);
			//float ctc[k]=ps.nextFloat();
			System.out.println("Employee "+name[k]+"'s annual CTC is Rs."+pakkage[k]);
			float grosspay=grossPay(pakkage[k]);
			float month=monthlyGrossPay(pakkage[k]);
			System.out.println("After reduction of HRA, PF and MA of net 5% is Rs."+grosspay);
			System.out.println(name[k]+"'s Monthly Inhand package is Rs."+month);
			System.out.println("-------------------------------------------------------------------------");
			System.out.println();
		}
		
	//	System.out.println("Enter your leave count:");
	//	float leaveCount=ps.nextFloat();
		
		
	//	float monthlop=monthlyleave(leaveCount, ctc);
	//	System.out.println("Your monthly InHand salary  after leave deduction Rs."+monthlop);
		
		
		
		
	}
	public static float grossPay(float pakkage) {
		float gross=((pakkage)-((pakkage)*5/100));
		
		return gross;
		
	}
	public static float monthlyGrossPay(float pakkage) {
		float yearly=grossPay(pakkage);
		float monthly=yearly/12;
		
		return monthly;
		
	}
	
	

}
