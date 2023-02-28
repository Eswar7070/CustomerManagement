<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
	<h1>Customer Login Page</h1>
	
	<form action="loginCustomer" method="post">
	
	<label for="tbEmailLog">Email:</label>
	<input type ="email" name="tbEmailLog" id="tbEmailLog" value="<%= request.getParameter("tbEmail")%>"/>
	<br>
	
	<label for="tbPassLog">Password:</label>
	<input type ="password" name="tbPassLog" id="tbPassLog" value="<%=request.getParameter("tbPsd") %>"/>
	<br>
	
	<input type="submit" value="Login"/>
	</form>
</body>
</html>