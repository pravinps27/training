package com.chainsys.project.NGODemo;

import java.sql.SQLException;
import java.util.Scanner;

import com.chainsys.project.NGO.Distributor;
import com.chainsys.project.NGO.Management;
import com.chainsys.project.NGODaoImpl.ManagementImplementation;

public class ManagementDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, Exception {
		Scanner ps = new Scanner(System.in);
		Management manager = new Management();
		ManagementImplementation managerImpl = new ManagementImplementation();
		Distributor emp = new Distributor();
		System.out.println("***Manager Page***");
		System.out.println();
		System.out.println("Enter user Id:");
		String managerId = ps.next();
		manager.setManager_id(managerId);
		managerImpl.userIdLength(manager); // checking user id length =4

		System.out.println("Enter password to continue:");
		String managerPassword = ps.next();
		manager.setPassword(managerPassword);
		managerImpl.passwordLength(manager); // checking password length between 5 to 20

		managerImpl.managerLogin(manager); // login method

		System.out.println("Welcome to seetha foundation.");
		System.out.println("Logged in as management role.");
		System.out.println("User name: " + managerImpl.getManagerName(manager));
		System.out.println();
		System.out.println(" 1.Fund details \n 2.Distributor details \n 3.Consumer details "
				+ "\n 4.Donation details \n 5.Donation approval \n 6.Stock details \n 7.Warehouse details ");
		String empty = ps.nextLine();
		String responce = ps.nextLine();
		switch (responce) {
		case "1":
			System.out.println("*** Fund details ***");
			System.out.println(" 1.Donator information \n 2.Fund information");
			String option = ps.next();
			switch (option) {
			case "1":
				managerImpl.donatorDetails(manager); // get donor details using this method
				break;
			case "2":
				managerImpl.fundDetails(manager); // get fund details using this method
				break;
			default:
				System.out.println("choose valid choice!");
			}
			break;
		case "2":
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
				managerImpl.name(emp); // name validation

				System.out.println("Employee Phone Number :");
				Long phoneNo = ps.nextLong();
				emp.setPhone_no(phoneNo);
				managerImpl.phoneNoLength(emp); // phone number length validation

				System.out.println("Employee Aadhar Number :");
				Long aadharNo = ps.nextLong();
				emp.setAadhar_no(aadharNo);
				managerImpl.aadharNo(emp); // aadhar number length validation

				System.out.println("Employee mail id :");
				String mailId = ps.next();
				emp.setMail_id(mailId);
				managerImpl.email(emp); // mail id validation
				managerImpl.mailCheck(emp); // checking given mail id already exit or not

				System.out.println("Employee location :");
				String fullLine2 = ps.nextLine();
				String address = ps.nextLine();
				emp.setAddress(address);
				managerImpl.addressLength(emp); // address length validation not exceed 100 character

				System.out.println("Employee Zone Id :");
				String zoneId = ps.next();
				emp.setZone_id(zoneId);
				managerImpl.zoneLength(emp); // validate zone id length

				System.out.println("set Employee password :");
				System.out.println("Make sure password length in the range between 5 to 20");
				String fullLine3 = ps.nextLine();
				String password = ps.nextLine();
				emp.setPassword(password);
				managerImpl.passwordLength(emp); // validate password length

				System.out.println("Employee account number :");
				Long accountNo = ps.nextLong();
				emp.setAccount_no(accountNo);
				managerImpl.accountNo(emp); // account number length validation

				// register new manager using this method
				System.out.println("Employee manager_id :" + managerImpl.distributorRegistration(emp));
				System.out.println("Welcome to Seetha foundation :" + emp.getDistributor_name());
				System.out.println("registration successfully");
				break;

			case "2":

				managerImpl.distributorDetails(manager); // display distributor details from distributor table

				break;

			}
			break;
		case "3":
			managerImpl.consumerDetails(manager); // get consumer details from consumer table
			break;
		case "4":
			managerImpl.donationDetails(manager); // get donation details from donation table

			break;
		case "5":
			managerImpl.donationDetails(manager); // get donation details from donation table
			System.out.println("Make decision");
			System.out.println("\n 1.Approve \n 2.Reject \n 3.Approve later");
			String decision = ps.next();
			switch (decision) {
			case "1":
				managerImpl.donationApproval(manager);
				System.out.println("Approved successfully");
				break;
			case "2":
				managerImpl.donationRejection(manager);
				System.out.println("Donation rejected");
				break;
			case "3":
				break;
			default:
				System.out.println("choose available choice!");
			}

			break;
		case "6":
			System.out.println("**Stock details**");
			System.out.println();
			System.out.println(" 1.View stock details \n 2.View seller details");
			String option5 = ps.next();
			switch (option5) {
			case "1":
				managerImpl.stockDetails(manager); // get stock details from stock table
				break;
			case "2":
				managerImpl.sellerDetails(manager);
				break;
			}
			break;
		case "7":
			managerImpl.warehouseDetails(manager); // get warehouse details from warehouse table
			break;

		default:
			System.out.println("choose valid choice");
		}

	}

}
