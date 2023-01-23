package com.chainsys.project.NGO;

public class Transaction {
	Integer transactionNo;
	Long accontNo;
	String transactionType;
	String date;
	Float amount;
	
	//constructor
	
	public Transaction() {
		
	}
	
	public Transaction(Integer transactionNo, Long accontNo, String transactionType, String date, Float amount) {
		super();
		this.transactionNo = transactionNo;
		this.accontNo = accontNo;
		this.transactionType = transactionType;
		this.date = date;
		this.amount = amount;
	}

	//getter and setters
	public Integer getTransactionNo() {
		return transactionNo;
	}

	public void setTransactionNo(Integer transactionNo) {
		this.transactionNo = transactionNo;
	}

	public Long getAccontNo() {
		return accontNo;
	}

	public void setAccontNo(Long accontNo) {
		this.accontNo = accontNo;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	//toString
	@Override
	public String toString() {
		return "Transaction [transactionNo=" + transactionNo + ", accontNo=" + accontNo + ", transactionType="
				+ transactionType + ", date=" + date + ", amount=" + amount + "]";
	}
	
	
	
	
}
