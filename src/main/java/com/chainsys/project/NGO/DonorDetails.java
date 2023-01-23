package com.chainsys.project.NGO;

public class DonorDetails {
	String donator_id;
	String donator_name;
	Long phone_no;
	Long aadhar_no;
	String mail_id;
	String address;
	String password;
	String zone_id;
	Long account_no;
	
	//constructor
	
	public DonorDetails() {
		
	}
	
	public DonorDetails(String donator_id, String donator_name, Long phone_no, Long aadhar_no, String mail_id,
			String address, String password, String zone_id, Long account_no) {
		super();
		this.donator_id = donator_id;
		this.donator_name = donator_name;
		this.phone_no = phone_no;
		this.aadhar_no = aadhar_no;
		this.mail_id = mail_id;
		this.address = address;
		this.password = password;
		this.zone_id = zone_id;
		this.account_no = account_no;
	}

	
	//getter and setters
	public String getDonator_id() {
		return donator_id;
	}

	public void setDonator_id(String donator_id) {
		this.donator_id = donator_id;
	}

	public String getDonator_name() {
		return donator_name;
	}

	public void setDonator_name(String donator_name) {
		this.donator_name = donator_name;
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

	//toString
	@Override
	public String toString() {
		return "DonorDetails [donator_id=" + donator_id + ", donator_name=" + donator_name + ", phone_no=" + phone_no
				+ ", aadhar_no=" + aadhar_no + ", mail_id=" + mail_id + ", address=" + address + ", password="
				+ password + ", zone_id=" + zone_id + ", account_no=" + account_no + "]";
	}
	
	
	
	
}
