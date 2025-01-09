package com.gqt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gqt.model.Customer;
public class CustomerRegister extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name= request.getParameter("name");
		String username= request.getParameter("username");
		String password= request.getParameter("password");
		String confirmpassword= request.getParameter("confirm-password");
		String email= request.getParameter("email");

		if(password.equals(confirmpassword)) {
			HttpSession session=request.getSession(true);
			session.setAttribute("sname", name);

			Customer C = new Customer(name,username,password,email);
			int rows=C.customerRegister();
			if(rows==0) {
				response.sendRedirect("/car-service-system/CustomerRegisterFailure.jsp");
			}
			else if(rows==1){
				response.sendRedirect("/car-service-system/CustomerRegisterSuccess.jsp");
			}
			else{
				response.sendRedirect("/car-service-system/usernameduplicate.jsp");
			}
		}
		else {
			response.sendRedirect("/car-service-system/passwordMismatch.jsp");

		}
	}
}
