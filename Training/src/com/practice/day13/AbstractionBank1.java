package com.practice.day13;

public class AbstractionBank1 extends AbstractionBank {

	@Override
	public int loan() {
		System.out.println("Loan");
		return 0;
	}

	@Override
	public String accName() {
		System.out.println("Account Name");
		return null;
	}

}
