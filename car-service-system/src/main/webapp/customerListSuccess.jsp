<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="com.gqt.model.Car" %>
    <%@ page import ="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    table {
        border-collapse: collapse;
        width: 100%;
    }
    th,td {
        border: 1px solid black;
        padding: 8px;
        text-align: left;
    }
    th {
        background-color: #f2f2f2;
    }
</style>
</head>
<body>
<table>
    <tr>
        <th>Username</th>
        <th>car_model</th>
        <th>car_type</th>
        <th>car_reg_no</th>
        <th>service_type</th>
        <th>service_status</th>
    </tr>
    <%
    ArrayList<Car> customerCarDetails = (ArrayList)session.getAttribute("scustomerCarDetails");
    
    for(Car car : customerCarDetails) {
    %>
        <tr>
            <td><%= car.getUsername() %></td>
            <td><%= car.getCar_model() %></td>
            <td><%= car.getCar_type() %></td>
            <td><%= car.getCar_reg_no() %></td>
            <td><%= car.getService_type() %></td>
            <td><%= car.getService_status() %></td>
        </tr>
    <%
    }
    %>
</table>
</body>
</html>