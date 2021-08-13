package com.project.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDBServlet
 */
@WebServlet("/TestDBServlet")
public class TestDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// Setup connection variables
		
		String user = "datauser";
		String pass = "datauser";
		
		String jdbcURL  = "jdbc:mysql://localhost:3306/datauser?useSSL=false"
				.concat("&useJDBCCompliantTimezoneShift=true")
				.concat("&useLegacyDatetimeCode=false")
				.concat("&serverTimezone=Europe/Moscow");
		
		String driver = "com.mysql.cj.jdbc.Driver";
		
		// Get connection to database
		
		try {
			PrintWriter out = response.getWriter();
			out.println("Connecting to database..." + jdbcURL);
			Class.forName(driver);
			Connection myCon = DriverManager.getConnection(jdbcURL, user, pass);
			out.print("Success!!");
			myCon.close();
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		
	}

}
