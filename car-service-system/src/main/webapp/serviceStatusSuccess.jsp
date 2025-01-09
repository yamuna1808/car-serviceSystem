<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import ="com.gqt.model.Car" %>
    <%@ page import ="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
ArrayList <Car> carList=(ArrayList)session.getAttribute("scarList");
for(Car x:carList){
	out.println(x);
}
%>
</body>
</html>