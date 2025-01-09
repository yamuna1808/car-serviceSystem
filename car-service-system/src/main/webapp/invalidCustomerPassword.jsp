<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Invalid password</h1>
<form action="/car-service-system/CustomerLogin">
		<table style="background-color:blue";>
			
			<tr>
				<td>username:</td>
				<td><input type="text" name="username"/></td>
			</tr>
			<tr>
				<td>password:</td>
				<td><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login"/></td>
			</tr>
		</table>
	</form>
</body>
</html>