package com.gqt.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Car {
private String username;
private String car_model;
private String car_type;
private String car_reg_no;
private String service_type;
@Override
public String toString() {
	return "Car [username=" + username + ", car_model=" + car_model + ", car_type=" + car_type + ", car_reg_no="
			+ car_reg_no + ", service_type=" + service_type + ", service_status=" + service_status + "]";
}
private String service_status;
Connection con;
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getCar_model() {
	return car_model;
}
public void setCar_model(String car_model) {
	this.car_model = car_model;
}
public String getCar_type() {
	return car_type;
}
public void setCar_type(String car_type) {
	this.car_type = car_type;
}
public String getCar_reg_no() {
	return car_reg_no;
}
public void setCar_reg_no(String car_reg_no) {
	this.car_reg_no = car_reg_no;
}
public String getService_type() {
	return service_type;
}
public void setService_type(String service_type) {
	this.service_type = service_type;
}
public String getService_status() {
	return service_status;
}
public void setService_request(String service_request) {
	this.service_status = service_request;
}
public Car(String username, String car_model, String car_type, String car_reg_no, String service_type,
		String service_status) {
	super();
	this.username = username;
	this.car_model = car_model;
	this.car_type = car_type;
	this.car_reg_no = car_reg_no;
	this.service_type = service_type;
	this.service_status = service_status;
}
public Car() {
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
public int addCarDetails() {
	String s="insert into car values(?,?,?,?,?,?)";
	try {
		PreparedStatement pstmt =con.prepareStatement(s);
		pstmt.setString(1, username);
		pstmt.setString(2, car_model);
		pstmt.setString(3, car_type);
		pstmt.setString(4, car_reg_no);
		pstmt.setString(5, "false");
		pstmt.setString(6, "false");
        int rows=pstmt.executeUpdate();
        return rows;
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
return 0;
}
public int requestService() {
	try {
		String s="update car set service_type=? where username=? and car_reg_no=?";
		PreparedStatement pstmt =con.prepareStatement(s);
		pstmt.setString(1,service_type);
		pstmt.setString(2,username);
		pstmt.setString(3,car_reg_no);
		int rows=pstmt.executeUpdate();
		return rows;		
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
	return 0;
}
public ArrayList <Car> serviceStatus(){
	try {
		String s= "Select *from car where username=?";
		PreparedStatement pstmt= con.prepareStatement(s);
		pstmt.setString(1, username);
		ResultSet res= pstmt.executeQuery();
		
		ArrayList<Car> carList=new ArrayList<Car>();
		while(res.next()==true) {
			username =res.getString(1);
			car_model=res.getString(2);
			car_type=res.getString(3);
			car_reg_no=res.getString(4);
			service_type=res.getString(5);
			service_status=res.getString(6);
			
			Car c= new Car(username,car_model,car_type,car_reg_no,service_type,service_status);
			carList.add(c);
		}
		return carList;
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return null;
}
public ArrayList<Car> customerList() {
	try{
		String s= "select* from car";
	PreparedStatement pstmt=con.prepareStatement(s);
	ResultSet res =pstmt.executeQuery();
	
	ArrayList<Car> customerCarDetails=new ArrayList<Car>();
	while(res.next()) {
		username =res.getString(1);
		car_model=res.getString(2);
		car_type=res.getString(3);
		car_reg_no=res.getString(4);
		service_type=res.getString(5);
		service_status=res.getString(6);
		Car c= new Car(username,car_model,car_type,car_reg_no,service_type,service_status);
		customerCarDetails.add(c);
	}
	return customerCarDetails;
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
	return null;
}
public int updateServiceStatus() {
	try {
		String s= "update car set service_status=? where car_reg_no=?";
		PreparedStatement pstmt= con.prepareStatement(s);
		pstmt.setString(1, "completed");
		pstmt.setString(2, car_reg_no);
		int rows=pstmt.executeUpdate();
		return rows;
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return 0;
	
}
}
