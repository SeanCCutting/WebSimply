<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="admin.ServerSetup" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%= new ServerSetup() %>
<%
    String redirectURL = "site/login.jsp";
    response.sendRedirect(redirectURL);
%>
</body>
</html>