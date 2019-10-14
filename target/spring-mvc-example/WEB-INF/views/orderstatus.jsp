<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
<head>
<title>Order Status</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Payment Form Widget Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript">
	
	
	
	
	
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } 







</script>
<!-- //for-mobile-apps -->


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





<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet"
	type="text/css" />

<link href='//fonts.googleapis.com/css?family=Fugaz+One'
	rel='stylesheet' type='text/css'>
<link
	href='//fonts.googleapis.com/css?family=Alegreya+Sans:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,800,800italic,900,900italic'
	rel='stylesheet' type='text/css'>
<link
	href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic'
	rel='stylesheet' type='text/css'>

<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.min.js"/>"></script>
</head>
<body>
	<div class="main">
		<h1 style="color:green;"> Payment Form</h1>
		<div class="content">

			<script src="<c:url value="/resources/js/easyResponsiveTabs.js"/>"></script>
			<script type="text/javascript">
				$(document).ready(function() {
					$('#horizontalTab').easyResponsiveTabs({
						type : 'default', //Types: default, vertical, accordion           
						width : 'auto', //auto or any width like 600px
						fit : true
					// 100% fit in a container
					});
				});
			</script>

			<div class="sap_tabs">
				<div id="horizontalTab"
					style="display: block; width: 100%; margin: 0px;">

					<div  class="resp-tabs-container">
					
					<b><h2  style="margin-left:30%;color:red;">Payment successfully completed</h2></b>	
						<br><br><img style="margin-left:30%;" src="<c:url value="/resources/complete.jpg" />" />
						
					</div>
				</div>

			</div>
			<p class="footer">Copyright © 2019 Online Payment Form| All
				Rights Reserved</p>
		</div>
</body>
</html>