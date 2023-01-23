package com.chainsys.project.NGO;

public class DistributorDetails {
	String distributor_id;
	String distributor_name;
	Long phone_no;
	Long aadhar_no;
	String mail_id;
	String address;
	String password;
	String zone_id;
	Long account_no;

	
	//constructor
	public DistributorDetails() {
		
	}
	
	public DistributorDetails(String distributor_id, String distributor_name, Long phone_no, Long aadhar_no, String mail_id,
			String address, String password, String zone_id, Long account_no) {
		super();
		this.distributor_id = distributor_id;
		this.distributor_name = distributor_name;
		this.phone_no = phone_no;
		this.aadhar_no = aadhar_no;
		this.mail_id = mail_id;
		this.address = address;
		this.password = password;
		this.zone_id = zone_id;
		this.account_no = account_no;
		
	}

	//setter and getter
	public String getDistributor_id() {
		return distributor_id;
	}

	public void setDistributor_id(String distributor_id) {
		this.distributor_id = distributor_id;
	}

	public String getDistributor_name() {
		return distributor_name;
	}

	public void setDistributor_name(String distributor_name) {
		this.distributor_name = distributor_name;
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
		return "DistributorDetails [distributor_id=" + distributor_id + ", distributor_name=" + distributor_name
				+ ", phone_no=" + phone_no + ", aadhar_no=" + aadhar_no + ", mail_id=" + mail_id + ", address="
				+ address + ", password=" + password + ", zone_id=" + zone_id + ", account_no=" + account_no + "]";
	}

	

	
	
}
