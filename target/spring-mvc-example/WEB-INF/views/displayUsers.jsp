<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registered user details</title>
</head>
<body>
<h3>Registered Users:</h3>
<c:forEach items="${allUsers}" var="festival">
    <tr>      
        <td>${allUsers}</td>
         
    </tr>
</c:forEach>
</body>
</html>