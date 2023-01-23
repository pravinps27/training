package com.chainsys.project.NGODao;

import java.sql.SQLException;

import com.chainsys.project.NGO.Admin;
import com.chainsys.project.NGO.Distributor;
import com.chainsys.project.NGO.DonationDetails;
import com.chainsys.project.NGO.Donor;
import com.chainsys.project.NGO.Fund;
import com.chainsys.project.NGO.Management;
import com.chainsys.project.exception.AccountNoNotRegisteredException;

public interface AdminInterface {

	// admin login method
	public Boolean adminLogin(Admin admin) throws SQLException, Exception;

	// check user id =4 or not
	public Boolean userIdLength(Admin admin) throws Exception;

	// check password length 5 to 20
	public Boolean passwordLength(Admin admin) throws Exception;

	// get fund details from fund table
	public String fundDetails(Admin admin) throws ClassNotFoundException, SQLException;

	// get admin name with admin id in the table
	public String getAdminName(Admin admin) throws ClassNotFoundException, SQLException;

	// get account details of admin and balance from account table
	public String accountDetails(Admin admin) throws ClassNotFoundException, SQLException;

	// get transaction details from transaction table
	public String transactionDetails(Admin admin) throws ClassNotFoundException, SQLException;

	// get manager details
	public String managerDetails(Admin admin) throws ClassNotFoundException, SQLException;

	// management registration method
	public String managerRegistration(Management manager) throws ClassNotFoundException, SQLException, Exception;

	// checking account no from account (bank)
	public Boolean accountNoAvailableCheck(Management manager)
			throws ClassNotFoundException, SQLException, AccountNoNotRegisteredException;

	// check mail id whether already present or not in the records
	public Boolean mailCheck(Management manager) throws Exception;

	// check name contain only character both lower and upper cases
	public Boolean name(Management manager) throws Exception;

	// check mail id contains minimum 3 character front of '@' and after minimum 5
	// character must contain '.'
	public Boolean email(Management manager) throws Exception;

	// check phone number length not exceed 10 digit and also not null and continue
	// sequence digits
	public Boolean phoneNoLength(Management manager) throws Exception;

	// check aadhar number length not exceed 12 digit as well as not null
	public Boolean aadharNo(Management manager) throws Exception;

	// check address whether length 100 or not
	public Boolean addressLength(Management manager) throws Exception;

	// check password whether length between 5 to 20
	public Boolean passwordLength(Management manager) throws Exception;

	// check zone id whether length =4
	public Boolean zoneLength(Management manager) throws Exception;

	// check account number length = 10||13||15||17 digit as well as not null
	public Boolean accountNo(Management manager) throws Exception;

// distributor starts

	// get distributor details
	public String distributorDetails(Admin admin) throws ClassNotFoundException, SQLException;

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
	public String consumerDetails(Admin admin) throws ClassNotFoundException, SQLException;

	// get donation details
	public String donationDetails(Admin admin) throws ClassNotFoundException, SQLException;

	// get donation details
	public String stockDetails(Admin admin) throws ClassNotFoundException, SQLException;

	// get warehouse details
	public String warehouseDetails(Admin admin) throws ClassNotFoundException, SQLException;

// seller start
	// get seller details
	public String sellerDetails(Admin admin) throws ClassNotFoundException, SQLException;

// Donation history starts
	// get Donation history details
	public String donationHistory(Admin admin) throws ClassNotFoundException, SQLException;
}
