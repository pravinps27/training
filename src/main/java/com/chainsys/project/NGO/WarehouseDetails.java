package com.chainsys.project.NGO;

public class WarehouseDetails {
	String warehouseId;
	String location;
	String zoneId;
	
	//constructor
	public WarehouseDetails() {
		
	}
	
	public WarehouseDetails(String warehouseId, String location, String zoneId) {
		super();
		this.warehouseId = warehouseId;
		this.location = location;
		this.zoneId = zoneId;
	}

	//setter getter
	public String getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(String warehouseId) {
		this.warehouseId = warehouseId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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
		return "WarehouseDetails [warehouseId=" + warehouseId + ", location=" + location + ", zoneId=" + zoneId + "]";
	}
	
	
	
	
}
