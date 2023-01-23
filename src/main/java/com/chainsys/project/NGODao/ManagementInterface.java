package com.chainsys.project.NGODao;

import java.sql.SQLException;

import com.chainsys.project.NGO.Admin;
import com.chainsys.project.NGO.Distributor;
import com.chainsys.project.NGO.Management;
import com.chainsys.project.exception.AccountNoNotRegisteredException;

public interface ManagementInterface {

	// login method
	public Boolean managerLogin(Management manager) throws SQLException, Exception;

	// check user id whether length =4
	public Boolean userIdLength(Management manager) throws Exception;

	// check password whether length between 5 to 20
	public Boolean passwordLength(Management manager) throws Exception;

	// get manager name with manager id in the table
	public String getManagerName(Management manager) throws ClassNotFoundException, SQLException;

	// get donator details
	public String donatorDetails(Management manager) throws ClassNotFoundException, SQLException;

	// get fund details
	public String fundDetails(Management manager) throws ClassNotFoundException, SQLException;

// distributor starts

	// get distributor details
	public String distributorDetails(Management manager) throws ClassNotFoundException, SQLException;

	// management registration method
	public String distributorRegistration(Distributor emp) throws ClassNotFoundException, SQLException, Exception;

	// checking account no from account (bank)
	public Boolean accountNoAvailableCheck(Distributor emp)
			throws ClassNotFoundException, SQLException, AccountNoNotRegisteredException;

	// check mail id whether already present or not in the records
	public Boolean mailCheck(Distributor emp) throws Exception;

	// check name contain only character both lower and upper cases
	public Boolean name(Distributor emp) throws Exception;

	// check mail id contains minimum 3 character front of '@' and after minimum 5
	// character must contain '.'
	public Boolean email(Distributor emp) throws Exception;

	// check phone number length not exceed 10 digit and also not null and continue
	// sequence digits
	public Boolean phoneNoLength(Distributor emp) throws Exception;

	// check aadhar number length not exceed 12 digit as well as not null
	public Boolean aadharNo(Distributor emp) throws Exception;

	// check address whether length 100 or not
	public Boolean addressLength(Distributor emp) throws Exception;

	// check password whether length between 5 to 20
	public Boolean passwordLength(Distributor emp) throws Exception;

	// check zone id whether length =4
	public Boolean zoneLength(Distributor emp) throws Exception;

	// check account number length = 10||13||15||17 digit as well as not null
	public Boolean accountNo(Distributor emp) throws Exception;

	// get consumer details
	public String consumerDetails(Management manager) throws ClassNotFoundException, SQLException;

	// get donation details
	public String donationDetails(Management maanger) throws ClassNotFoundException, SQLException;

	// get donation details
	public String stockDetails(Management maanger) throws ClassNotFoundException, SQLException;

// seller start
	// get seller details
	public String sellerDetails(Management manager) throws ClassNotFoundException, SQLException;

	// get warehouse details
	public String warehouseDetails(Management manager) throws ClassNotFoundException, SQLException;

// manager zone Id
	// get manager zone id by staff id
	public String managerZoneId(Management manager) throws ClassNotFoundException, SQLException;

// donation approval
	// get manager zone id by staff id
	public String donationApproval(Management manager) throws ClassNotFoundException, SQLException;

// donation rejection
	// rejected donation
	public String donationRejection(Management manager) throws ClassNotFoundException, SQLException;
}
