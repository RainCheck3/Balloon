<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Login Page</title>
<link rel="stylesheet" type="text/css" href="css/loginStyle.css" />
<%@include file="header.jsp" %>
</head>
<body>
<div id="login">
		<h1>
			<strong>Welcome.</strong> Please login.
		</h1>
		<form:form method="POST" commandName="command" action="/Balloon/log">
		<table>
			<tr>
				<td>Customer Name :</td>
				<td><form:input path="username" /></td>
				<td><form:errors path="username" cssClass="errMsg"></form:errors></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><form:password path="password" /></td>
				<td><form:errors path="password"  cssClass="errMsg"></form:errors></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" />
			</tr>
		</table>
	</form:form>
		
		
	
		
	</div>
</body>
</html>