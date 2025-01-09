package com.gqt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gqt.model.Car;


public class AddCarDetails extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String username =(String) session.getAttribute("susername");
		String car_model=request.getParameter("car_model");
		String car_type=request.getParameter("car_type");
		String car_reg_no=request.getParameter("car_reg_no");
		
		Car c= new Car();
		c.setUsername(username);
		c.setCar_model(car_model);
		c.setCar_type(car_type);
		c.setCar_reg_no(car_reg_no);

		int rows=c.addCarDetails();
		if(rows==1) {
			response.sendRedirect("/car-service-system/carDetailsAddedSuccess.jsp");
		}
		else{
			response.sendRedirect("/car-service-system/carDetailsAddedFailure.jsp");

		}

	}
}
