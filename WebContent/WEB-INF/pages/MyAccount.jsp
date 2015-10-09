<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/shop-homepage.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<%@include file="header.jsp" %>
	<script src="js/sessionVars.js"></script>
</head>
<body>
	<h1 class="center-text">My Account</h1>
	    <!-- jQuery -->
	    <ul class="nav nav-tabs">
	    	<li class="active"><a href="#tab1" data-toggle="tab">Edit Account</a>
		  	</li>
		  	<li><a href="#tab2" data-toggle="tab">Orders</a>
		  	</li>
		</ul>
		<div class="tab-content margin-bottom">
			<div class="tab-pane active" id="tab1">
				<h3 class="center-text">Edit Account</h3>
				
				<form:form id="updateCustomer" commandName="customer">
					<table align="center">
						<form:input path="userName" value="Gunther" type="hidden"/>
						<tr>
							<td>First Name</td>
							<td><form:input path="firstName"/></td>
							<td><form:errors path="firstName"></form:errors></td>
						</tr>
						<tr>
							<td>Last Name</td>
							<td><form:input path="lastName"/></td>
							<td><form:errors path="lastName"></form:errors></td>
						</tr>
						<tr>
							<td>Email Address</td>
							<td><form:input path="email"/></td>
							<td><form:errors path="email"></form:errors></td>
						</tr>
						<tr>
							<td>Address:</td>
						</tr>
						<tr>
							<td>Street</td>
							<td><form:input path="street"/></td>
							<td><form:errors path="street"></form:errors></td>
						</tr>
						<tr>
							<td>City</td>
							<td><form:input path="city"/></td>
							<td><form:errors path="city"></form:errors></td>
						</tr>
						<tr>
							<td>State</td>
							<td><form:input path="state"/></td>
							<td><form:errors path="state"></form:errors></td>
						</tr>
						<tr>
							<td>Zip</td>
							<td><form:input path="zip"/></td>
							<td><form:errors path="zip"></form:errors></td>
						</tr>
						<tr>
							<td>Country</td>
							<td><form:input path="country"/></td>
							<td><form:errors path="country"></form:errors></td>
						</tr>
						<tr>
							<td colspan="3"><input id="updateBtn" type="submit" value="Submit"/></td>
						</tr>
						<tr>
							<td><div id="updateResponse"></div></td>
						</tr>
					</table>
				
				</form:form>
			</div>
			<div class="tab-pane" id="tab2">
				<h3 class="center-text">Orders</h3>
			</div>
		</div>
    <script src="js/jquery.js"></script>
    <script src="js/ajax.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
</body>
</html>