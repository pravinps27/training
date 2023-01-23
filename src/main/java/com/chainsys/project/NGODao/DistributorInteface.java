package com.chainsys.project.NGODao;

import java.sql.SQLException;

import com.chainsys.project.NGO.Admin;
import com.chainsys.project.NGO.Consumer;
import com.chainsys.project.NGO.Distributor;
import com.chainsys.project.NGO.Donation;
import com.chainsys.project.exception.AccountNoNotRegisteredException;

public interface DistributorInteface {

	// login method
	public Boolean empLogin(Distributor emp) throws SQLException, Exception;

	// check user id whether length =4
	public Boolean userIdLength(Distributor emp) throws Exception;

	// check password whether length between 5 to 20
	public Boolean passwordLength(Distributor emp) throws Exception;

	// get emp name with emp id in the table
	public String getempName(Distributor emp) throws ClassNotFoundException, SQLException;

//consumer start

	// get consumer details
	public String consumerDetails(Distributor emp) throws ClassNotFoundException, SQLException;

	// distributor registration method
	public String consumerRegistration(Consumer ppl) throws ClassNotFoundException, SQLException, Exception;

	// checking account no from account (bank)
	public Boolean accountNoAvailableCheck(Consumer ppl)
			throws ClassNotFoundException, SQLException, AccountNoNotRegisteredException;

	// check name contain only character both lower and upper cases
	public Boolean name(Consumer ppl) throws Exception;

	// check phone number length not exceed 10 digit and also not null and continue
	// sequence digits
	public Boolean phoneNoLength(Consumer ppl) throws Exception;

	// check aadhar number length not exceed 12 digit as well as not null
	public Boolean aadharNo(Consumer ppl) throws Exception;

	// check address whether length 100 or not
	public Boolean addressLength(Consumer ppl) throws Exception;


	// check zone id whether length =4
	public Boolean zoneLength(Consumer ppl) throws Exception;

	// check account number length = 10||13||15||17 digit as well as not null
	public Boolean accountNo(Consumer ppl) throws Exception;

// donation start
	// get donation details
	public String donationDetails(Distributor emp) throws ClassNotFoundException, SQLException;

// staff zone Id
	// get staff zone id by staff id
	public String staffZoneId(Distributor emp) throws ClassNotFoundException, SQLException;

// stock start
	// get stock details
	public String stockDetailsByZoneId(Distributor emp) throws ClassNotFoundException, SQLException;

// Donation register
	// Donation application method
	public String makeDonation(Donation donate) throws ClassNotFoundException, SQLException, Exception;
}
