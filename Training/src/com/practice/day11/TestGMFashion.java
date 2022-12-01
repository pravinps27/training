package com.practice.day11;

import java.util.Scanner;

public class TestGMFashion {

	public static void main(String[] args) {
		GMFashion shop=new GMFashion();
		System.out.println("\t***Welcome***");
		Scanner ps=new Scanner(System.in);
		System.out.println("What you want?");
		String want=ps.next();
		System.out.println("How many you want?");
		int count=ps.nextInt();
		GMFashion.purchase(want, 700, count);
		
		GMFashionBranch1 branch=new GMFashionBranch1();
		branch.purchase("phant", 700, 2);
		
		
		
		
	}

}
