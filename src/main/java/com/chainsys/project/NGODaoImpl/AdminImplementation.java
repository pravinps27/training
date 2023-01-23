package com.chainsys.project.NGODaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.chainsys.project.NGO.Account;
import com.chainsys.project.NGO.Admin;
import com.chainsys.project.NGO.Consumer;
import com.chainsys.project.NGO.Distributor;
import com.chainsys.project.NGO.DistributorDetails;
import com.chainsys.project.NGO.Donation;
import com.chainsys.project.NGO.DonationDetails;
import com.chainsys.project.NGO.DonationHistory;
import com.chainsys.project.NGO.Donor;
import com.chainsys.project.NGO.DonorDetails;
import com.chainsys.project.NGO.Fund;
import com.chainsys.project.NGO.Location;
import com.chainsys.project.NGO.Management;
import com.chainsys.project.NGO.SellerDetails;
import com.chainsys.project.NGO.StockDetails;
import com.chainsys.project.NGO.Transaction;
import com.chainsys.project.NGO.WarehouseDetails;
import com.chainsys.project.NGODBConnection.NGOConnection;
import com.chainsys.project.NGODao.AdminInterface;
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

public class AdminImplementation implements AdminInterface {

	// login method
	public Boolean adminLogin(Admin admin) throws SQLException, Exception {
		try {
			Connection connect = NGOConnection.connection(); // get connection from DB
			String adminId = admin.getAdminId();
			String adminPassword = admin.getAdminPassword();
			String login = "SELECT admin_id,password FROM admin";
			PreparedStatement pst = connect.prepareStatement(login);
			ResultSet rs = pst.executeQuery(); // retrieve data from DB
			while (rs.next()) {
				String adminId1 = rs.getString(1);
				if (adminId1.equals(adminId)) {
					String donorPassword = rs.getString(2);
					if (donorPassword.equals(adminPassword)) // checking user id and password equal
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
	public Boolean userIdLength(Admin admin) throws Exception {
		String userId = admin.getAdminId();
		if (userId.length() == 4) {
			return true;
		} else
			throw new InvalidUserIdException();
		// throw new Exception("Address lenght should not exceed 100 character!");

	}

	// check password whether length between 5 to 20
	public Boolean passwordLength(Admin admin) throws Exception {
		String password = admin.getAdminPassword();
		if (password.length() > 4 && password.length() < 20) {
			return true;
		} else
			throw new InvalidPasswordLengthException();
		// throw new Exception("Address lenght should not exceed 100 character!");

	}

	// get donator details
	public String donatorDetails(Admin admin) throws ClassNotFoundException, SQLException {
		try {
			Connection connect = NGOConnection.connection();
			String zonecatogue = "SELECT concat (prefix,d_id) as donor_id,donor_name,phone_no,"
					+ "aadhar_no,mail_id,address,password,zone_id,account_no FROM donator"; // query to select location
																							// table details
			PreparedStatement pst = connect.prepareStatement(zonecatogue);
			ResultSet rs = pst.executeQuery(); // retrieve data from DB
			ArrayList<DonorDetails> donorList = new ArrayList<>(); // creating array list to store values locally
			while (rs.next()) {
				String donorId = rs.getString(1);
				String dName = rs.getString(2);
				Long dPhone = rs.getLong(3);
				Long dAadhar = rs.getLong(4);
				String dMail = rs.getString(5);
				String dAddress = rs.getString(6);
				String dPassword = rs.getString(7);
				String dZone = rs.getString(8);
				Long dAccount = rs.getLong(9);

				DonorDetails donor = new DonorDetails();
				// setting value in object
				donor.setDonator_id(donorId);
				donor.setDonator_name(dName);
				donor.setPhone_no(dPhone);
				donor.setAadhar_no(dAadhar);
				donor.setMail_id(dMail);
				donor.setAddress(dAddress);
				donor.setPassword(dPassword);
				donor.setZone_id(dZone);
				donor.setAccount_no(dAccount);

				donorList.add(donor); // adding data to list
			}

			for (DonorDetails donor : donorList) {
				System.out.println(donor);
			}

		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}

		return null;

	}

	// get fund details
	public String fundDetails(Admin admin) throws ClassNotFoundException, SQLException {
		try {
			Connection connect = NGOConnection.connection();
			String fundDetails = "SELECT CONCAT(prefix,f_id) AS fund_id, fund_amount, donor_account_no, "
					+ "donation_date FROM fund"; // query to select fund details

			PreparedStatement pst = connect.prepareStatement(fundDetails);
			ResultSet rs = pst.executeQuery(); // retrieve data from DB
			ArrayList<Fund> fundList = new ArrayList<>(); // creating array list to store values locally
			while (rs.next()) {
				String fundId = rs.getString(1);
				Float fundAmount = rs.getFloat(2);
				Long dAccountNo = rs.getLong(3);
				String date = rs.getString(4);

				Fund fund = new Fund();
				// setting value in object
				fund.setFundId(fundId);
				fund.setFundAmount(fundAmount);
				fund.setDonorAccountNo(dAccountNo);
				fund.setDate(date);

				fundList.add(fund); // adding data to list
			}

			for (Fund fund : fundList) {
				System.out.println(fund);
			}

		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}

		return null;

	}

	// get admin name with admin id in the table
	public String getAdminName(Admin admin) throws ClassNotFoundException, SQLException {
		Connection connect = NGOConnection.connection(); // get connection from DB
		String adminId = admin.getAdminId();
		String adminName = null;
		String query = "SELECT admin_id,admin_name FROM admin";
		PreparedStatement pst = connect.prepareStatement(query);
		ResultSet rs = pst.executeQuery(); // retrieve data from DB
		while (rs.next()) {
			String donorId1 = rs.getString(1);
			if (donorId1.equals(adminId)) {
				adminName = rs.getString(2); // getting donor name by checking given donor id

			}
		}
		return adminName;

	}

	// get account details
	public String accountDetails(Admin admin) throws ClassNotFoundException, SQLException {
		try {
			Connection connect = NGOConnection.connection();
			String accountDetail = "SELECT account_no,a_holder_name,balance FROM account where account_no=1227101051526";
			PreparedStatement pst = connect.prepareStatement(accountDetail);
			ResultSet rs = pst.executeQuery(); // retrieve data from DB
			ArrayList<Account> accountDetails = new ArrayList<>(); // creating array list to store values locally
			while (rs.next()) {
				Long dAccountNo = rs.getLong(1);
				String holderName = rs.getString(2);
				Float balance = rs.getFloat(3);

				Account account = new Account();
				// setting value in object
				account.setAccountNo(dAccountNo);
				account.setHolderName(holderName);
				account.setBalance(balance);

				accountDetails.add(account); // adding data to list
			}

			for (Account account : accountDetails) {
				System.out.println(account);
			}

		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}

		return null;
	}

	// check foundation account details
	public String transactionDetails(Admin admin) throws ClassNotFoundException, SQLException {
		try {
			Connection connect = NGOConnection.connection();
			String transactionDetail = "SELECT transaction_date, account_no, transaction_type, amount FROM transaction";
			PreparedStatement pst = connect.prepareStatement(transactionDetail);
			ResultSet rs = pst.executeQuery(); // retrieve data from DB
			ArrayList<Transaction> transactionDetails = new ArrayList<>(); // creating array list to store values
																			// locally
			while (rs.next()) {
				String date = rs.getString(1);
				Long accountNo = rs.getLong(2);
				String transactionType = rs.getString(3);
				Float amount = rs.getFloat(4);

				Transaction transaction = new Transaction();
				// setting value in object
				transaction.setDate(date);
				transaction.setAccontNo(accountNo);
				transaction.setTransactionType(transactionType);
				transaction.setAmount(amount);

				transactionDetails.add(transaction); // adding data to list
			}

			for (Transaction transaction : transactionDetails) {
				System.out.println(transaction);
			}

		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

//manager details starts

	// get manager details
	public String managerDetails(Admin admin) throws ClassNotFoundException, SQLException {
		try {
			Connection connect = NGOConnection.connection();
			String managerDetail = "SELECT concat(prefix,m_id) as manager_id,manager_name, phone_no, "
					+ "aadhar_no, password, address, zone_id, account_no FROM management"; // query to select manager
			// details

			PreparedStatement pst = connect.prepareStatement(managerDetail);
			ResultSet rs = pst.executeQuery(); // retrieve data from DB
			ArrayList<Management> managerList = new ArrayList<>(); // creating array list to store values locally
			while (rs.next()) {
				String managerId = rs.getString(1);
				String mName = rs.getString(2);
				Long mPhone = rs.getLong(3);
				Long mAadhar = rs.getLong(4);
				String mPassword = rs.getString(5);
				String mAddress = rs.getString(6);
				String mZone = rs.getString(7);
				Long mAccount = rs.getLong(8);
				// String mMail = rs.getString(5);

				Management manager = new Management();
				// setting value in object
				manager.setManager_id(managerId);
				manager.setManager_name(mName);
				manager.setPhone_no(mPhone);
				manager.setAadhar_no(mAadhar);
				// manager.setMail_id(mMail);
				manager.setAddress(mAddress);
				manager.setPassword(mPassword);
				manager.setZone_id(mZone);
				manager.setAccount_no(mAccount);

				managerList.add(manager); // adding data to list
			}

			for (Management manager : managerList) {
				System.out.println(manager);
			}

		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}

		return null;

	}

	// management registration method
	public String managerRegistration(Management manager) throws ClassNotFoundException, SQLException, Exception {
		String managerId = null;
		try {
			Connection connect = NGOConnection.connection(); // get connection from DB
			// String zonecatogue="SELECT state_name, zone_id, district_name FROM location";
			// //query to select location table details

			accountNoAvailableCheck(manager);
			String query = "INSERT INTO management(manager_name, phone_no, aadhar_no, password, mail_id, "
					+ "address, zone_id, account_no) VALUES(?,?,?,?,?,?,?,?)";
			PreparedStatement pst = connect.prepareStatement(query);

			// pst.setString(1, "donor_seq.nextval");
			pst.setString(1, manager.getManager_name());
			pst.setLong(2, manager.getPhone_no());
			pst.setLong(3, manager.getAadhar_no());
			pst.setString(4, manager.getPassword());
			pst.setString(5, manager.getMail_id());
			pst.setString(6, manager.getAddress());
			pst.setString(7, manager.getZone_id());
			pst.setLong(8, manager.getAccount_no());

			Integer row = pst.executeUpdate();
			// System.out.println(row);
			String manager_id = "SELECT concat(prefix,m_id) as manager_id from management where phone_no=?";
			PreparedStatement pst1 = connect.prepareStatement(manager_id);
			pst1.setLong(1, manager.getPhone_no());
			ResultSet rs = pst1.executeQuery(); // retrieve data from DB
			while (rs.next()) {
				managerId = rs.getString(1);

			}

		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
		// System.out.println(donorId);

		return managerId;
	}

	// checking account no from account (bank)
	public Boolean accountNoAvailableCheck(Management manager)
			throws ClassNotFoundException, SQLException, AccountNoNotRegisteredException {
		Connection connect = NGOConnection.connection(); // get connection from DB
		String accountNo = manager.getAccount_no().toString();
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

	// check mail id whether already present or not in the records
	public Boolean mailCheck(Management manager) throws Exception {
		Connection connect = NGOConnection.connection(); // get connection from DB

		String query = "SELECT mail_id FROM management";
		PreparedStatement pst = connect.prepareStatement(query);
		ResultSet rs = pst.executeQuery(); // retrieve data from DB
		while (rs.next()) {
			String mail = rs.getString(1);
			if (mail.equals(manager.getMail_id())) {
				throw new DuplicateMailIdException();
				// throw new Exception("given mail Id is already exits try with different mail
				// Id!");

			}
		}
		return true;
	}

	// check name contain only character both lower and upper cases
	public Boolean name(Management manager) throws Exception {
		String name = manager.getManager_name();

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

	// check mail id contains minimum 3 character front of '@' and after minimum 5
	// character must contain '.'
	public Boolean email(Management manager) throws Exception {
		String mail = manager.getMail_id();
		String regex = "^(.+)\\w{3,8}@\\w{5,15}(.+)$?";

		Pattern p = Pattern.compile(regex);
		Matcher valid = p.matcher(mail);
		Boolean ans = valid.matches();
		if (ans == false) {
			throw new InvalidMailIdException();
			// throw new Exception("Invalid email format mail id must contain @!");
		}
		return ans;

	}

	// check phone number length not exceed 10 digit and also not null and continue
	// sequence digits
	public Boolean phoneNoLength(Management manager) throws Exception {
		Long phoneNo = manager.getPhone_no();
		String num = phoneNo.toString();
		String regex = "^(0/91)?[6-9]\\d{9}$";// Initialize the format
		Pattern p = Pattern.compile(regex);
		Matcher valid = p.matcher(num);
		Boolean ans = valid.matches();
		if (ans == false) {
			throw new InvalidPhoneNoException();
		}
		/*
		 * if (num.length() > 10 || num.length() < 10 || num.equals("0000000000") ||
		 * num.equals("1111111111") || num.equals("2222222222") ||
		 * num.equals("3333333333") || num.equals("4444444444") ||
		 * num.equals("5555555555") || num.equals("6666666666") ||
		 * num.equals("7777777777") || num.equals("8888888888") ||
		 * num.equals("9999999999")) { throw new Exception("Invalid phone number!"); }
		 * else
		 */
		return true;
	}

	// check aadhar number length not exceed 12 digit as well as not null
	public Boolean aadharNo(Management manager) throws Exception {
		Long aadharNo = manager.getAadhar_no();
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
	public Boolean addressLength(Management manager) throws Exception {
		String address = manager.getAddress();
		if (address.length() < 200) {
			return true;
		} else
			throw new UserAddressLengthException();
		// throw new Exception("Address lenght should not exceed 100 character!");

	}

	// check password whether length between 5 to 20
	public Boolean passwordLength(Management manager) throws Exception {
		String password = manager.getPassword();
		if (password.length() > 4 && password.length() < 20) {
			return true;
		} else
			throw new InvalidPasswordLengthException();
		// throw new Exception("Address lenght should not exceed 100 character!");

	}

	// check zone id whether length =4
	public Boolean zoneLength(Management manager) throws Exception {
		String zone = manager.getZone_id();
		if (zone.length() == 4) {
			return true;
		} else
			throw new InvalidZoneLengthException();
		// throw new Exception("Address lenght should not exceed 100 character!");

	}

	// check account number length = 10||13||15||17 digit as well as not null
	public Boolean accountNo(Management manager) throws Exception {
		Long accountNo = manager.getAccount_no();

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

// distributor details starts

	// get distributor details
	public String distributorDetails(Admin admin) throws ClassNotFoundException, SQLException {
		try {
			Connection connect = NGOConnection.connection();
			String managerDetail = "SELECT CONCAT(prefix,s_id) as staff_id, staff_name, phone_no, "
					+ "aadhar_no, mail_id, address, password, zone_id, account_no FROM distributor"; // query to select
																										// manager
			// details

			PreparedStatement pst = connect.prepareStatement(managerDetail);
			ResultSet rs = pst.executeQuery(); // retrieve data from DB
			ArrayList<DistributorDetails> distributorList = new ArrayList<>(); // creating array list to store values
																				// locally
			while (rs.next()) {
				String distributorId = rs.getString(1);
				String eName = rs.getString(2);
				Long ePhone = rs.getLong(3);
				Long eAadhar = rs.getLong(4);
				String eMail = rs.getString(5);
				String eAddress = rs.getString(6);
				String ePassword = rs.getString(7);
				String eZone = rs.getString(8);
				Long eAccount = rs.getLong(9);

				DistributorDetails emp = new DistributorDetails();
				// setting value in object
				emp.setDistributor_id(distributorId);
				emp.setDistributor_name(eName);
				emp.setPhone_no(ePhone);
				emp.setAadhar_no(eAadhar);
				emp.setMail_id(eMail);
				emp.setAddress(eAddress);
				emp.setPassword(ePassword);
				emp.setZone_id(eZone);
				emp.setAccount_no(eAccount);

				distributorList.add(emp); // adding data to list
			}

			for (DistributorDetails emp : distributorList) {
				System.out.println(emp);
			}

		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}

		return null;

	}

	// distributor registration method
	public String distributorRegistration(Distributor emp) throws ClassNotFoundException, SQLException, Exception {
		String distributorId = null;
		try {
			Connection connect = NGOConnection.connection(); // get connection from DB
			// String zonecatogue="SELECT state_name, zone_id, district_name FROM location";
			// //query to select location table details

			accountNoAvailableCheck(emp);
			String query = "INSERT INTO distributor (staff_name, phone_no, aadhar_no, mail_id, address, password, "
					+ "zone_id, account_no) VALUES (?,?,?,?,?,?,?,?)";
			PreparedStatement pst = connect.prepareStatement(query);

			// pst.setString(1, "donor_seq.nextval");
			pst.setString(1, emp.getDistributor_name());
			pst.setLong(2, emp.getPhone_no());
			pst.setLong(3, emp.getAadhar_no());
			pst.setString(4, emp.getMail_id());
			pst.setString(5, emp.getAddress());
			pst.setString(6, emp.getPassword());
			pst.setString(7, emp.getZone_id());
			pst.setLong(8, emp.getAccount_no());

			Integer row = pst.executeUpdate();
			// System.out.println(row);
			String distributor_id = "SELECT concat(prefix,s_id) as staff_id from distributor where phone_no=?";
			PreparedStatement pst1 = connect.prepareStatement(distributor_id);
			pst1.setLong(1, emp.getPhone_no());
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
	public Boolean accountNoAvailableCheck(Distributor emp)
			throws ClassNotFoundException, SQLException, AccountNoNotRegisteredException {
		Connection connect = NGOConnection.connection(); // get connection from DB
		String accountNo = emp.getAccount_no().toString();
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

	// check mail id whether already present or not in the records
	public Boolean mailCheck(Distributor emp) throws Exception {
		Connection connect = NGOConnection.connection(); // get connection from DB

		String query = "SELECT mail_id FROM distributor";
		PreparedStatement pst = connect.prepareStatement(query);
		ResultSet rs = pst.executeQuery(); // retrieve data from DB
		while (rs.next()) {
			String mail = rs.getString(1);
			if (mail.equals(emp.getMail_id())) {
				throw new DuplicateMailIdException();
				// throw new Exception("given mail Id is already exits try with different mail
				// Id!");

			}
		}
		return true;
	}

	// check name contain only character both lower and upper cases
	public Boolean name(Distributor emp) throws Exception {
		String name = emp.getDistributor_name();

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

	// check mail id contains minimum 3 character front of '@' and after minimum 5
	// character must contain '.'
	public Boolean email(Distributor emp) throws Exception {
		String mail = emp.getMail_id();
		String regex = "^(.+)\\w{3,8}@\\w{5,15}(.+)$?";

		Pattern p = Pattern.compile(regex);
		Matcher valid = p.matcher(mail);
		Boolean ans = valid.matches();
		if (ans == false) {
			throw new InvalidMailIdException();
			// throw new Exception("Invalid email format mail id must contain @!");
		}
		return ans;

	}

	// check phone number length not exceed 10 digit and also not null and continue
	// sequence digits
	public Boolean phoneNoLength(Distributor emp) throws Exception {
		Long phoneNo = emp.getPhone_no();
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
	public Boolean aadharNo(Distributor emp) throws Exception {
		Long aadharNo = emp.getAadhar_no();
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
	public Boolean addressLength(Distributor emp) throws Exception {
		String address = emp.getAddress();
		if (address.length() < 200) {
			return true;
		} else
			throw new UserAddressLengthException();
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

	// check zone id whether length =4
	public Boolean zoneLength(Distributor emp) throws Exception {
		String zone = emp.getZone_id();
		if (zone.length() == 4) {
			return true;
		} else
			throw new InvalidZoneLengthException();
		// throw new Exception("Address lenght should not exceed 100 character!");

	}

	// check account number length = 10||13||15||17 digit as well as not null
	public Boolean accountNo(Distributor emp) throws Exception {
		Long accountNo = emp.getAccount_no();

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

//consumer start

	// get consumer details
	public String consumerDetails(Admin admin) throws ClassNotFoundException, SQLException {
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

			for (Consumer emp : consumerList) {
				System.out.println(emp);
			}

		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}

		return null;

	}

//donation start
	// get donation details
	public String donationDetails(Admin admin) throws ClassNotFoundException, SQLException {
		try {
			Connection connect = NGOConnection.connection();
			String donationDetail = "SELECT CONCAT(prefix,h_id) as donation_id, staff_id,consumer_id,stock_id,"
					+ "quantity,fund_amount,description,donation_date,approved_by,approval_status,zone_id "
					+ "FROM donation"; // query to get consumer details

			PreparedStatement pst = connect.prepareStatement(donationDetail);
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

//stock start
	// get stock details
	public String stockDetails(Admin admin) throws ClassNotFoundException, SQLException {
		try {
			Connection connect = NGOConnection.connection();
			String donationDetail = "SELECT CONCAT (prefix,s_id) as stock_id, stock_name, quantity, "
					+ "staff_id,warehouse_id FROM stock"; // query to get stock details

			PreparedStatement pst = connect.prepareStatement(donationDetail);
			ResultSet rs = pst.executeQuery(); // retrieve data from DB
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

// warehouse start
	// get warehouse details
	public String warehouseDetails(Admin admin) throws ClassNotFoundException, SQLException {
		try {
			Connection connect = NGOConnection.connection();
			String donationDetail = "SELECT CONCAT(prefix,w_id)as warehouse_id, location," + " zone_id FROM warehouse"; // query
																														// to
																														// get
																														// stock
																														// details

			PreparedStatement pst = connect.prepareStatement(donationDetail);
			ResultSet rs = pst.executeQuery(); // retrieve data from DB
			ArrayList<WarehouseDetails> warehouseList = new ArrayList<>(); // creating array list to store values
			// locally
			while (rs.next()) {
				String warehouseId = rs.getString(1);
				String location = rs.getString(2);
				String zoneId = rs.getString(3);

				WarehouseDetails warehouse = new WarehouseDetails();
				// setting value in object
				warehouse.setWarehouseId(warehouseId);
				warehouse.setLocation(location);
				warehouse.setZoneId(zoneId);

				warehouseList.add(warehouse); // adding data to list
			}

			for (WarehouseDetails warehouse : warehouseList) {
				System.out.println(warehouse);
			}

		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}

		return null;

	}

// seller start
	// get seller details
	public String sellerDetails(Admin admin) throws ClassNotFoundException, SQLException {
		try {
			Connection connect = NGOConnection.connection();
			String sellerDetail = "SELECT seller_id, seller_name, phone, aadhar_no, pan, shop_name, "
					+ "gst_no, mail_id, address, zone_id, account_no FROM seller"; // query to get seller details

			PreparedStatement pst = connect.prepareStatement(sellerDetail);
			ResultSet rs = pst.executeQuery(); // retrieve data from DB
			ArrayList<SellerDetails> sellerList = new ArrayList<>(); // creating array list to store values
			// locally
			while (rs.next()) {
				String sellerId = rs.getString(1);
				String sName = rs.getString(2);
				Long sPhone = rs.getLong(3);
				Long sAadhar = rs.getLong(4);
				String sPan = rs.getString(5);
				String shopName = rs.getString(6);
				String gst = rs.getString(7);
				String sMailId = rs.getString(8);
				String address = rs.getString(9);
				String zone = rs.getString(10);
				Long accountNo = rs.getLong(11);

				SellerDetails seller = new SellerDetails();
				// setting value in object

				seller.setSellerId(sellerId);
				seller.setSellerName(sName);
				seller.setPhoneNo(sPhone);
				seller.setAadharNo(sAadhar);
				seller.setPanNo(sPan);
				seller.setShopName(shopName);
				seller.setGSTNo(gst);
				seller.setMailId(sMailId);
				seller.setAddress(address);
				seller.setZoneId(zone);
				seller.setAccountNo(accountNo);

				sellerList.add(seller); // adding data to list
			}

			for (SellerDetails seller : sellerList) {
				System.out.println(seller);
			}

		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}

		return null;

	}

// Donation history starts
	// get Donation history details
	public String donationHistory(Admin admin) throws ClassNotFoundException, SQLException {
		try {
			Connection connect = NGOConnection.connection();
			String managerDetail = "select concat(prefix,h_id) as history_id,zone_id,donation_year,no_of_civilians,"
					+ "donation_cause,donation_expenses from donation_history"; // query to select donation history

			PreparedStatement pst = connect.prepareStatement(managerDetail);
			ResultSet rs = pst.executeQuery(); // retrieve data from DB
			ArrayList<DonationHistory> donationHistory = new ArrayList<>(); // creating array list to store values
																			// locally

			while (rs.next()) {
				String historyId = rs.getString(1);
				String zoneId = rs.getString(2);
				String donationYear = rs.getString(3);
				Integer noOfCivilians = rs.getInt(4);
				String cause = rs.getString(5);
				Float expenses = rs.getFloat(6);

				DonationHistory don = new DonationHistory();
				// setting value in object
				don.setHistoryId(historyId);
				don.setZoneId(zoneId);
				don.setDonationYear(donationYear);
				don.setNoOfCivilians(noOfCivilians);
				don.setDonationCause(cause);
				don.setDonationExpenses(expenses);

				donationHistory.add(don); // adding data to list
			}

			for (DonationHistory don : donationHistory) {
				System.out.println(don);
			}

		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}

		return null;

	}
}
