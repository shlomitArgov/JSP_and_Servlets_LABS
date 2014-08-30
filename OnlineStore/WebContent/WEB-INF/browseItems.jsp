<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@page import="online.store.core.StoreItems"%>
<%@page import="online.store.core.Item"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Store</title>
</head>
<body>
<%
String category = (String)request.getAttribute("category"); 
StoreItems items = (StoreItems)request.getServletContext().getAttribute("storeItems");
java.util.List<Item> itemsList = (java.util.List<Item>)items.getItemsByCategory(category);

%>
<h1 style="color: purple" align="center">Online Store</h1>
<hr>
<h2>Browses Items by Category</h2>
<br>
<h3>Category: <%=category%></h3>
<table>
	<thead>
		<tr>
			<th>Item</th>
			<th>Price</th>
		</tr>
	</thead>
	<tbody>
	<%
	for(int i = 0 ; i < itemsList.size() ; i++)
	%>
		<tr>
			<td><%=itemsList.get(i).getName %></td>
			<td><%=itemsList.get(i).getPrice %></td>
		</tr>
	</tbody>
</table>
</body>
</html>