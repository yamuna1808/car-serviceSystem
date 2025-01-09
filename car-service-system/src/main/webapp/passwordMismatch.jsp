<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>password and confirm password do not match!!</h1>
<form action="/car-service-system/CustomerRegister">
		<table style="background-color:blue";>
			<tr>
				<td>name:</td>
				<td><input type="text" name="name"/></td>
			</tr>
			<tr>
				<td>username:</td>
				<td><input type="text" name="username"/></td>
			</tr>
			<tr>
				<td>password:</td>
				<td><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td>confirm-passwrord:</td>
				<td><input type="password" name="confirm-password"/></td>
			</tr>
			<tr>
				<td>email:</td>
				<td><input type="text" name="email"/></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Register"/></td>
			</tr>
		</table>
	</form>
</body>
</html>