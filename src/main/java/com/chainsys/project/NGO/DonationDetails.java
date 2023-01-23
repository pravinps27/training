package com.chainsys.project.NGO;

public abstract class  DonationDetails  {
	String donationId;
	String staffId;
	String consumerId;
	String stockId;
	Integer quantity;
	Float fundAmount;
	String description;
	String donationDate;
	
	//constructor
	
	public DonationDetails() {
		
	}
	
	public DonationDetails(String donationId, String staffId, String consumerId, String stockId, Integer quantity,
			Float fundAmount, String description, String donationDate) {
		super();
		this.donationId = donationId;
		this.staffId = staffId;
		this.consumerId = consumerId;
		this.stockId = stockId;
		this.quantity = quantity;
		this.fundAmount = fundAmount;
		this.description = description;
		this.donationDate = donationDate;
	}

	//setter getter
	public String getDonationId() {
		return donationId;
	}

	public void setDonationId(String donationId) {
		this.donationId = donationId;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(String consumerId) {
		this.consumerId = consumerId;
	}

	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Float getFundAmount() {
		return fundAmount;
	}

	public void setFundAmount(Float fundAmount) {
		this.fundAmount = fundAmount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDonationDate() {
		return donationDate;
	}

	public void setDonationDate(String donationDate) {
		this.donationDate = donationDate;
	}

	//toString
	@Override
	public String toString() {
		return "DonationDetails [donationId=" + donationId + ", staffId=" + staffId + ", consumerId=" + consumerId
				+ ", stockId=" + stockId + ", quantity=" + quantity + ", fundAmount=" + fundAmount + ", description="
				+ description + ", donationDate=" + donationDate + "]";
	}
	
	
	
}
