package com.practice.day10;

public class Ex_types {

	public static void main(String[] args) {
		String ab="0";
		int a;
		a=10;
		a=12;
		System.out.println(a);
		int bb[]= {1};
		int aa[]= {0,10,12,11,};
		//int a=0,b=1;
		
		try {
			
				System.out.println(aa[7]);
			
		}
		catch(ArrayIndexOutOfBoundsException ae) {
			System.out.println(ae.getLocalizedMessage());
			//ae.printStackTrace();
		}
		try {
			System.out.println(aa[1]);
		}
		catch( Exception ar) {
			System.out.println(ar.getLocalizedMessage());
		}
		try {
			System.out.println(bb[0]);
		}
		catch(NullPointerException n) {
			System.out.println(n.getLocalizedMessage());
		}
		try {
		//	System.out.println(b/a);
		}
		catch(ArithmeticException ar) {
		System.out.println(ar.getLocalizedMessage());
		}
		}

}
