<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../../css/loginStyle.css" />
<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/shop-homepage.css" rel="stylesheet">
<%@include file="header.jsp" %>
<style type="text/css">
.errMsg {
color : red;
left: 30%;
}

</style>
</head>
<body>
<h1 style="font-size:90px;text-align:center"><a href="/Balloon/home">BALLOONS!!!!</a></h1>
<div id="login">
		<h3>
			<strong>Welcome.</strong> Please login.
		</h3>
		<form:form method="POST" commandName="command" action="/Balloon/log" cssClass="abc">
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