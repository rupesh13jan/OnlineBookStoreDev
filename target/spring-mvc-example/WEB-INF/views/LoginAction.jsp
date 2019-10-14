<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Home Page</title>
<link href="<c:url value="/resources/style.css" />" rel="stylesheet">
</head>
<body>



	<br> Welcome :::${userName} and your Password:::${uPassword}

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