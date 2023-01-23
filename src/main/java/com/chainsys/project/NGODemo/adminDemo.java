package com.chainsys.project.NGODemo;

import java.util.Scanner;

import com.chainsys.project.NGO.Admin;
import com.chainsys.project.NGO.Distributor;
import com.chainsys.project.NGO.Fund;
import com.chainsys.project.NGO.Management;
import com.chainsys.project.NGODaoImpl.AdminImplementation;

public class adminDemo {

	public static void main(String[] args) throws Exception {
		Scanner ps = new Scanner(System.in);
		Admin admin = new Admin();
		Fund fund = new Fund();
		AdminImplementation adminImpl = new AdminImplementation();
		Management manager = new Management();
		Distributor emp = new Distributor();
		System.out.println("***Admin page***");
		System.out.println("Enter Admin Id to login:");
		String adminId = ps.next(); 
		admin.setAdminId(adminId);
		adminImpl.userIdLength(admin); // checking user id length =4

		System.out.println("Enter password to continue:");
		String adminPassword = ps.next();
		admin.setAdminPassword(adminPassword);
		adminImpl.passwordLength(admin); // checking password length between 5 to 20

		adminImpl.adminLogin(admin); // login method

		System.out.println("Welcome to seetha foundation.");
		System.out.println("Logged in as admin role.");
		System.out.println("User name: " + adminImpl.getAdminName(admin));
		System.out.println();
		System.out.println(" 1.Fund details \n 2.Account details \n 3.Management details "
				+ "\n 4.Distributor details \n 5.Consumer details \n 6.Donation details "
				+ "\n 7.Stock details \n 8.Warehouse details \n 9.Seller details \n 10.Donation history");
		String empty = ps.nextLine();
		String responce = ps.nextLine();
		switch (responce) {
		case "1":
			System.out.println("*** Fund details ***");
			System.out.println(" 1.Donator information \n 2.Fund information");
			String option = ps.next();
			switch (option) {
			case "1":
				adminImpl.donatorDetails(admin); // get donor details using this method
				break;
			case "2":
				adminImpl.fundDetails(admin); // get fund details using this method
				break;
			default:
				System.out.println("choose valid choice!");
			}
			break;
		case "2":
			System.out.println("*** Account details ***");
			System.out.println(" 1.Account details \n 2.Transaction details");
			String option1 = ps.next();
			switch (option1) {
			case "1":
				adminImpl.accountDetails(admin); // get account details using this method
				break;
			case "2":
				adminImpl.transactionDetails(admin); // get fund details using this method
				break;
			default:
				System.out.println("choose valid choice!");
			}
			break;

		case "3":
			System.out.println("*** Management details***");
			System.out.println(" 1.Register new manager \n 2.View management details");
			String option3 = ps.next();
			switch (option3) {
			case "1":
				// start
				System.out.println("Enter details about manager.");
				System.out.println();
				System.out.println("Employee Name :");
				String fullLine = ps.nextLine();
				String name = ps.nextLine();
				manager.setManager_name(name);
				adminImpl.name(manager); // name validation

				System.out.println("Employee Phone Number :");
				Long phoneNo = ps.nextLong();
				manager.setPhone_no(phoneNo);
				adminImpl.phoneNoLength(manager); // phone number length validation

				System.out.println("Employee Aadhar Number :");
				Long aadharNo = ps.nextLong();
				manager.setAadhar_no(aadharNo);
				adminImpl.aadharNo(manager); // aadhar number length validation

				System.out.println("Employee mail id :");
				String mailId = ps.next();
				manager.setMail_id(mailId);
				adminImpl.email(manager); // mail id validation
				adminImpl.mailCheck(manager); // checking given mail id already exit or not

				System.out.println("Employee location :");
				String fullLine2 = ps.nextLine();
				String address = ps.nextLine();
				manager.setAddress(address);
				adminImpl.addressLength(manager); // address length validation not exceed 100 character

				System.out.println("set Employee password :");
				System.out.println("Make sure password length in the range between 5 to 20");
				String password = ps.nextLine();
				manager.setPassword(password);
				adminImpl.passwordLength(manager); // validate password length

				System.out.println("Employee Zone Id :");
				String zoneId = ps.next();
				manager.setZone_id(zoneId);
				adminImpl.zoneLength(manager); // validate zone id length

				System.out.println("Employee account number :");
				Long accountNo = ps.nextLong();
				manager.setAccount_no(accountNo);
				adminImpl.accountNo(manager); // account number length validation

				// register new manager using this method
				System.out.println("Employee manager_id :" + adminImpl.managerRegistration(manager));
				System.out.println("Welcome to Seetha foundation :" + manager.getManager_name());
				System.out.println("registration successfully");

				break;

			case "2":
				adminImpl.managerDetails(admin); // get manager details using this method
				break;
			default:
				System.out.println("choose valid choice!");
			}
			break;
		case "4":
			System.out.println("***Distributing Employees details***");
			System.out.println();
			System.out.println(" 1.Registor new distributing employee \n 2.View distributing employee details");
			String option4 = ps.next();
			switch (option4) {
			case "1":
				System.out.println("Enter details about employee");
				System.out.println();
				System.out.println("Employee Name :");
				String fullLine = ps.nextLine();
				String name = ps.nextLine();
				emp.setDistributor_name(name);
				adminImpl.name(emp); // name validation

				System.out.println("Employee Phone Number :");
				Long phoneNo = ps.nextLong();
				emp.setPhone_no(phoneNo);
				adminImpl.phoneNoLength(emp); // phone number length validation

				System.out.println("Employee Aadhar Number :");
				Long aadharNo = ps.nextLong();
				emp.setAadhar_no(aadharNo);
				adminImpl.aadharNo(emp); // aadhar number length validation

				System.out.println("Employee mail id :");
				String mailId = ps.next();
				emp.setMail_id(mailId);
				adminImpl.email(emp); // mail id validation
				adminImpl.mailCheck(emp); // checking given mail id already exit or not

				System.out.println("Employee location :");
				String fullLine2 = ps.nextLine();
				String address = ps.nextLine();
				emp.setAddress(address);
				adminImpl.addressLength(emp); // address length validation not exceed 100 character

				System.out.println("Employee Zone Id :");
				String zoneId = ps.next();
				emp.setZone_id(zoneId);
				adminImpl.zoneLength(emp); // validate zone id length

				System.out.println("set Employee password :");
				System.out.println("Make sure password length in the range between 5 to 20");
				String fullLine3 = ps.nextLine();
				String password = ps.nextLine();
				emp.setPassword(password);
				adminImpl.passwordLength(emp); // validate password length

				System.out.println("Employee account number :");
				Long accountNo = ps.nextLong();
				emp.setAccount_no(accountNo);
				adminImpl.accountNo(emp); // account number length validation

				// register new manager using this method
				System.out.println("Employee manager_id :" + adminImpl.distributorRegistration(emp));
				System.out.println("Welcome to Seetha foundation :" + emp.getDistributor_name());
				System.out.println("registration successfully");
				break;

			case "2":

				adminImpl.distributorDetails(admin); // display distributor details from distributor table

				break;

			}
			break;
		case "5":
			adminImpl.consumerDetails(admin);
			break;
		case "6":
			adminImpl.donationDetails(admin);
			break;
		case "7":
			adminImpl.stockDetails(admin);
			break;
		case "8":
			adminImpl.warehouseDetails(admin);
			break;
		case"9":
			adminImpl.sellerDetails(admin);
			break;
		case"10":
			adminImpl.donationHistory(admin);
			break;
		default:
			System.out.println("choose valid choice");
		}
	}

}
