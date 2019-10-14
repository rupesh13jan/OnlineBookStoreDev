<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">

<!-- Mirrored from houzez.favethemes.com/html/login.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 15 May 2017 13:09:48 GMT -->
<head>
<title>Login Page</title>
<!--Meta tags-->
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="keywords" content="Houzez HTML5 Template">
<meta name="description" content="Houzez HTML5 Template">
<meta name="author" content="Favethemes">

<link rel="apple-touch-icon" sizes="144x144"
	href="images/favicons/apple-touch-icon.png">
<link rel="manifest"
	href="<c:url value="/resources/images/favicons/manifest.json"/>">
<link rel="mask-icon"
	href="<c:url value="/resources/images/favicons/safari-pinned-tab.svg"/>">
<meta name="theme-color" content="#ffffff">

<link href="<c:url value="/resources/bootstrap.css"/>" rel="stylesheet"
	type="text/css" />
<link href="<c:url value="/resources/css/bootstrap-select.css"/>"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/font-awesome.css"/>"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/owl.carousel.css"/>"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/jquery-ui.css"/>"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/styles.css"/>" rel="stylesheet"
	type="text/css" />
<script>
	function getBooksDet() {
		var request = new XMLHttpRequest()

		request.open('GET',
				'http://localhost:8001/spring-mvc-example/searchBooks/', true)
		request.onload = function() {
			// Begin accessing JSON data here
			var data = JSON.parse(this.response)
			document.getElementById("demo").innerHTML = data;

		}
	}
</script>

</head>
<body>

	<!--end header section header v1-->

	<!--start advanced search section-->
	<section class="advanced-search advance-search-header">
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<form action="searchBooks/a" method="POST">
						<div class="form-group search-long">
							<div class="search">
								<div class="input-search input-icon">
									<input class="form-control" type="text" id="searchBook"
										name="searchBook" placeholder="Search for a books">
								</div>

								
							</div>
							<div class="search-btn">
								<button onclick="getBooksDet()" class="btn btn-secondary">Go</button>
							</div>
						</div>
						<div class="advance-fields">
							<div class="row">
								<div class="col-sm-3 col-xs-6">
									<div class="form-group">
										<select class="selectpicker" data-live-search="true"
											title="Status">
											<option>Status 1</option>
											<option>Status 2</option>
											<option>Status 3</option>
											<option>Status 4</option>
											<option>Status 5</option>
										</select>
									</div>
								</div>
								<div class="col-sm-3 col-xs-6">
									<div class="form-group">
										<select class="selectpicker" data-live-search="true"
											title="Property Type">
											<option>Property Type 1</option>
											<option>Property Type 2</option>
											<option>Property Type 3</option>
											<option>Property Type 4</option>
											<option>Property Type 5</option>
										</select>
									</div>
								</div>
								<div class="col-sm-3 col-xs-6">
									<div class="form-group">
										<select class="selectpicker" data-live-search="true"
											title="Beds">
											<option>01</option>
											<option>02</option>
											<option>03</option>
											<option>04</option>
											<option>05</option>
										</select>
									</div>
								</div>
								<div class="col-sm-3 col-xs-6">
									<div class="form-group">
										<select class="selectpicker" data-live-search="true"
											title="Baths">
											<option>01</option>
											<option>02</option>
											<option>03</option>
											<option>04</option>
											<option>05</option>
										</select>
									</div>
								</div>
								<div class="col-sm-3 col-xs-6">
									<div class="form-group">
										<select class="selectpicker" data-live-search="true"
											title="Min Areas (Sqft)">
											<option>$100</option>
											<option>$100</option>
											<option>$100</option>
											<option>$100</option>
											<option>$100</option>
										</select>
									</div>
								</div>
								<div class="col-sm-3 col-xs-6">
									<div class="form-group">
										<select class="selectpicker" data-live-search="true"
											title="Max Areas (Sqft)">
											<option>$100</option>
											<option>$100</option>
											<option>$100</option>
											<option>$100</option>
											<option>$100</option>
										</select>
									</div>
								</div>
								<div class="col-sm-6 col-xs-6">
									<div class="range-advanced-main">
										<div class="range-text">
											<input type="text" class="min-price-range-hidden range-input"
												readonly> <input type="text"
												class="max-price-range-hidden range-input" readonly>
											<p>
												<span class="range-title">Price Range:</span> from <span
													class="min-price-range"></span> to <span
													class="max-price-range"></span>
											</p>
										</div>
										<div class="range-wrap">
											<div class="price-range-advanced"></div>
										</div>
									</div>
								</div>
								<div class="col-sm-12 col-xs-12 features-list">

									<label class="advance-trigger text-uppercase title"><i
										class="fa fa-plus-square"></i> Other Features </label>
									<div class="clearfix"></div>
									<div class="field-expand">
										<label class="checkbox-inline"> <input type="checkbox"
											value="option1"> Feature
										</label> <label class="checkbox-inline"> <input
											type="checkbox" value="option2"> Feature
										</label> <label class="checkbox-inline"> <input
											type="checkbox" value="option3"> Feature
										</label> <label class="checkbox-inline"> <input
											type="checkbox" value="option1"> Feature
										</label> <label class="checkbox-inline"> <input
											type="checkbox" value="option2"> Feature
										</label> <label class="checkbox-inline"> <input
											type="checkbox" value="option3"> Feature
										</label> <label class="checkbox-inline"> <input
											type="checkbox" value="option1"> Feature
										</label> <label class="checkbox-inline"> <input
											type="checkbox" value="option2"> Feature
										</label> <label class="checkbox-inline"> <input
											type="checkbox" value="option3"> Feature
										</label> <label class="checkbox-inline"> <input
											type="checkbox" value="option1"> Feature
										</label> <label class="checkbox-inline"> <input
											type="checkbox" value="option2"> Feature
										</label> <label class="checkbox-inline"> <input
											type="checkbox" value="option3"> Feature
										</label>
									</div>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>
	<!--end advanced search section-->

	<!--start advanced search section-->
	<section class="advanced-search-mobile visible-xs visible-sm">
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<form>
						<div class="single-search-wrap">
							<div class="single-search-inner advance-btn">
								<button class="table-cell text-left" type="button">
									<i class="fa fa-gear"></i>
								</button>
							</div>
							<div class="single-search-inner single-search">

								<input type="text" class="form-control table-cell" name="search"
									placeholder="Search">
							</div>
							<div class="single-search-inner single-seach-btn">
								<button class="table-cell text-right" type="submit">
									<i class="fa fa-search"></i>
								</button>
							</div>
						</div>

						<br> <br> <br> <br>
				</div>
			</div>
		</div>
	</section>





	<c:forEach items="${allBooks}" var="festival">
		<div class="item-body table-cell">

			<div class="body-left table-cell">
				<div class="info-row">
					<div class="label-wrap hide-on-grid">
						<a href="#"> <img
							src="<c:url value="/resources/${festival}.jpg" />" /></a>
						<div class="label-status label label-default">For Sale</div>
						<span class="label label-danger">Sold</span>
					</div>
					<h2 class="property-title">
						<a href="#">${festival} </a>
					</h2>

					<p id="demo"></p>
					<div class="info-row phone text-right">
						<a href="#" class="btn btn-primary">Add to cart <i
							class="fa fa-angle-right fa-right"></i></a>

					</div>

				</div>


			</div>


		</div>


	</c:forEach>
	<!--start footer section-->
	<footer class="footer-v2">

		<div class="footer-bottom">
			<div class="container">
				<div class="row">
					<div class="col-md-3 col-sm-3">
						<div class="footer-col">
							<p>Online book store - All rights reserved</p>
						</div>
					</div>
					<div class="col-md-6 col-sm-6">
						<div class="footer-col">
							<div class="navi">
								<ul id="footer-menu" class="">
									<li><a href="privacy.html">Privacy</a></li>
									<li><a href="terms-and-conditions.html">Terms and
											Conditions</a></li>
									<li><a href="contact-us.html">Contact</a></li>
								</ul>
							</div>
						</div>
					</div>
					<div class="col-md-3 col-sm-3">
						<div class="footer-col foot-social">
							<p>
								Follow us <a target="_blank" class="btn-facebook"
									href="https://facebook.com/Favethemes"><i
									class="fa fa-facebook-square"></i></a> <a target="_blank"
									class="btn-twitter" href="https://twitter.com/favethemes"><i
									class="fa fa-twitter-square"></i></a> <a target="_blank"
									class="btn-linkedin" href="http://linkedin.com/"><i
									class="fa fa-linkedin-square"></i></a> <a target="_blank"
									class="btn-google-plus" href="http://google.com/"><i
									class="fa fa-google-plus-square"></i></a> <a target="_blank"
									class="btn-instagram" href="http://instagram.com/"><i
									class="fa fa-instagram"></i></a>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>
	<!--end footer section-->

	<!--Start Scripts-->
	<script type="text/javascript"
		src="<c:url value="/resources/js/jquery.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/modernizr.custom.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/bootstrap.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/slick.min.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/owl.carousel.min.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/jquery.matchHeight-min.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/bootstrap-select.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/jquery-ui.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/masonry.pkgd.min.html"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/jquery.nicescroll.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/custom.js"/>"></script>
</body>

<!-- Mirrored from houzez.favethemes.com/html/properties-grid.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 15 May 2017 13:04:58 GMT -->

</html>