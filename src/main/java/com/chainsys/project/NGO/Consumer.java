package com.chainsys.project.NGO;

public class Consumer {
	String consumer_id;
	String consumer_name;
	Long phone_no;
	Long aadhar_no;
	String address;
	String zone_id;
	Long account_no;

	// constructor
	public Consumer() {

	}

	public Consumer(String distributor_id, String distributor_name, Long phone_no, Long aadhar_no, String address,
			String zone_id, Long account_no) {
		super();
		this.consumer_id = distributor_id;
		this.consumer_name = distributor_name;
		this.phone_no = phone_no;
		this.aadhar_no = aadhar_no;
		this.address = address;

		this.zone_id = zone_id;
		this.account_no = account_no;

	}

	// setter and getter
	public String getConsumer_id() {
		return consumer_id;
	}

	public void setConsumer_id(String consumer_id) {
		this.consumer_id = consumer_id;
	}

	public String getConsumer_name() {
		return consumer_name;
	}

	public void setConsumer_name(String consumer_name) {
		this.consumer_name = consumer_name;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	// toString
	@Override
	public String toString() {
		return "Consumer [consumer_id=" + consumer_id + ", consumer_name=" + consumer_name + ", phone_no=" + phone_no
				+ ", aadhar_no=" + aadhar_no + ", address=" + address + ", zone_id=" + zone_id + ", account_no="
				+ account_no + "]";
	}

	

}
