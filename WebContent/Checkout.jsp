<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/shop-homepage.css" rel="stylesheet">
	<%@include file="header.jsp" %>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="row">	
				<div class="col-sm-4 col-lg-4 col-md-4">
				    <div class="thumbnail">
				        <img src="http://placehold.it/320x150" alt="">
				        <div class="caption">
				            <h4 class="pull-right">$24.99</h4>
				            <h4><a href="#">First Product</a>
				            </h4>
				            <p>See more snippets like this online store item at <a target="_blank" href="http://www.bootsnipp.com">Bootsnipp - http://bootsnipp.com</a>.</p>
				        </div>
				        <div class="removefromcart">
				        <p> <input type="button" value="Remove From Cart" />   </p>
				       </div>
				        <div class="ratings">
				            <p class="pull-right">15 reviews</p>
				            <p>
				                <span class="glyphicon glyphicon-star"></span>
				                <span class="glyphicon glyphicon-star"></span>
				                <span class="glyphicon glyphicon-star"></span>
				                <span class="glyphicon glyphicon-star"></span>
				                <span class="glyphicon glyphicon-star"></span>
				            </p>
				        </div>
				    </div>
				</div>
				
				<div class="col-sm-4 col-lg-4 col-md-4">
				    <div class="thumbnail">
				        <img src="http://placehold.it/320x150" alt="">
				        <div class="caption">
				            <h4 class="pull-right">$64.99</h4>
				            <h4><a href="#">Second Product</a>
				            </h4>
				            <p>This is a short description. Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
				        </div>
				        <div class="removefromcart">
				        <p> <input type="button" value="Remove From Cart" />   </p>
				       </div>
				        <div class="ratings">
				            <p class="pull-right">12 reviews</p>
				            <p>
				                <span class="glyphicon glyphicon-star"></span>
				                <span class="glyphicon glyphicon-star"></span>
				                <span class="glyphicon glyphicon-star"></span>
				                <span class="glyphicon glyphicon-star"></span>
				                <span class="glyphicon glyphicon-star-empty"></span>
				            </p>
				        </div>
				    </div>
				</div>
			</div>
		</div>
		<div class="row">
			
		</div>
	</div>
    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
    
</body>
</html>