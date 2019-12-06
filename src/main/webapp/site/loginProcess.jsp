<%@page import="util.DatabaseUtil"%>
<%
String u = request.getParameter("Username");
String p = request.getParameter("Password");
%>

<body>
<%
if(DatabaseUtil.validateLogin(u,p)) {
	response.sendRedirect("home.jsp");
}
session.setAttribute("user", u);
out.println("Session = " + session.getAttribute("user"));
%>
</body>