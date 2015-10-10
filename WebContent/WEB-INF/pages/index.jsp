<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Balloon World</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/shop-homepage.css" rel="stylesheet">


<%@include file="header.jsp"%>
</head>

<body>

	<!-- Page Content -->
	<div class="container">

		<div class="row">

			<div class="col-md-3">
				<p class="lead">Vendors</p>
				<div class="list-group">
					<a href="#" class="list-group-item"> Gurgaon Balloons</a> <a href="#"
						class="list-group-item">Chicago Balloons</a> <a href="#"
						class="list-group-item">Banglore Balloons</a>
				</div>
			</div>

			<div class="col-md-9">

				<div class="row carousel-holder">

					<div class="col-md-12">
						<div id="carousel-example-generic" class="carousel slide"
							data-ride="carousel">
							<ol class="carousel-indicators">
								<li data-target="#carousel-example-generic" data-slide-to="0"
									class="active"></li>
								<li data-target="#carousel-example-generic" data-slide-to="1"></li>
								<li data-target="#carousel-example-generic" data-slide-to="2"></li>
							</ol>
							<div class="carousel-inner">
								<div class="item active">
									<img class="slide-image" src="https://tracilee.files.wordpress.com/2011/10/dsc_0334_21.jpg"
										alt="">
								</div>
								<div class="item">
									<img class="slide-image" src="http://vrf.wpengine.netdna-cdn.com/wp-content/uploads/2014/03/balloons-06.jpg"
										alt="">
								</div>
								<div class="item">
									<img class="slide-image" src="http://images6.alphacoders.com/459/459891.jpg"
										alt="">
								</div>
							</div>
							<a class="left carousel-control" href="#carousel-example-generic"
								data-slide="prev"> <span
								class="glyphicon glyphicon-chevron-left"></span>
							</a> <a class="right carousel-control"
								href="#carousel-example-generic" data-slide="next"> <span
								class="glyphicon glyphicon-chevron-right"></span>
							</a>
						</div>
					</div>

				</div>

				<div class="row">
				

					<c:forEach var="item" items="${items}">
						<form:form method="post" commandName="orderD"
							action="/Balloon/addcart">
							<form:hidden path="price" value="${item.price}"></form:hidden>
							<form:hidden path="quantity" value="${item.quantity}"></form:hidden> 
							<form:hidden path="productId" value="${item.productId}"></form:hidden>
							<form:hidden path="color" value="${item.color}"></form:hidden> 
							<form:hidden path="shape" value="${item.shape}"></form:hidden>
						
							<div class="col-sm-4 col-lg-4 col-md-4">
								<div class="thumbnail">
									<img src="http://images.clipartpanda.com/hot-air-balloon-border-clip-art-balloon-20clipart-eaTep57i4.png" alt="">
									<div class="caption">
										<h4 class="pull-right">$${item.price}</h4>
										<h4>
											<a
												href="/Balloon/parameter?pid=${item.productId}">${item.color}
												Balloon</a>
										</h4>
										<p>Shape : ${item.shape}</p>
										<p>Balloons left : ${item.quantity}
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
									<input style="margin-left: 63%; margin-bottom: 2%;"
										type="submit" id="addbtn" value="Add to Cart" />
								</div>
							</div>
						</form:form>
					</c:forEach>
				</div>

			</div>

		</div>

	</div>
	<!-- /.container -->

	<div class="container">

		<hr>

		<!-- Footer -->
		<footer>
			<div class="row">
				<div class="col-lg-12">
					<p>Copyright &copy; Balloon Store 2015</p>
				</div>
			</div>
		</footer>

	</div>
	<!-- /.container -->

	<!-- jQuery -->
	<script src="js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

</body>

</html>
