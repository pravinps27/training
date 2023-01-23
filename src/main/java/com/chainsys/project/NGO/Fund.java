package com.chainsys.project.NGO;

public class Fund {
	String fundId;
	Float fundAmount;
	Long donorAccountNo;
	String date;
	
	//constructor
	
	public Fund() {
		
	}
	public Fund(String fundId, Float fundAmount, Long donorAccountNo, String date) {
		super();
		this.fundId = fundId;
		this.fundAmount = fundAmount;
		this.donorAccountNo = donorAccountNo;
		this.date = date;
	}

	//getter and setters
	public String getFundId() {
		return fundId;
	}

	public void setFundId(String fundId) {
		this.fundId = fundId;
	}

	public Float getFundAmount() {
		return fundAmount;
	}

	public void setFundAmount(Float fundAmount) {
		this.fundAmount = fundAmount;
	}

	public Long getDonorAccountNo() {
		return donorAccountNo;
	}

	public void setDonorAccountNo(Long donorAccountNo) {
		this.donorAccountNo = donorAccountNo;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	//toString
	@Override
	public String toString() {
		return "Fund [fundId=" + fundId + ", fundAmount=" + fundAmount + ", donorAccountNo=" + donorAccountNo
				+ ", date=" + date + "]";
	}
	
	
	
}
