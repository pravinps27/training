package com.practice.day9;

public class ExceptionHandling {

	public static void main(String[] args) {
		int a[]= {1,2,3,4,5,}; //fix length
		
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
		try {
			for(int i =0;i<10;i++) {
				System.out.println(a[i]);
				
			}
			System.out.println(a[1]);
		}
		catch(ArithmeticException ar) {
			System.out.println(ar.getMessage());
		}
		catch(ArrayIndexOutOfBoundsException ai) {
			System.out.println(ai.getLocalizedMessage());
		}
		catch(NullPointerException n) {
			System.out.println(n.getMessage());
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			}
		}

	}


