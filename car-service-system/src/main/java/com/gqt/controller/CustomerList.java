package com.gqt.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gqt.model.Car;

public class CustomerList extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Car c=new Car();
		ArrayList<Car>customerCarDetails=c.customerList();
		
		HttpSession session=request.getSession();
		session.setAttribute("scustomerCarDetails",customerCarDetails);
		if(customerCarDetails!=null) {
			response.sendRedirect("/car-service-system/customerListSuccess.jsp");
		}
		else {
			response.sendRedirect("/car-service-system/customerListFailure.jsp");

		}
	}
 }
