<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="online.store.core.StoreItems"%>
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
<h2 align="center">Browse Store</h2>
<br>
<%
// Get store items from request attributes
StoreItems items = (StoreItems)request.getServletContext().getAttribute("storeItems");
String[] itemCategories = items.getCategories();
for(int i = 0; i < itemCategories.length; i++)
{
%>	
<a href="" command = "viewItemsByCategory" category = "<%=itemCategories[i]%>"><%=itemCategories[i]%></a>	
	
<% } %>

</body>
</html>