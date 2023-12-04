<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>displaying from form</h1>
	<h2>Movie title: <c:out value="${movie }"/></h2>
	<h2>Movie rating: <c:out value="${rating }"/></h2>
	<h2>Movie comment: <c:out value="${comment }"/></h2>
</body>
</html>