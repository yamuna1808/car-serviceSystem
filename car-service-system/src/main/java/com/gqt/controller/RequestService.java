package com.gqt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gqt.model.Car;


public class RequestService extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		String username=(String) session.getAttribute("susername");
		String car_reg_no=request.getParameter("car_reg_no");
		String service_type=request.getParameter("service_type");
		
		Car c=new Car();
		c.setUsername(username);
		c.setCar_reg_no(car_reg_no);
		c.setService_type(service_type);
		
		int rows = c.requestService();
		if(rows==0) {
			response.sendRedirect("/car-service-system/requestServiceFailed.jsp");
		}
		else {
			response.sendRedirect("/car-service-system/requestServiceSuccess.jsp");

		}

	}
}
