package com.practice.day5;

public class TestConstructor {

	public static void main(String[] args) {
		Constructor[] emp=new Constructor[5];
		emp[0]=new Constructor(12, "arjun");
		emp[1]=new Constructor(13, "rajesh");
		emp[2]=new Constructor(14, "pasupathi");
		emp[3]=new Constructor(15, "deva");
		emp[4]=new Constructor(16, "nithya");
		for(int i=0;i<emp.length;i++) {
			System.out.println(emp[i].id);
			System.out.println(emp[i].name);
		}
	}

}
