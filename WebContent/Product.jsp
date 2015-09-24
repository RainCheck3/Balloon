<%@page import="com.sapient.dao.BalloonDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

  <link href="css/bootstrap.min.css" rel="stylesheet">
 <link href="css/shop-homepage.css" rel="stylesheet">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<%@include file="header.jsp" %>
	
	
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">


</head>


<body>
<%
	String productId=request.getParameter("name");
     BalloonDaoImpl desc=new BalloonDaoImpl();
     String description=desc.getDescription(productId);
    String price=request.getParameter("price");
%>


<div style="position:relative;margin-left:40%;bottom:10;text-align:right; overflow:hidden; height:250px; width:200px">
<img style="position:absolute; left:100%; margin-left:-300px" src="images/BalloonBorder.jpg"/>
</div>
<div>
<h3 style="padding-right: 150px;">
<%
	out.println(productId);
%>

</h3>
<h3 style="margin-right: 150%">Price: <% out.println(price); %></h3>
</div>
<div class="container" style='float: left;'>

  <button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo">Description</button>
  <div id="demo" class="collapse">
   <p>
   <%
	out.println(description);
   %>
    </p>
  </div>
  <br>
   <button type="button" class="btn btn-info1" data-toggle="collapse" data-target="#demo1">Specification</button>
  <div id="demo1" class="collapse">
 
  </div>
  <br>
   <button type="button" class="btn btn-info2" data-toggle="collapse" data-target="#demo2">Reviews</button>
  <div id="demo2" class="collapse">

  </div>
</div>
<button type="button" class="btn btn-info">Add to Cart</button>
 
   <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
</body>
</html>