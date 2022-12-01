package com.practice.day11;


import java.util.Scanner;

public class GrossPay {

	public static void main(String[] args) {
		Scanner ps=new Scanner(System.in);
		System.out.println("Enter your Yearly package:");
		float ctc=ps.nextFloat();
		System.out.println("Your annual CTC is Rs."+ctc);
		float grosspay=grossPay(ctc);
		float month=monthlyGrossPay(ctc);
		System.out.println("Enter your leave count:");
		float leaveCount=ps.nextFloat();
		
		System.out.println("After reduction of HRA, PF and MA of net 5% is Rs."+grosspay);
		System.out.println("Your monthly package is Rs."+month);
		
		float monthlop=monthlyleave(leaveCount, ctc);
		System.out.println("Your monthly InHand salary  after leave deduction Rs."+monthlop);
		
		
		
		
	}
	public static float grossPay(float ctc) {
		float gross=((ctc)-((ctc)*5/100));
		
		return gross;
		
	}
	public static float monthlyGrossPay(float ctc) {
		float yearly=grossPay(ctc);
		float monthly=yearly/12;
		
		return monthly;
		
	}
	public static float leave(float leaveCount) {
		//float leave=grossPay(ctc);
		float leavepay=500;
		float totalLeavePay=leaveCount*leavepay;
		float lop =totalLeavePay;
		
		return lop;
		
	}
	public static float monthlyleave(float leaveCount, float ctc) {
		float lop=leave(leaveCount);
		float monthlygross=monthlyGrossPay(ctc);
		float monthlyLop=monthlygross-lop;
		
		
		return monthlyLop;
		
	}
	
	

}
