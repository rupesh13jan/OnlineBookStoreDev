<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="Style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Celery Juice</title>
<link href="<c:url value="/resources/css/styles.css"/>" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.checked {
  color: orange;
}
</style>
</head>
<body>
 <div style="opacity: 1.2;" class="item-body table-cell">
<div style="width:30%;margin-left:10%;float:left;">
<ul>
	<li>
		<div>
			<a href=""> <img
						src="<c:url value="/resources/CeleryJuice.jpg" />" /></a>
		</div>
		<div>
			<a  href="">Celery Juice	</a>
			<h1>$15</h1>
		</div>
		<span class="fa fa-star checked"></span>
<span class="fa fa-star checked"></span>
<span class="fa fa-star checked"></span>
<span class="fa fa-star"></span>
<span class="fa fa-star"></span> 
<form action="payment">
<button class="btn btn-primary" style="font-size:24px">Buy Now<i class="fa fa-shopping-cart"  ></i></button>
</form>
	</li>
	
	</ul>

</div>
<div style="width:40%;margin-right:10%;float:right;">

<div><h4>Title</h4>
<span>Celery Juice </span>
</div>

<div><h4>Author</h4>
<span>Antony William </span>
</div>
<div><h4>Description</h4>
<h5>Celery juice is everywhere for a reason: because it's saving lives as it restores people's health one symptom at a time.</h5>
<span>From celebrities posting about their daily celery juice routines to people from all walks of life sharing pictures and testimonials of their dramatic recovery stories, celery juice is revealing itself to ignite healing when all odds seem against it. What began decades ago as a quiet movement has become a global healing revolution.</span>
</div>

</div>

</div>
</body>
</html>