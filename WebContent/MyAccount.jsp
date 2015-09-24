<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
				<form name="updateCustomer" action="UpdateCustomerServlet"method="post">
					<div class="form-group quarter-width">
				    	<label for="fName">First Name:</label>
						<input type="text" class="form-control account-input" name="fName">
					</div>
					<div class="form-group quarter-width">
				    	<label for="lName">Last Name:</label>
						<input type="text" class="form-control account-input" name="lName">
					</div>
					<div class="form-group quarter-width">
				    	<label for="email">Email address:</label>
						<input type="email" class="form-control account-input" name="email">
					</div>
					<div class="form-group quarter-width">
						<label>Address</label>
					</div>
					<div class="form-group quarter-width">
						<label for="street">Street:</label>
						<input type="text" class="form-control account-input" name="street">
					</div>
					<div class="form-group quarter-width">
						<label for="city">City:</label>
						<input type="text" class="form-control account-input" name="city">
					</div>
					<div class="form-group quarter-width">
						<label for="state">State:</label>
						<input type="text" class="form-control account-input" name="state">
					</div>
					<div class="form-group quarter-width">
						<label for="zip">Zip:</label>
						<input type="text" class="form-control account-input" name="zip">
					</div>
					<div class="form-group quarter-width">
						<label for="country">Country:</label>
						<input type="text" class="form-control account-input" name="country">
					</div>
					<div class="form-group quarter-width">
						<button type="submit" class="btn btn-default account-input">Submit</button>		
					</div>
				</form>
			</div>
			<div class="tab-pane" id="tab2">
				<h3 class="center-text">Orders</h3>
			</div>
		</div>
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
</body>
</html>