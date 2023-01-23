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
import com.chainsys.project.NGO.DonorDetails;
import com.chainsys.project.NGO.Fund;
import com.chainsys.project.NGO.Management;
import com.chainsys.project.NGO.SellerDetails;
import com.chainsys.project.NGO.StockDetails;
import com.chainsys.project.NGO.WarehouseDetails;
import com.chainsys.project.NGODBConnection.NGOConnection;
import com.chainsys.project.NGODao.ManagementInterface;
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

public class ManagementImplementation implements ManagementInterface {

	// login method
	public Boolean managerLogin(Management manager) throws SQLException, Exception {
		try {
			Connection connect = NGOConnection.connection(); // get connection from DB
			String managerId = manager.getManager_id();
			String managerPassword = manager.getPassword();
			String login = "SELECT concat(prefix,m_id) as manager_id, password FROM management";
			PreparedStatement pst = connect.prepareStatement(login);
			ResultSet rs = pst.executeQuery(); // retrieve data from DB
			while (rs.next()) {
				String managerId1 = rs.getString(1);
				if (managerId1.equals(managerId)) {
					String managerPassword1 = rs.getString(2);
					if (managerPassword1.equals(managerPassword)) // checking user id and password equal
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
	public Boolean userIdLength(Management manager) throws Exception {
		String userId = manager.getManager_id();
		if (userId.length() == 4) {
			return true;
		} else
			throw new InvalidUserIdException();
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

	// get manager name with manager id in the table
	public String getManagerName(Management manager) throws ClassNotFoundException, SQLException {
		Connection connect = NGOConnection.connection(); // get connection from DB
		String managerId = manager.getManager_id();
		String managerName = null;
		String query = "SELECT concat(prefix,m_id) as manager_id, manager_name FROM management";
		PreparedStatement pst = connect.prepareStatement(query);
		ResultSet rs = pst.executeQuery(); // retrieve data from DB
		while (rs.next()) {
			String donorId1 = rs.getString(1);
			if (donorId1.equals(managerId)) {
				managerName = rs.getString(2); // getting donor name by checking given donor id

			}
		}
		return managerName;

	}

	// get donator details
	public String donatorDetails(Management manager) throws ClassNotFoundException, SQLException {
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
	public String fundDetails(Management manager) throws ClassNotFoundException, SQLException {
		try {
			Connection connect = NGOConnection.connection();
			String fundDetails = "SELECT CONCAT(prefix,f_id) AS fund_id, fund_amount, donor_account_no, "
					+ "donation_date FROM fund"; // query to get fund details

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

// distributor details starts

	// get distributor details
	public String distributorDetails(Management manager) throws ClassNotFoundException, SQLException {
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
	public String consumerDetails(Management manager) throws ClassNotFoundException, SQLException {
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

// donation start
	// get donation details
	public String donationDetails(Management manager) throws ClassNotFoundException, SQLException {
		try {
			Connection connect = NGOConnection.connection();
			String managerId1 = managerZoneId(manager);
			String donationDetail = "SELECT CONCAT(prefix,h_id) as donation_id, staff_id,consumer_id,stock_id,"
					+ "quantity,fund_amount,description,donation_date,approved_by,approval_status,zone_id "
					+ "FROM donation where zone_id=?"; // query to get consumer details

			PreparedStatement pst = connect.prepareStatement(donationDetail);
			pst.setString(1, managerId1);
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

// stock start
	// get stock details
	public String stockDetails(Management manager) throws ClassNotFoundException, SQLException {
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

// seller start
	// get seller details
	public String sellerDetails(Management manager) throws ClassNotFoundException, SQLException {
		try {
			Connection connect = NGOConnection.connection();
			String sellerDetail = "SELECT seller_id, seller_name, phone, aadhar_no, pan, shop_name,"
					+ " gst_no, mail_id, address, zone_id, account_no FROM seller"; // query to get seller details

			PreparedStatement pst = connect.prepareStatement(sellerDetail);
			ResultSet rs = pst.executeQuery(); // retrieve data from DB
			ArrayList<SellerDetails> sellerList = new ArrayList<>(); // creating array list to store values
			// locally
			while (rs.next()) {
				String sellerId = rs.getString(1);
				String sellerName = rs.getString(2);
				Long phoneNo = rs.getLong(3);
				Long aadharNo = rs.getLong(4);
				String panNo = rs.getString(5);
				String shopName = rs.getString(6);
				String gstNo = rs.getString(7);
				String mailId = rs.getString(8);
				String address = rs.getString(9);
				String zoneId = rs.getString(10);
				Long account = rs.getLong(11);

				SellerDetails seller = new SellerDetails();
				// setting value in object
				seller.setSellerId(sellerId);
				seller.setSellerName(sellerName);
				seller.setPhoneNo(phoneNo);
				seller.setAadharNo(aadharNo);
				seller.setPanNo(panNo);
				seller.setShopName(shopName);
				seller.setGSTNo(gstNo);
				seller.setMailId(mailId);
				seller.setAddress(address);
				seller.setZoneId(zoneId);
				seller.setAccountNo(account);

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

// warehouse start
	// get warehouse details
	public String warehouseDetails(Management manager) throws ClassNotFoundException, SQLException {
		try {
			Connection connect = NGOConnection.connection();
			String donationDetail = "SELECT CONCAT(prefix,w_id)as warehouse_id, location," + "zone_id FROM warehouse"; // query
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

// manager zone Id
	// get manager zone id by staff id
	public String managerZoneId(Management manager) throws ClassNotFoundException, SQLException {
		Connection connect = NGOConnection.connection();
		String managerId = manager.getManager_id();
		String getManagerZoneId = null;

		// query to get zone_ id by staff id
		String managerZoneIdquery = "select concat(prefix,m_id) as manager_id,zone_id from management";
		PreparedStatement managerZonePst = connect.prepareStatement(managerZoneIdquery);
		ResultSet zoneId = managerZonePst.executeQuery(); // retrieve data from DB
		while (zoneId.next()) {
			if (managerId.equals(zoneId.getString(1))) // check staff id with database
			{
				getManagerZoneId = zoneId.getString(2);
			}
		}
		zoneId.close();
		return getManagerZoneId;
	}

// donation approval 
	// approve donation
	public String donationApproval(Management manager) throws ClassNotFoundException, SQLException {
		Connection connect = NGOConnection.connection();
		String managerId = manager.getManager_id();

		// query to update donation approval
		String approval = "UPDATE donation SET approved_by=? , approval_status='approved' "
				+ "where approval_status='PENDING'";
		PreparedStatement approvalPst = connect.prepareStatement(approval);

		approvalPst.setString(1, managerId);
		approvalPst.executeUpdate();
		approvalPst.close();

		
		return null;
	}

// donation rejection 
	// reject donation
	public String donationRejection(Management manager) throws ClassNotFoundException, SQLException {
		Connection connect = NGOConnection.connection();
		String managerId = manager.getManager_id();

		// query to update donation approval
		String reject = "UPDATE donation SET approved_by=? , approval_status='Rejected' "
				+ "where approval_status='PENDING'";
		PreparedStatement approvalPst = connect.prepareStatement(reject);

		approvalPst.setString(1, managerId);
		approvalPst.executeUpdate();
		approvalPst.close();
		return null;
	}
}
