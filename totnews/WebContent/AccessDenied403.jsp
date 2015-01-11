<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP Page</title>
</head>
<body>
	<h1>You do not have access to this page. Your role: </h1>
	<%= request.isUserInRole("user") %>
	<h1>
		Login Failed. <a href="/journal/index.html">Please try again.</a>
	</h1>
</body>
</html>
