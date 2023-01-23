package com.chainsys.project.NGO;

public class SellerDetails {
	String sellerId;
	String sellerName;
	Long phoneNo;
	Long aadharNo;
	String panNo;
	String shopName;
	String GSTNo;
	String mailId;
	String address;
	String zoneId;
	Long accountNo;

	//constructor
	public SellerDetails() {
		
	}
	
	public SellerDetails(String sellerId, String sellerName, Long phoneNo, Long aadharNo, String panNo, String shopName,
			String gSTNo, String mailId,String address, String zoneId, Long accountNo) {
		super();
		this.sellerId = sellerId;
		this.sellerName = sellerName;
		this.phoneNo = phoneNo;
		this.aadharNo = aadharNo;
		this.panNo = panNo;
		this.shopName = shopName;
		this.GSTNo = gSTNo;
		this.mailId = mailId;
		this.address=address;
		this.zoneId = zoneId;
		this.accountNo = accountNo;
	}

	//setter getter
	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public Long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Long getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(Long aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getGSTNo() {
		return GSTNo;
	}

	public void setGSTNo(String gSTNo) {
		this.GSTNo = gSTNo;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	public String getZoneId() {
		return zoneId;
	}

	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}

	public Long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}

	//toString
	@Override
	public String toString() {
		return "SellerDetails [sellerId=" + sellerId + ", sellerName=" + sellerName + ", phoneNo=" + phoneNo
				+ ", aadharNo=" + aadharNo + ", panNo=" + panNo + ", shopName=" + shopName + ", GSTNo=" + GSTNo
				+ ", mailId=" + mailId + ", address=" + address + ", zoneId=" + zoneId + ", accountNo=" + accountNo
				+ "]";
	}
	
	
	
	
}
