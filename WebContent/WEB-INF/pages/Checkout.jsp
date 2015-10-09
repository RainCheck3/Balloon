<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/shop-homepage.css" rel="stylesheet">
<%@include file="header.jsp"%>
</head>
<body>
	<div class="row">
		<c:forEach var="item" items="${applicationScope.cart.orderDetails}">
			<form method="post" action="rest/cart/add">

				<div class="col-sm-4 col-lg-4 col-md-4">
					<div class="thumbnail">
						<img src="http://www.no-refresh.com/blog/wp-content/uploads/2013/04/Custom-Balloon-design-tool.jpg" alt="">
						<div class="caption">
							<h4 class="pull-right">$${item.subTotal}</h4>
							<h4>
								<a
									href="Product.jsp?name=${item.balloon.productId}?price=${item.balloon.price}">${item.balloon.color}
									Balloon</a>
							</h4>
							<p>Shape : ${item.balloon.shape}</p>
							<p>Quantity : ${item.balloon.quantity}
						</div>
						<div class="ratings">
							<p class="pull-right">15 reviews</p>
							<p>
								<span class="glyphicon glyphicon-star"></span> <span
									class="glyphicon glyphicon-star"></span> <span
									class="glyphicon glyphicon-star"></span> <span
									class="glyphicon glyphicon-star"></span>
							</p>

						</div>
					</div>
				</div>
			</form>
		</c:forEach>
		<div>
		Total: $${applicationScope.total }
		</div>
		<div>
		<form action="/Balloon/clear" method="POST">
			<input type="submit" value="Clear">
		</form>
		</div>
		<form action="/Balloon/buy" method="POST">
			<input type="submit" value="Buy"/>
		</form>
	</div>
	<div class="container"></div>
	<!-- jQuery -->
	<script src="js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>