package com.chainsys.project.NGODemo;

import java.sql.SQLException;

import com.chainsys.project.NGODao.LocationInterface;
import com.chainsys.project.NGODaoImpl.LocationImplementation;

public class LocationDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		LocationImplementation location=new LocationImplementation();
		System.out.println(location.location());
		
	}

}
