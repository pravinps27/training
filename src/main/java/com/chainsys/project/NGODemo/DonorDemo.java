package com.chainsys.project.NGODemo;

import java.sql.SQLException;
import java.util.Scanner;

import com.chainsys.project.NGO.Donor;
import com.chainsys.project.NGODaoImpl.DonorImplementation;
import com.chainsys.project.validation.Validation;

public class DonorDemo {

	public static void main(String[] args) throws Exception {
		Scanner ps=new Scanner(System.in);
		Donor donor=new Donor();
		DonorImplementation donor1=new DonorImplementation();
		
		System.out.println("Welcome to Seetha foundation");
		System.out.println();
		System.out.println("1.Join Us \n2.Donate Fund \n3.View donation history");
		System.out.println();
		String responce; 
		responce=ps.next();
		if(responce.equals("1")||responce.equals("join")||responce.equals("Join")||responce.equals("JOIN")||
				responce.equals("j")||responce.equals("J")) {
			responce="1";
		}
		if(responce.equals("2")||responce.equals("donate")||responce.equals("Donate")||responce.equals("DONATE")||
				responce.equals("d")||responce.equals("D")) {
			responce="2";
		}
		switch(responce) {
		case "1":
		
			//start
			System.out.println("Tell us about yourself");
			System.out.println();
			System.out.println("Your Name :");
			String fullLine=ps.nextLine();
			String name=ps.nextLine();
			donor.setDonator_name(name);
			donor1.name(donor);	//name validation
	
			System.out.println("Your Phone Number :");
			Long phoneNo=ps.nextLong();
			donor.setPhone_no(phoneNo);
			donor1.phoneNoLength(donor);	//phone number length validation
			
			System.out.println("Your Aadhar Number :");
			Long aadharNo=ps.nextLong();
			donor.setAadhar_no(aadharNo);
			donor1.aadharNo(donor);	//aadhar number length validation
			
			System.out.println("Your mail id :");
			String mailId=ps.next();
			donor.setMail_id(mailId);
			donor1.email(donor);		//mail id validation
			donor1.mailCheck(donor);	//checking given mail id already exit or not
			
			System.out.println("Your Address :"); 
			String fullLine2=ps.nextLine();
			String address=ps.nextLine();
			donor.setAddress(address);
			donor1.addressLength(donor);		//address length validation not exceed 100 character
			
			System.out.println("set your password :");
			System.out.println("Make sure password length in the range between 5 to 20");
			String password=ps.nextLine();
			donor.setPassword(password);
			donor1.passwordLength(donor);		//validate password length
		
			System.out.println("Your Zone Id :");
			String zoneId=ps.next();
			donor.setZone_id(zoneId);
			donor1.zoneLength(donor);		//validate zone id length 
			
			System.out.println("Your account number :");
			Long accountNo=ps.nextLong();
			donor.setAccount_no(accountNo);
			donor1.accountNo(donor);		//account number length validation
			
			System.out.println("your donor_id :"+donor1.registration(donor));
			System.out.println("Welcome to Seetha foundation :"+donor.getDonator_name()); 
			System.out.println("registration successfully");
			
			
			
		break;
		case "2":
			System.out.println("We heartly thank your helping mind..");
			System.out.println();
			System.out.println("Enter your Donor Id here to continue :");
			String donorId=ps.next();
			donor.setDonator_id(donorId);
			donor1.userIdLength(donor);		//check user id length ==4
			System.out.println("Enter your password :");
			String dPassword=ps.next();
			donor.setPassword(dPassword);
			donor1.passwordLength(donor);		//check password length 5 to 20
			donor1.login(donor);
				System.out.println("Welcome "+donor1.getDonorName(donor));
				System.out.println();
				System.out.println("How much would you like to donate?");
				Float fund=ps.nextFloat();
				donor.setamount(fund);
				System.out.println("Rs."+donor1.fundDonation(donor)+" donated successfully"); 
				System.out.println("Thank you for your contribution toward seetha fundation");
			
			break;
		case"3":
			donor1.donationHistory(donor);
			break;
			default:
				System.out.println("Choose valid choice");
		}
		
		
	}

}
