package com.practice.day13;

public class GetSetPractice {
	private String name, accType;
	private int accNo, bal, amt;

	GetSetPractice() {
		name = null;
		accType = null;
		accNo = 0;
		bal = 0;
		amt = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public int getAccNO() {
		return accNo;
	}

	public void setAccNO(int accNO) {
		this.accNo = accNO;
	}

	public int getBal() {
		return bal;
	}

	public void setBal(int bal) {
		this.bal = bal;
	}

	public int getAmt() {
		return amt;
	}

	public void setAmt(int amt) {
		this.amt = amt;
	}

	public int withdraw(int amt) throws Exception {
		// int currentBalance = 0;
		if (amt > 0) {

			if (amt < bal) {

				bal = bal - amt;
			} else
				System.out.println("Insufficient fund");
			return bal;
		} else
			throw new Exception("Invalid amount");
	}

	public int deposit(int amt) {
		// int balance = 0;
		if (amt > 0) {
			bal = bal + amt;
		}
		return bal;
	}

	public int balance() {

		// int availableBalance = (deposit(amt)-withdraw(amt));
		return bal;
	}
}
