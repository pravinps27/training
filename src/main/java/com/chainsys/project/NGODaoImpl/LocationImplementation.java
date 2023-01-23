package com.chainsys.project.NGODaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.project.NGO.Location;
import com.chainsys.project.NGODBConnection.NGOConnection;
import com.chainsys.project.NGODao.LocationInterface;

public class LocationImplementation implements LocationInterface{

	@Override
	public List location() throws ClassNotFoundException, SQLException {
		
			
		Connection connect=NGOConnection.connection();		//get connection from DB 
		String zonecatogue="SELECT state_name, zone_id, district_name FROM location";	//query to select location table details
		PreparedStatement pst=connect.prepareStatement(zonecatogue);
		ResultSet rs=pst.executeQuery();	//retrieve data from DB
		ArrayList<Location> locationList= new ArrayList<>();	//creating array list to store values locally
		while(rs.next()) {
			String stateName=rs.getString(1); 
			String zoneId=rs.getString(2);
			String districtName=rs.getString(3);  
			Location location=new Location();
			location.setState_name(stateName); 
			location.setDistrict_name(districtName);
			location.setZone_id(zoneId);
			
			locationList.add(location);		//adding data to list
		}
		
		
			
		
		for (Location location : locationList) {
			System.out.println(location);
		}
		
		return null;	//return method as list
	}

	//zone_id checking method
	@Override
	public Boolean zoneIdCheck(Location location) throws ClassNotFoundException, SQLException {
		Connection connect=NGOConnection.connection();		//get connection from DB 
		String zonecatogue="SELECT zone_id FROM location";	//query to select zone_id from location table details
		PreparedStatement pst=connect.prepareStatement(zonecatogue);
		ResultSet rs=pst.executeQuery();	//retrieve data from DB
		String zone=location.getZone_id();
		while(rs.next()) {
			String zoneId=rs.getString(1);
			if(zoneId.equals(zone)) {
				return true;
			}
		}
		return false;
	}
	
	
}
