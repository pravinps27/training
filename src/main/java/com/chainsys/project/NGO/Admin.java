package com.chainsys.project.NGO;

public class Admin {
	String adminId;
	String adminName;
	Long adminPhoneNo;
	String adminPanNo;
	Long adminAdharNo;
	String adminAddress;
	String adminPassword;
	String adminZone;
	Long AdminAccountNo;
	
	//constructor
	public Admin() {
		 
	}
	
	//constructor
	public Admin(String adminId, String adminName, Long adminPhoneNo, String adminPanNo, Long adminAdharNo,
			String adminAddress, String adminPassword, String adminZone, Long adminAccountNo) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminPhoneNo = adminPhoneNo;
		this.adminPanNo = adminPanNo;
		this.adminAdharNo = adminAdharNo;
		this.adminAddress = adminAddress;
		this.adminPassword = adminPassword;
		this.adminZone = adminZone;
		AdminAccountNo = adminAccountNo;
	}

	
	//getter and setter
	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public Long getAdminPhoneNo() {
		return adminPhoneNo;
	}

	public void setAdminPhoneNo(Long adminPhoneNo) {
		this.adminPhoneNo = adminPhoneNo;
	}

	public String getAdminPanNo() {
		return adminPanNo;
	}

	public void setAdminPanNo(String adminPanNo) {
		this.adminPanNo = adminPanNo;
	}

	public Long getAdminAdharNo() {
		return adminAdharNo;
	}

	public void setAdminAdharNo(Long adminAdharNo) {
		this.adminAdharNo = adminAdharNo;
	}

	public String getAdminAddress() {
		return adminAddress;
	}

	public void setAdminAddress(String adminAddress) {
		this.adminAddress = adminAddress;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getAdminZone() {
		return adminZone;
	}

	public void setAdminZone(String adminZone) {
		this.adminZone = adminZone;
	}

	public Long getAdminAccountNo() {
		return AdminAccountNo;
	}

	public void setAdminAccountNo(Long adminAccountNo) {
		AdminAccountNo = adminAccountNo;
	}

	
	//toString
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminPhoneNo=" + adminPhoneNo
				+ ", adminPanNo=" + adminPanNo + ", adminAdharNo=" + adminAdharNo + ", adminAddress=" + adminAddress
				+ ", adminPassword=" + adminPassword + ", adminZone=" + adminZone + ", AdminAccountNo=" + AdminAccountNo
				+ "]";
	}
	
	
	
	
	
}
