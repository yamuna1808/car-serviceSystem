package com.gqt.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer {
	private String name;
	private String username;
	private String password;
	private String email;
	Connection con;
	public String getName()	 {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Customer(String name, String username, String password, String email) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;                
	}
	public Customer() {
		super();
		
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
	
	public int customerRegister(){
		try {
			String s1="select * from customer where username=?";
			PreparedStatement pstmt=con.prepareStatement(s1);
			pstmt.setString(1, username);
			ResultSet res=pstmt.executeQuery(); 
			if(res.next()==true) {
				return-1;
			}

			String s ="insert into customer values(?,?,?,?)";
			PreparedStatement pstmt1=con.prepareStatement(s);
			pstmt1.setString(1, name);
			pstmt1.setString(2,username);
			pstmt1.setString(3, password);
			pstmt1.setString(4, email);
			int rows=pstmt1.executeUpdate();
			return rows;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
public int customerLogin() {
	try {
		String s1= "select * from customer where username=?";
		PreparedStatement pstmt1=con.prepareStatement(s1);
		pstmt1.setString(1,username);
		ResultSet res=pstmt1.executeQuery();
		if(res.next()) {
			if(res.getString(3).equals(password)) {
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
