
package com.chainsys.project.NGODaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.chainsys.project.NGO.DistributorDetails;
import com.chainsys.project.NGO.DonationHistory;
import com.chainsys.project.NGO.Donor;
import com.chainsys.project.NGO.Management;
import com.chainsys.project.NGODBConnection.NGOConnection;
import com.chainsys.project.NGODao.DonorInterface;
import com.chainsys.project.exception.*;

public class DonorImplementation implements DonorInterface {

	// registration method
	@Override
	public String registration(Donor donor) throws ClassNotFoundException, SQLException, Exception {
		String donorId = null;
		try {
			Connection connect = NGOConnection.connection(); // get connection from DB
			// String zonecatogue="SELECT state_name, zone_id, district_name FROM location";
			// //query to select location table details

			accountNoAvailableCheck(donor);
			String query = "INSERT INTO donator (D_ID, DONOR_NAME, PHONE_NO, AADHAR_NO, MAIL_ID, ADDRESS, PASSWORD,"
					+ "ZONE_ID, ACCOUNT_NO) VALUES(donor_seq.nextval,?,?,?,?,?,?,?,?)";
			PreparedStatement pst = connect.prepareStatement(query);

			// pst.setString(1, "donor_seq.nextval");
			pst.setString(1, donor.getDonator_name());
			pst.setLong(2, donor.getPhone_no());
			pst.setLong(3, donor.getAadhar_no());
			pst.setString(4, donor.getMail_id());
			pst.setString(5, donor.getAddress());
			pst.setString(6, donor.getPassword());
			pst.setString(7, donor.getZone_id());
			pst.setLong(8, donor.getAccount_no());

			Integer row = pst.executeUpdate();
			// System.out.println(row);
			String donor_id = "SELECT concat(prefix,d_id) as donor_id from donator where phone_no=?";
			PreparedStatement pst1 = connect.prepareStatement(donor_id);
			pst1.setLong(1, donor.getPhone_no());
			ResultSet rs = pst1.executeQuery(); // retrieve data from DB
			while (rs.next()) {
				donorId = rs.getString(1);

			}

		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
		// System.out.println(donorId);

		return donorId;
	}

	// login method
	@Override
	public Boolean login(Donor donor) throws SQLException, Exception {
		try {
			Connection connect = NGOConnection.connection(); // get connection from DB
			String donorId = donor.getDonator_id();
			String dPassword = donor.getPassword();
			String login = "SELECT CONCAT (prefix,d_id) as donor_id, password FROM donator";
			PreparedStatement pst = connect.prepareStatement(login);
			ResultSet rs = pst.executeQuery(); // retrieve data from DB
			while (rs.next()) {
				String donorId1 = rs.getString(1);
				if (donorId1.equals(donorId)) {
					String donorPassword = rs.getString(2);
					if (donorPassword.equals(dPassword)) {
						return true;
					} else {
						throw new IncorrectPasswordException();
						// throw new Exception("password incorrect!");
					}
				}

			}
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
		throw new IncorrectUserIdException();
		// throw new Exception("User Id or password is incorrect!");
	}

	// check mail id whether already present or not in the records
	public Boolean mailCheck(Donor donor) throws Exception {
		Connection connect = NGOConnection.connection(); // get connection from DB

		String query = "SELECT mail_id FROM donator";
		PreparedStatement pst = connect.prepareStatement(query);
		ResultSet rs = pst.executeQuery(); // retrieve data from DB
		while (rs.next()) {
			String mail = rs.getString(1);
			if (mail.equals(donor.getMail_id())) {
				throw new DuplicateMailIdException();
				// throw new Exception("given mail Id is already exits try with different mail
				// Id!");

			}
		}
		return true;
	}

	// checking account no from account (bank)
	public Boolean accountNoAvailableCheck(Donor donor)
			throws ClassNotFoundException, SQLException, AccountNoNotRegisteredException {
		Connection connect = NGOConnection.connection(); // get connection from DB
		String accountNo = donor.getAccount_no().toString();
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

	// get donor name with donor id in the table
	public String getDonorName(Donor donor) throws ClassNotFoundException, SQLException {
		Connection connect = NGOConnection.connection(); // get connection from DB
		String donorId = donor.getDonator_id();
		String donorName = null;
		String query = "SELECT CONCAT (prefix,d_id) as donor_id,donor_name FROM donator";
		PreparedStatement pst = connect.prepareStatement(query);
		ResultSet rs = pst.executeQuery(); // retrieve data from DB
		while (rs.next()) {
			String donorId1 = rs.getString(1);
			if (donorId1.equals(donorId)) {
				donorName = rs.getString(2); // getting donor name by checking given donor id

			}
		}
		return donorName;

	}

	// update fund donation and update transaction details
	@Override
	public Float fundDonation(Donor donor) throws Exception {
		Connection connect = NGOConnection.connection(); // get connection from DB
		String donorId = donor.getDonator_id();
		Float fundAmount = donor.getamount();
		Long donorAccountNo = null;

		// get donator account number from
		String query = "SELECT CONCAT (prefix,d_id) as donor_id,account_no FROM donator";
		PreparedStatement pst = connect.prepareStatement(query);

		ResultSet rs = pst.executeQuery(); // retrieve data from DB
		while (rs.next()) {
			String donorId1 = rs.getString(1);
			if (donorId1.equals(donorId)) {
				donorAccountNo = rs.getLong(2); // getting donor account no. by checking given donor id

			}
		}

		// check balance from their account before donate fund
		if (balanceCheck(donor)) {

			String fund = "INSERT INTO fund (f_id,fund_amount,donor_account_no,donation_date) VALUES (f_id_seq.nextval,?,?,LOCALTIMESTAMP)";
			PreparedStatement pst1 = connect.prepareStatement(fund);
			pst1.setFloat(1, fundAmount);
			pst1.setLong(2, donorAccountNo);
			int row = pst1.executeUpdate();

			Float balance = getBalance(donor); // get balance from account using getBalance method
			Float presentBalance = balance - fundAmount;

			// update donor balance
			String updateBalance = "UPDATE account SET balance=? WHERE account_no=?";
			PreparedStatement pst2 = connect.prepareStatement(updateBalance);
			pst2.setFloat(1, presentBalance);
			pst2.setLong(2, donorAccountNo);
			int row1 = pst2.executeUpdate();

			// get admin balance from account using getAdminBalance method
			Float adminBalance = getAdminBalance(donor);
			Float presentAdminBalance = adminBalance + fundAmount;

			// update admin balance
			String updateAdminBalance = "UPDATE account SET balance=? WHERE account_no=1227101051526";
			PreparedStatement pst3 = connect.prepareStatement(updateAdminBalance);
			pst3.setFloat(1, presentAdminBalance);

			int row2 = pst3.executeUpdate();

			// update TRANSACTION TABLE
			String updateTransaction = "INSERT INTO transaction (transaction_date, account_no, transaction_type, amount, description) VALUES (LOCALTIMESTAMP, ?,?,?,?)";
			PreparedStatement pst4 = connect.prepareStatement(updateTransaction);
			pst4.setLong(1, donorAccountNo);
			pst4.setString(2, "Credited");
			pst4.setFloat(3, fundAmount);
			pst4.setString(4, "Fund");

			int row3 = pst4.executeUpdate();

			return fundAmount;

		} else
			throw new InsufficientFundException();
		// throw new Exception("Insufficient balance to donate kinld");

	}

	// checking balance for particular account no in the account table(bank) for
	// eligible to fund or not
	public Boolean balanceCheck(Donor donor) throws ClassNotFoundException, SQLException, Exception {
		Connection connect = NGOConnection.connection(); // get connection from DB
		String donorId = donor.getDonator_id();
		Float donationAmount = donor.getamount();
		Long donorAccountNo = null;
		String query = "SELECT CONCAT (prefix,d_id) as donor_id,account_no FROM donator";
		PreparedStatement pst = connect.prepareStatement(query);

		ResultSet rs = pst.executeQuery(); // retrieve data from DB
		while (rs.next()) {
			String donorId1 = rs.getString(1);
			if (donorId1.equals(donorId)) {
				donorAccountNo = rs.getLong(2); // getting donor account no by checking given donor id

			}
		}
		String balanceQuery = "SELECT balance FROM account WHERE account_no=?"; // get balance from account by account
																				// number
		PreparedStatement pst1 = connect.prepareStatement(balanceQuery);
		pst1.setLong(1, donorAccountNo);
		ResultSet rs1 = pst1.executeQuery();
		while (rs1.next()) {
			Float availableBalance = rs1.getFloat(1);
			if (availableBalance < donationAmount) {
				// throw new Exception("Insufficient balance to donate");
				return false;
			}
		}

		return true;

	}

	// get balance in account table
	public Float getBalance(Donor donor) throws ClassNotFoundException, SQLException {
		Connection connect = NGOConnection.connection(); // get connection from DB
		String donorId = donor.getDonator_id();
		Float donationAmount = donor.getamount();
		Long donorAccountNo = null;
		Float availableBalance = null;
		String query = "SELECT CONCAT (prefix,d_id) as donor_id,account_no FROM donator";
		PreparedStatement pst = connect.prepareStatement(query);

		ResultSet rs = pst.executeQuery(); // retrieve data from DB
		while (rs.next()) {
			String donorId1 = rs.getString(1);
			if (donorId1.equals(donorId)) {
				donorAccountNo = rs.getLong(2); // getting donor name by checking given donor id

			}
		}
		String balanceQuery = "SELECT balance FROM account WHERE account_no=?"; // get balance from account by account
																				// number
		PreparedStatement pst1 = connect.prepareStatement(balanceQuery);
		pst1.setLong(1, donorAccountNo);
		ResultSet rs1 = pst1.executeQuery();
		while (rs1.next()) {
			availableBalance = rs1.getFloat(1);
		}

		return availableBalance;

	}

	// -get admin balance from account table
	public Float getAdminBalance(Donor donor) throws ClassNotFoundException, SQLException {
		Connection connect = NGOConnection.connection(); // get connection from DB
		Float availableBalance = null;
		String balanceQuery = "SELECT balance FROM account WHERE account_no=1227101051526"; // get balance from account
																							// by account number
		PreparedStatement pst1 = connect.prepareStatement(balanceQuery);

		ResultSet rs1 = pst1.executeQuery();
		while (rs1.next()) {
			availableBalance = rs1.getFloat(1);
		}
		return availableBalance;
	}

	// check name contain only character both lower and upper cases
	public Boolean name(Donor donor) throws Exception {
		String name = donor.getDonator_name();

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
	public Boolean email(Donor donor) throws Exception {
		String mail = donor.getMail_id();
		String regex = "^(.+)\\w{3,8}@\\w{5,10}(.+)$?";

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
	public Boolean phoneNoLength(Donor donor) throws Exception {
		Long phoneNo = donor.getPhone_no();
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
	public Boolean aadharNo(Donor donor) throws Exception {
		Long aadharNo = donor.getAadhar_no();
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
	public Boolean addressLength(Donor donor) throws Exception {
		String address = donor.getAddress();
		if (address.length() < 100) {
			return true;
		} else
			throw new UserAddressLengthException();
		// throw new Exception("Address lenght should not exceed 100 character!");

	}

	// check password whether length between 5 to 20
	public Boolean passwordLength(Donor donor) throws Exception {
		String password = donor.getPassword();
		if (password.length() > 4 && password.length() < 20) {
			return true;
		} else
			throw new InvalidPasswordLengthException();
		// throw new Exception("Address lenght should not exceed 100 character!");

	}

	// check zone id whether length =4
	public Boolean zoneLength(Donor donor) throws Exception {
		String zone = donor.getZone_id();
		if (zone.length() == 4) {
			return true;
		} else
			throw new InvalidZoneLengthException();
		// throw new Exception("Address lenght should not exceed 100 character!");

	}

	// check user id whether length =4
	public Boolean userIdLength(Donor donor) throws Exception {
		String userId = donor.getDonator_id();
		if (userId.length() == 4) {
			return true;
		} else
			throw new InvalidUserIdException();
		// throw new Exception("Address lenght should not exceed 100 character!");

	}

	// check account number length = 10||13||15||17 digit as well as not null
	public Boolean accountNo(Donor donor) throws Exception {
		Long accountNo = donor.getAccount_no();

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

// Donation history starts

	// get Donation history details
	public String donationHistory(Donor donor) throws ClassNotFoundException, SQLException {
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
