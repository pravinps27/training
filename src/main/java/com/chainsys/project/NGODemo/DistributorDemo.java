package com.chainsys.project.NGODemo;

import java.sql.SQLException;
import java.util.Scanner;

import com.chainsys.project.NGO.Consumer;
import com.chainsys.project.NGO.Distributor;
import com.chainsys.project.NGO.Donation;
import com.chainsys.project.NGODaoImpl.DistributorImplementation;

public class DistributorDemo {

	public static void main(String[] args) throws SQLException, Exception {
		Scanner ps = new Scanner(System.in);
		Consumer ppl = new Consumer();
		Distributor emp = new Distributor();
		DistributorImplementation empImpl = new DistributorImplementation();
		Donation donate = new Donation();
		System.out.println("***emp Page***");
		System.out.println();
		System.out.println("Enter user Id:");
		String empId = ps.next();
		emp.setDistributor_id(empId);	//setting employee id to distributor object
		
		donate.setStaffId(empId);		//setting staff id to donation object
	
		empImpl.userIdLength(emp); // checking user id length =4

		System.out.println("Enter password to continue:");
		String empPassword = ps.next();
		emp.setPassword(empPassword);
		empImpl.passwordLength(emp); // checking password length between 5 to 20

		empImpl.empLogin(emp); // login method

		System.out.println("Welcome to seetha foundation.");
		System.out.println("Logged in as Distribution role.");
		System.out.println("User name: " + empImpl.getempName(emp));
		System.out.println();
		System.out.println(" 1.Donate \n 2.Donation details \n 3.Consumer details \n 4.Local warehouse stock details");
		String empty = ps.nextLine();
		String responce = ps.nextLine();
		switch (responce) {
		case "1":
			System.out.println("Enter details about Civilian");
			System.out.println();
			System.out.println("Civilian Name :");
			// String emptyLine=ps.nextLine();
			String name = ps.nextLine();
			ppl.setConsumer_name(name);
			empImpl.name(ppl); // name validation

			System.out.println("Civilian Phone Number :");
			Long phoneNo = ps.nextLong();
			ppl.setPhone_no(phoneNo);
			empImpl.phoneNoLength(ppl); // phone number length validation

			System.out.println("Civilian Aadhar Number :");
			Long aadharNo = ps.nextLong();
			ppl.setAadhar_no(aadharNo);
			empImpl.aadharNo(ppl); // aadhar number length validation

			System.out.println("Civilian location :");
			String fullLine2 = ps.nextLine();
			String address = ps.nextLine();
			ppl.setAddress(address);
			empImpl.addressLength(ppl); // address length validation not exceed 100 character

			String zoneId = empImpl.staffZoneId(emp);	//get staff zone id to store consumer zone id automatically
			System.out.println("Civilian Zone Id :"+zoneId);
			System.out.println();
			ppl.setZone_id(zoneId);
			empImpl.zoneLength(ppl); // validate zone id length

			System.out.println("Civilian account number :");
			Long accountNo = ps.nextLong();
			ppl.setAccount_no(accountNo);
			empImpl.accountNo(ppl); // account number length validation

			// register new consumer and get consumer id by using this method
			String consumerId=empImpl.consumerRegistration(ppl);
			ppl.setConsumer_id(consumerId);
			donate.setConsumerId(consumerId);

			System.out.println("Civilian user_id :" + ppl.getConsumer_id());
			System.out.println("Welcome to Seetha foundation :" + ppl.getConsumer_name());
			System.out.println("registration successfully");

			System.out.println();
			System.out.println("List of donation things");
			System.out.println();

			empImpl.stockDetailsByZoneId(emp); // show list of stock details to donate

			System.out.println("Add things to donate :");
			String emptyLine = ps.nextLine();
			String things = ps.nextLine();
			donate.setStockId(things);
			
			System.out.println("Nos per things :");
			Integer quantity=ps.nextInt(); 
			donate.setQuantity(quantity);
			
			System.out.println("Fund amount :");
			Float fundAmount=ps.nextFloat();
			donate.setFundAmount(fundAmount);
			
			System.out.println("Enter Description about donation :");
			String empltyLine2=ps.nextLine();
			String description=ps.nextLine();
			donate.setDescription(description);
			
			System.out.println("Donation zone Id :"+zoneId);
			donate.setZoneId(zoneId);
			empImpl.makeDonation(donate);
			System.out.println("Donation status : on progress...");
			System.out.println("After management approval donation will done.");

			break;
		case "2":
			empImpl.donationDetails(emp);
			break;
		case "3":
			empImpl.consumerDetails(emp);
			break;
		case "4":
			empImpl.stockDetailsByZoneId(emp);
			break;
		default:
			System.out.println("Please choose available choice!");

		}

	}

}
