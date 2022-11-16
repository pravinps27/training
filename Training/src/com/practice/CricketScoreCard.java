package com.practice;

import java.util.Scanner;

public class CricketScoreCard {

	public static void main(String[] args) {
		Scanner ps=new Scanner(System.in);
		System.out.println("Enter Team India Score");
		System.out.println("KL Ragul-");
		int run1=ps.nextInt();
		System.out.println("Rohit Sharma-");
		int run2=ps.nextInt();
		System.out.println("Virat Kohli-");
		int run3=ps.nextInt();
		System.out.println("Suriyakumar-");
		int run4=ps.nextInt();
		System.out.println("Hardik pandya-");
		int run5=ps.nextInt();
		System.out.println("Dinesh karthik-");
		int run6=ps.nextInt();
		System.out.println("Axar patel-");
		int run7=ps.nextInt();
		System.out.println("R Ashwin-");
		int run8=ps.nextInt();
		System.out.println("Bhuvi-");
		int run9=ps.nextInt();
		System.out.println("A Singh-");
		int run10=ps.nextInt();
		System.out.println("M shami-");
		int run11=ps.nextInt();
		System.out.println("Enter Team England Score");
		System.out.println("A hales-");
		int run12=ps.nextInt();
		System.out.println("J buttler-");
		int run13=ps.nextInt();
		System.out.println("H brook-");
		int run14=ps.nextInt();
		System.out.println("L livingstone-");
		int run15=ps.nextInt();
		System.out.println("M ali-");
		int run16=ps.nextInt();
		System.out.println("A rashid-");
		int run17=ps.nextInt();
		System.out.println("C jordan-");
		int run18=ps.nextInt();
		System.out.println("C woakes-");
		int run19=ps.nextInt();
		System.out.println("D willey-");
		int run20=ps.nextInt();
		System.out.println("S curran-");
		int run21=ps.nextInt();
		System.out.println("B stokes-");
		int run22=ps.nextInt();
		int india=(run1+run2+run3+run4+run5+run6+run7+run8+run9+run10+run11);
		int england=(run12+run13+run14+run15+run16+run17+run18+run19+run20+run21+run22);
		System.out.println("Team India:"+india);
		System.out.println("Team England:"+england);
		if(india>england) {
			System.out.println("Team India wins the match");
		}
		else if(india<england){
			System.out.println("Team England wins the match");
		}
		else {
			System.out.println("Match Draw");
			
		}
		
		
	}

}
