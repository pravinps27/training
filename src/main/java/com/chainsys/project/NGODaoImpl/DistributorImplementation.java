package com.chainsys.project.NGODaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.chainsys.project.NGO.Admin;
import com.chainsys.project.NGO.Consumer;
import com.chainsys.project.NGO.Distributor;
import com.chainsys.project.NGO.DistributorDetails;
import com.chainsys.project.NGO.Donation;
import com.chainsys.project.NGO.DonationDetails;
import com.chainsys.project.NGO.Management;
import com.chainsys.project.NGO.StockDetails;
import com.chainsys.project.NGO.Distributor;
import com.chainsys.project.NGODBConnection.NGOConnection;
import com.chainsys.project.NGODao.DistributorInteface;
import com.chainsys.project.exception.AccountNoNotRegisteredException;
import com.chainsys.project.exception.DuplicateMailIdException;
import com.chainsys.project.exception.InvalidAadharNoException;
import com.chainsys.project.exception.InvalidAccountNoException;
import com.chainsys.project.exception.InvalidMailIdException;
import com.chainsys.project.exception.InvalidNameException;
import com.chainsys.project.exception.InvalidNameLengthException;
import com.chainsys.project.exception.InvalidPasswordLengthException;
import com.chainsys.project.exception.InvalidPhoneNoException;
import com.chainsys.project.exception.InvalidUserIdException;
import com.chainsys.project.exception.InvalidZoneLengthException;
import com.chainsys.project.exception.UserAddressLengthException;

public class DistributorImplementation implements DistributorInteface {

	// login method
	public Boolean empLogin(Distributor emp) throws SQLException, Exception {
		try {
			Connection connect = NGOConnection.connection(); // get connection from DB
			String empId = emp.getDistributor_id();
			String empPassword = emp.getPassword();
			String login = "SELECT CONCAT(prefix,s_id) as staff_id, password FROM distributor";
			PreparedStatement pst = connect.prepareStatement(login);
			ResultSet rs = pst.executeQuery(); // retrieve data from DB
			while (rs.next()) {
				String empId1 = rs.getString(1);
				if (empId1.equals(empId)) {
					String empPassword1 = rs.getString(2);
					if (empPassword1.equals(empPassword)) // checking user id and password equal
					{
						return true;
					} else {
						throw new Exception("password incorrect!");
					}
				}

			}
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
		throw new Exception("User Id or password is incorrect!");
	}

	// check user id whether length =4
	public Boolean userIdLength(Distributor emp) throws Exception {
		String userId = emp.getDistributor_id();
		if (userId.length() == 4) {
			return true;
		} else
			throw new InvalidUserIdException();
		// throw new Exception("Address lenght should not exceed 100 character!");

	}

	// check password whether length between 5 to 20
	public Boolean passwordLength(Distributor emp) throws Exception {
		String password = emp.getPassword();
		if (password.length() > 4 && password.length() < 20) {
			return true;
		} else
			throw new InvalidPasswordLengthException();
		// throw new Exception("Address lenght should not exceed 100 character!");

	}

	// get emp name with emp id in the table
	public String getempName(Distributor emp) throws ClassNotFoundException, SQLException {
		Connection connect = NGOConnection.connection(); // get connection from DB
		String empId = emp.getDistributor_id();
		String empName = null;
		String query = "SELECT CONCAT(prefix,s_id) as staff_id, staff_name FROM distributor";
		PreparedStatement pst = connect.prepareStatement(query);
		ResultSet rs = pst.executeQuery(); // retrieve data from DB
		while (rs.next()) {
			String donorId1 = rs.getString(1);
			if (donorId1.equals(empId)) {
				empName = rs.getString(2); // getting donor name by checking given donor id

			}
		}
		return empName;

	}

// consumer start

	// get consumer details
	public String consumerDetails(Distributor emp) throws ClassNotFoundException, SQLException {
		try {
			Connection connect = NGOConnection.connection();
			String consumerDetail = "SELECT CONCAT(prefix,c_id) AS consumer_id, consumer_name,phone_no,aadhar_no,"
					+ "address,zone_id,account_no FROM consumer"; // query to get consumer details

			PreparedStatement pst = connect.prepareStatement(consumerDetail);
			ResultSet rs = pst.executeQuery(); // retrieve data from DB
			ArrayList<Consumer> consumerList = new ArrayList<>(); // creating array list to store values locally

			while (rs.next()) {
				String distributorId = rs.getString(1);
				String eName = rs.getString(2);
				Long ePhone = rs.getLong(3);
				Long eAadhar = rs.getLong(4);
				String eAddress = rs.getString(5);
				String eZone = rs.getString(6);
				Long eAccount = rs.getLong(7);

				Consumer ppl = new Consumer();
				// setting value in object
				ppl.setConsumer_id(distributorId);
				ppl.setConsumer_name(eName);
				ppl.setPhone_no(ePhone);
				ppl.setAadhar_no(eAadhar);
				ppl.setAddress(eAddress);
				ppl.setZone_id(eZone);
				ppl.setAccount_no(eAccount);

				consumerList.add(ppl); // adding data to list
			}

			for (Consumer ppl : consumerList) {
				System.out.println(ppl);
			}

		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}

		return null;

	}

	// distributor registration method
	public String consumerRegistration(Consumer ppl) throws ClassNotFoundException, SQLException, Exception {
		String distributorId = null;
		try {
			Connection connect = NGOConnection.connection(); // get connection from DB
			// String zonecatogue="SELECT state_name, zone_id, district_name FROM location";
			// //query to select location table details

			accountNoAvailableCheck(ppl);
			String query = "INSERT INTO consumer (consumer_name, phone_no, aadhar_no, address, "
					+ "zone_id, account_no) VALUES (?,?,?,?,?,?)";
			PreparedStatement pst = connect.prepareStatement(query);

			// pst.setString(1, "donor_seq.nextval");
			pst.setString(1, ppl.getConsumer_name());
			pst.setLong(2, ppl.getPhone_no());
			pst.setLong(3, ppl.getAadhar_no());
			pst.setString(4, ppl.getAddress());
			pst.setString(5, ppl.getZone_id());
			pst.setLong(6, ppl.getAccount_no());

			Integer row = pst.executeUpdate();
			// System.out.println(row);
			String distributor_id = "SELECT concat(prefix,c_id) as consumer_id from consumer where phone_no=?";
			PreparedStatement pst1 = connect.prepareStatement(distributor_id);
			pst1.setLong(1, ppl.getPhone_no());
			ResultSet rs = pst1.executeQuery(); // retrieve data from DB
			while (rs.next()) {
				distributorId = rs.getString(1);

			}

		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
		// System.out.println(donorId);

		return distributorId;
	}

	// checking account no from account (bank)
	public Boolean accountNoAvailableCheck(Consumer ppl)
			throws ClassNotFoundException, SQLException, AccountNoNotRegisteredException {
		Connection connect = NGOConnection.connection(); // get connection from DB
		String accountNo = ppl.getAccount_no().toString();
		String account = null;

		String checkAccountNo = "SELECT account_no FROM account";
		PreparedStatement pst2 = connect.prepareStatement(checkAccountNo);
		ResultSet rs2 = pst2.executeQuery(); // retrieve data from DB
		while (rs2.next()) {
			account = rs2.getString(1);

			if (account.equals(accountNo)) {
				return true;

			}

		}
		throw new AccountNoNotRegisteredException();

	}

	// check name contain only character both lower and upper cases
	public Boolean name(Consumer ppl) throws Exception {
		String name = ppl.getConsumer_name();

		String regex1 = "[a-z .A-Z]+";
		Pattern p1 = Pattern.compile(regex1);
		Matcher valid1 = p1.matcher(name);
		Boolean ans1 = valid1.matches();
		if (ans1 == false) {
			throw new InvalidNameException();
			// throw new Exception("Invalid name use only alphabatic sequence in name
			// field!");
		}

		String regex = "^.{3,25}$";
		Pattern p = Pattern.compile(regex);
		Matcher valid = p.matcher(name);
		Boolean ans = valid.matches();
		if (ans == false) {
			throw new InvalidNameLengthException();
		}

		return true;

	}

	// check phone number length not exceed 10 digit and also not null and continue
	// sequence digits
	public Boolean phoneNoLength(Consumer ppl) throws Exception {
		Long phoneNo = ppl.getPhone_no();
		String num = phoneNo.toString();
		String regex = "^(0/91)?[6-9]\\d{9}$";// Initialize the format
		Pattern p = Pattern.compile(regex);
		Matcher valid = p.matcher(num);
		Boolean ans = valid.matches();
		if (ans == false) {
			throw new InvalidPhoneNoException();
		}

		return true;
	}

	// check aadhar number length not exceed 12 digit as well as not null
	public Boolean aadharNo(Consumer ppl) throws Exception {
		Long aadharNo = ppl.getAadhar_no();
		String num = aadharNo.toString();

		String regex = "^[2-9]{1}[0-9]{11}$";// Initialize the format
		Pattern p = Pattern.compile(regex);
		Matcher valid = p.matcher(num);
		Boolean ans = valid.matches();
		if (ans == false) {
			throw new InvalidAadharNoException();
		}

		return true;
	}

	// check address whether length 100 or not
	public Boolean addressLength(Consumer ppl) throws Exception {
		String address = ppl.getAddress();
		if (address.length() < 200) {
			return true;
		} else
			throw new UserAddressLengthException();
		// throw new Exception("Address lenght should not exceed 100 character!");

	}

	

	// check zone id whether length =4
	public Boolean zoneLength(Consumer ppl) throws Exception {
		String zone = ppl.getZone_id();
		if (zone.length() == 4) {
			return true;
		} else
			throw new InvalidZoneLengthException();
		// throw new Exception("Address lenght should not exceed 100 character!");

	}

	// check account number length = 10||13||15||17 digit as well as not null
	public Boolean accountNo(Consumer ppl) throws Exception {
		Long accountNo = ppl.getAccount_no();

		String num = accountNo.toString();
		// ^([0-9]{10}|[0-9]{13}|[0-9]{17})$’
		String regex = "^([0-9]{10}|[0-9]{13}|[0-9]{15}|[0-9]{17})$";// Initialize the format

		Pattern p = Pattern.compile(regex);
		Matcher valid = p.matcher(num);
		Boolean ans = valid.matches();
		if (ans == false) {
			throw new InvalidAccountNoException();
		}

		return true;
	}

// donation start
	// get donation details
	public String donationDetails(Distributor emp) throws ClassNotFoundException, SQLException {
		try {
			Connection connect = NGOConnection.connection();
			String staffId1 = staffZoneId(emp);
			String donationDetail = "SELECT CONCAT(prefix,h_id) as donation_id, staff_id,consumer_id,stock_id,"
					+ "quantity,fund_amount,description,donation_date,approved_by,approval_status,zone_id "
					+ "FROM donation where zone_id=?"; // query to get consumer details

			PreparedStatement pst = connect.prepareStatement(donationDetail);
			pst.setString(1, staffId1);
			ResultSet rs = pst.executeQuery(); // retrieve data from DB

			ArrayList<Donation> donationList = new ArrayList<>(); // creating array list to store values
			// locally
			while (rs.next()) {
				String donationId = rs.getString(1);
				String staffId = rs.getString(2);
				String consumerId = rs.getString(3);
				String stockId = rs.getString(4);
				Integer quantity = rs.getInt(5);
				Float fundAmount = rs.getFloat(6);
				String description = rs.getString(7);
				String donationDate = rs.getString(8);
				String managerId = rs.getString(9);
				String status = rs.getString(10);
				String zoneId = rs.getString(11);

				Donation donation = new Donation();
				// setting value in object
				donation.setDonationId(donationId);
				donation.setStaffId(staffId);
				donation.setConsumerId(consumerId);
				donation.setStockId(stockId);
				donation.setQuantity(quantity);
				donation.setFundAmount(fundAmount);
				donation.setDescription(description);
				donation.setDonationDate(donationDate);
				donation.setApprovedBy(managerId);
				donation.setApprovalStatus(status);
				donation.setZoneId(zoneId);

				donationList.add(donation); // adding data to list
			}

			for (Donation donation : donationList) {
				System.out.println(donation);
			}

			pst.close();

		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}

		return null;

	}

//staff zone Id
	// get staff zone id by staff id
	public String staffZoneId(Distributor emp) throws ClassNotFoundException, SQLException {
		Connection connect = NGOConnection.connection();
		String empId = emp.getDistributor_id();
		String getStaffZoneId = null;

		// query to get zone_ id by staff id

		String staffZoneIdquery = "select concat(prefix,s_id) as staff_id,zone_id from distributor";
		PreparedStatement staffZonePst = connect.prepareStatement(staffZoneIdquery);
		ResultSet zoneId = staffZonePst.executeQuery(); // retrieve data from DB
		while (zoneId.next()) {
			if (empId.equals(zoneId.getString(1))) // check staff id with database
			{
				getStaffZoneId = zoneId.getString(2);
			}
		}
		zoneId.close();
		return getStaffZoneId;
	}

// stock start
	// get stock details respect to Distributor zone id
	public String stockDetailsByZoneId(Distributor emp) throws ClassNotFoundException, SQLException {
		try {
			Connection connect = NGOConnection.connection();
			String empId = emp.getDistributor_id();
			String staffZoneId = staffZoneId(emp);
			String warehouseId = null;

			// query to get warehouseId by zone Id
			String warehouseZoneIdquery = "SELECT CONCAT(prefix,w_id)as warehouse_id, zone_id FROM warehouse";
			PreparedStatement warehouseZonePst = connect.prepareStatement(warehouseZoneIdquery);
			ResultSet wZoneId = warehouseZonePst.executeQuery(); // retrieve data from DB
			while (wZoneId.next()) {
				if (staffZoneId.equals(wZoneId.getString(2))) // check zone id with database
				{
					warehouseId = wZoneId.getString(1);
				}
			}

			wZoneId.close();

			// query to get stock details by warehouse id
			String stockDetail = "SELECT CONCAT (prefix,s_id) as stock_id, stock_name, quantity, "
					+ "staff_id,warehouse_id FROM stock where warehouse_id=?"; // query to get stock details
			PreparedStatement stockDetailsPst = connect.prepareStatement(stockDetail);
			stockDetailsPst.setString(1, warehouseId); // set warehouse id to query

			ResultSet rs = stockDetailsPst.executeQuery(); // retrieve data from DB
			ArrayList<StockDetails> stockList = new ArrayList<>(); // creating array list to store values
			// locally
			while (rs.next()) {
				String stockId = rs.getString(1);
				String stockName = rs.getString(2);
				Integer quantity = rs.getInt(3);
				String staffId = rs.getString(4);
				String wareHouseId = rs.getString(5);

				StockDetails stock = new StockDetails();
				// setting value in object
				stock.setStockId(stockId);
				stock.setStockName(stockName);
				stock.setQuantity(quantity);
				stock.setStaffId(staffId);
				stock.setWareHouseId(wareHouseId);

				stockList.add(stock); // adding data to list
			}

			for (StockDetails stock : stockList) {
				System.out.println(stock);
			}

		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}

		return null;

	}

//Donation register
	// Donation application method
	public String makeDonation(Donation donate) throws ClassNotFoundException, SQLException, Exception {

		try {
			Connection connect = NGOConnection.connection(); // get connection from DB

			String mDonate = "INSERT INTO donation (staff_id,consumer_id,stock_id,quantity,fund_amount,description,donation_date,approval_status,zone_id) \r\n"
					+ "VALUES(?,?,?,?,?,?,LOCALTIMESTAMP,'PENDING',?)";
			PreparedStatement mD = connect.prepareStatement(mDonate);

			mD.setString(1, donate.getStaffId());
			mD.setString(2, donate.getConsumerId());
			mD.setString(3, donate.getStockId());
			mD.setInt(4, donate.getQuantity());
			mD.setFloat(5, donate.getFundAmount());
			mD.setString(6, donate.getDescription());
			mD.setString(7, donate.getZoneId());

			mD.executeUpdate(); // execute update the query

		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
		// System.out.println(donorId);

		return null;
	}
}
