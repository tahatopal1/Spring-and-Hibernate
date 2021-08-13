package com.project.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionTest {

	public static void main(String[] args) {
		String jdbcURL 	   = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false"
				.concat("&useJDBCCompliantTimezoneShift=true")
				.concat("&useLegacyDatetimeCode=false")
				.concat("&serverTimezone=Europe/Moscow");
		
		String user        = "datauser";
		String pass        = "datauser";
		
		try {
			System.out.println("Connecting to database".concat(jdbcURL));
			Connection connection = DriverManager.getConnection(jdbcURL, user, pass);
			System.out.println("Connection successful!");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
