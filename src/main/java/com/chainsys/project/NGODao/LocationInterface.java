package com.chainsys.project.NGODao;

import java.sql.SQLException;
import java.util.List;

import com.chainsys.project.NGO.Location;

public interface LocationInterface {

	public List location() throws ClassNotFoundException, SQLException;
	public Boolean zoneIdCheck(Location location) throws ClassNotFoundException, SQLException;
	
	

}
