<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Online Store</title>
</head>
<body>
	<h1 style="color: purple" align="center">Online Store</h1>
	<hr>
	<h2 align="center">Hello ${username}!</h2>
	<br>
	<h3 align="center">Last visit: ${lastvisitAttr}</h3>
	<br>
	<div align="center">
		<a href="Controller?command=browseStore">Browse Store</a>
		<br>
		<a href="Controller?command=startShopping">Start Shopping</a>
	</div>
</body>
</html>