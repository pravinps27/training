package com.chainsys.project.NGODBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NGOConnection {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		connection();
		//System.out.println(connection());

	}
	
	public static Connection connection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connect= DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "system", "oracle");
		return connect;
		
	}

}
