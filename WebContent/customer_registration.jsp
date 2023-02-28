<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1> Customer_Regestration Page</h1>
	
	<form action="regCustomer"  method="post">
	
		Name:<input type = "text" name="tbName" id="tbName"/>
		<br>
		Email<input type="email" name="tbEmail" id="tbEmail">
		<br>
		Mobile:<input type="text" name="tbMobile" id="tbMobile"/>
		<br>
		
		Password:<input type="password" name="tbPsd" id="tbPsd"/>
		<br>
		State:<select name="ddlStates">
				<option>--select--</option>
				<option value="karnataka">KA</option>
				<option value="andhra pradesh">AP</option>
				<option value="kerala">KL</option>
				</select>		
		<br>
		
		<input type="submit" value="Regester">	
	
	
	
	</form>

</body>
</html>