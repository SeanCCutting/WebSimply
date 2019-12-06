<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style/default.css">
</head>
<body>
<%@include  file="templates/header.jsp" %>
<a href="logout.jsp">Logout</a>
<%out.println("Session = " + session.getAttribute("user")); %>
</body>
</html>