<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/style.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Home Page</title>

</head>
<body>



	<br> Admin Page Welcome :::${userName} and your
	Password:::${uPassword}

	<br>
	<br>

	<a href="viewUsers/1">View Registered Users</a>
	<br>
	<br>
	<a href="viewUsers/2">View Registered Admin</a>
	<br>
	<br>
	<a href="viewUsers/3">View Registered Merchants</a>
	<br>
	<br>
	<a href="viewUsers/0">View ALL Users</a>
	
	<table style="with: 100%" align="center">

		<tr>
			<td><H2>Discover new books and more...</H2></td>
		</tr>
	</table>
	<ul>
		<li>
			<div>
				<a href=""> <img
					src="<c:url value="/resources/CeleryJuice.jpg" />" />
				</a>
			</div>
			<div>
				<a href="">Celery Juice </a>
			</div>
		</li>
		<li>
			<div>
				<a href=""> <img src="<c:url value="/resources/Body.jpg" />" />
			</div>
			<div>
				<a href="">What Every BODY is Saying</a>
			</div>
		</li>
		<li>
			<div>
				<a href=""> <img src="<c:url value="/resources/Quiet.jpg" />" />
			</div>
			<div>
				<a href="">Quiet: The Power of Introvert<br> in a world
					that can't <br>stop taking
				</a>
			</div>
		</li>
		<li>
			<div>
				<a href=""> <img src="<c:url value="/resources/skinny.jpg" />" />
			</div>
			<div>
				<a href="">Skinnytaste</a>
			</div>
		</li>
		<li>
			<div>
				<a href=""> <img
					src="<c:url value="/resources/Da_vinci_code.jpg" />" />
			</div>
			<div>
				<a href="">The Da Vinci Name</a>
			</div>
		</li>
	</ul>
</body>
</html>