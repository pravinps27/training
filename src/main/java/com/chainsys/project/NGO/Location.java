package com.chainsys.project.NGO;

public class Location {

	String zone_id;
	String district_name;
	String state_name;
	
	
	//constructor
	public Location() {
		
	}
	
	public Location(String zone_id, String district_name, String state_name) {
		super();
		this.zone_id = zone_id;
		this.district_name = district_name; 
		this.state_name = state_name;
	}
	
	//getter and setter
	public String getZone_id() {
		return zone_id;
	}
	public void setZone_id(String zone_id) {
		this.zone_id = zone_id;
	}
	public String getDistrict_name() {
		return district_name;
	}
	public void setDistrict_name(String district_name) {
		this.district_name = district_name;
	}
	public String getState_name() {
		return state_name;
	}
	public void setState_name(String state_name) {
		this.state_name = state_name;
	}

	//toString
	@Override
	public String toString() {
		return "Location [zone_id=" + zone_id + ", district_name=" + district_name + ", state_name=" + state_name + "]";
	}
	
	
	
	
}
