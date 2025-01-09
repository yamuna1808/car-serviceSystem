package com.gqt.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Admin {
private String username;
private String password;
Connection con;
public Admin(String username, String password) {
	super();
	this.username = username;
	this.password = password;
}
public Admin() {
	super();
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
{
	try {
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/car_service_system","root","Root");

	}
	catch(Exception e) {
		e.printStackTrace();
	}
}
	public int adminLogin() {
		try {
			String s1="select * from admin where username=?";
			PreparedStatement pstmt1=con.prepareStatement(s1);
			pstmt1.setString(1,username);
			ResultSet res=pstmt1.executeQuery();
			if(res.next()) {
				if(res.getString(2).equals(password)) {
					return 1;//login success
				}
				else {
					return 0;//invalid password
				}
			}
			else {
				return -1;//invalid username
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	
}


