package com.hotelmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class connect {
	Connection con = null;
	Statement stmt = null;
	
	public connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/project?useUnicode=yes&characterEncoding=UTF-8&useSSL=false","root","");
			stmt = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}
