<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="tex; charset=ISO-8859-1">
<title>User Login</title>

<link href="<c:url value="/resources/style.css" />" rel="stylesheet">

</head>
<body>
	<form action="home" method="POST">
		<H1 align="center">Online Book Store</H1>
		<table style="with: 100%" align="center">
			<tr>
				<td><H2>Sign In</H2></td>
			</tr>
			<tr>
				<td>UserName</td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td><H4>
						<a href="profile">Create Account</a>
					</H4></td>
				<td align="right"><input class="submiteffect" type="submit"
					value="Sign In" /></td>
			</tr>
		</table>
	</form>
</body>
</html>