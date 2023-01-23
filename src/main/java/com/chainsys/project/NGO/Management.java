package com.chainsys.project.NGO;

public class Management {
	String manager_id;
	String manager_name;
	Long phone_no;
	Long aadhar_no;
	String mail_id;
	String address;
	String password;
	String zone_id;
	Long account_no;
	Float amount;
	
	//constructor
	
	public Management() {
		
	}
	
	public Management(String manager_id, String manager_name, Long phone_no, Long aadhar_no, String mail_id,
			String address, String password, String zone_id, Long account_no, Float amount) {
		super();
		this.manager_id = manager_id;
		this.manager_name = manager_name;
		this.phone_no = phone_no;
		this.aadhar_no = aadhar_no;
		this.mail_id = mail_id;
		this.address = address;
		this.password = password;
		this.zone_id = zone_id;
		this.account_no = account_no;
		this.amount = amount;
	}

	//setter and getter
	public String getManager_id() {
		return manager_id;
	}

	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}

	public String getManager_name() {
		return manager_name;
	}

	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}

	public Long getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(Long phone_no) {
		this.phone_no = phone_no;
	}

	public Long getAadhar_no() {
		return aadhar_no;
	}

	public void setAadhar_no(Long aadhar_no) {
		this.aadhar_no = aadhar_no;
	}

	public String getMail_id() {
		return mail_id;
	}

	public void setMail_id(String mail_id) {
		this.mail_id = mail_id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getZone_id() {
		return zone_id;
	}

	public void setZone_id(String zone_id) {
		this.zone_id = zone_id;
	}

	public Long getAccount_no() {
		return account_no;
	}

	public void setAccount_no(Long account_no) {
		this.account_no = account_no;
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
		return "Management [manager_id=" + manager_id + ", manager_name=" + manager_name + ", phone_no=" + phone_no
				+ ", aadhar_no=" + aadhar_no + ", mail_id=" + mail_id + ", address=" + address + ", password="
				+ password + ", zone_id=" + zone_id + ", account_no=" + account_no + ", amount=" + amount + "]";
	}
	
	

}
