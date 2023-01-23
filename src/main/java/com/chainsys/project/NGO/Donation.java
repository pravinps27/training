package com.chainsys.project.NGO;

public class Donation {
	String donationId;
	String staffId;
	String consumerId;
	String stockId;
	Integer quantity;
	Float fundAmount;
	String description;
	String donationDate;
	String approvedBy;
	String approvalStatus;
	String zoneId;

	// constructor
	public Donation() {
		
	}
	
	public Donation(String donationId, String staffId, String consumerId, String stockId, Integer quantity,
			Float fundAmount, String description, String donationDate, String approvedBy, String approvalStatus,String zoneId) {
		super();
		this.donationId = donationId;
		this.staffId = staffId;
		this.consumerId = consumerId;
		this.stockId = stockId;
		this.quantity = quantity;
		this.fundAmount = fundAmount;
		this.description = description;
		this.donationDate = donationDate;
		this.approvedBy = approvedBy;
		this.approvalStatus = approvalStatus;
		this.zoneId=zoneId;
	}
	
	//getter and setter

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

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	
	public String getZoneId() {
		return zoneId;
	}
	
	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}

	//toString
	@Override
	public String toString() {
		return "Donation [donationId=" + donationId + ", staffId=" + staffId + ", consumerId=" + consumerId
				+ ", stockId=" + stockId + ", quantity=" + quantity + ", fundAmount=" + fundAmount + ", description="
				+ description + ", donationDate=" + donationDate + ", approvedBy=" + approvedBy + ", approvalStatus="
				+ approvalStatus + ", zoneId=" + zoneId + "]";
	}

	
	
	

}
