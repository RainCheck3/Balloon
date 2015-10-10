<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
</head>
<body>

	<div id="login">
		<h1>
			<strong>Welcome.</strong> Please SignUp.
		</h1>
		<form:form action="sign" commandName="customer" method="post">
	 <table>
    <tr>
        <td><form:label path="username">UserName</form:label></td>
        <td><form:input path="username" /></td>
    </tr>
    <tr>
        <td>Password :</td>
        <td><form:password path="password"/></td>
        
    </tr>
    <tr>
        <td><form:label path="firstName">FirstName</form:label></td>
        <td><form:input path="firstName" /></td>
    </tr>
     <tr>
        <td><form:label path="lastName">LastName</form:label></td>
        <td><form:input path="lastName" /></td>
    </tr>
     <tr>
        <td><form:label path="street">Street</form:label></td>
        <td><form:input path="street" /></td>
    </tr>
    
     <tr>
        <td><form:label path="city">City</form:label></td>
        <td><form:input path="city" /></td>
    </tr>
     <tr>
        <td><form:label path="state">State</form:label></td>
        <td><form:input path="state" /></td>
    </tr>
     <tr>
        <td><form:label path="Country">Country</form:label></td>
        <td><form:input path="Country" /></td>
    </tr>
    
     <tr>
        <td><form:label path="Email">Email</form:label></td>
        <td><form:input path="Email" /></td>
    </tr>
     <tr>
        <td><form:label path="zip">Zip</form:label></td>
        <td><form:input path="zip" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Register"/>
        </td>
    </tr>
</table>  
	</form:form>



	</div>
</body>
</html>