package com.mostafa.sna.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		System.out.println("jdbc connection");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@10.11.201.251:1521:stlbas", "hr", "hr");
		return con;
	}
	
}
