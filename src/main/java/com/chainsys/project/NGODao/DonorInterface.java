package com.chainsys.project.NGODao;

import java.sql.SQLException;
import java.util.List;

import com.chainsys.project.NGO.Donor;
import com.chainsys.project.exception.AccountNoNotRegisteredException;

public interface DonorInterface {
	
	public String registration(Donor donor) throws ClassNotFoundException, SQLException, Exception;
	public Boolean login(Donor donor) throws SQLException, Exception;
	public Boolean mailCheck(Donor donor) throws ClassNotFoundException, SQLException, Exception;
	public String getDonorName(Donor donor) throws ClassNotFoundException, SQLException;
	public Float fundDonation(Donor donor) throws ClassNotFoundException, SQLException, Exception;
	public Float getBalance(Donor donor) throws ClassNotFoundException, SQLException;
	public Float getAdminBalance(Donor donor) throws ClassNotFoundException, SQLException;
	public Boolean balanceCheck(Donor donor) throws ClassNotFoundException, SQLException, Exception;
	public Boolean accountNoAvailableCheck(Donor donor) throws ClassNotFoundException, SQLException, AccountNoNotRegisteredException;
	public Boolean passwordLength(Donor donor) throws Exception;
	public Boolean phoneNoLength(Donor donor) throws Exception;
	public Boolean addressLength(Donor donor) throws Exception ;
	public Boolean userIdLength(Donor donor) throws Exception;
	public Boolean zoneLength(Donor donor) throws Exception;
	public Boolean accountNo(Donor donor) throws Exception;
	public Boolean aadharNo(Donor donor) throws Exception ;
	public Boolean email(Donor donor) throws Exception;
	public Boolean name(Donor donor) throws Exception;

}
