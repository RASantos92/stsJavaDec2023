<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Date"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% for(int i = 0; i < 5; i++){ %>
		<h1><%= i %></h1>
	<% } %>
	
	<p> The time and date is: <%= new Date() %>
	
</body>
</html>