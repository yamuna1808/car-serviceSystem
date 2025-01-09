package com.gqt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gqt.model.Car;


public class UpdateServiceStatus extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String car_reg_no=request.getParameter("car_reg_no");
		Car c=new Car();
		c.setCar_reg_no(car_reg_no);
		int status=c.updateServiceStatus();
		if(status==0) {
			response.sendRedirect("/car-service-system/updateServiceStatusFailure.jsp");
        } 
		else {
			response.sendRedirect("/car-service-system/updateServiceStatusSuccess.jsp");
		}
	}
}
