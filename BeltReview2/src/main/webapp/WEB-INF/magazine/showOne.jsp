<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome, <c:out value="${user.userName}"/></h1>
	<a href="/magazines/create">Add a magazine</a>
	<a href="/users/update/${user_id}">Account</a>
	<a href="/users/logout" class="btn btn-danger">Logout</a>
	
	<h1><c:out value="${magazine.title}"/></h1>
	
	<h4>Added by: <c:out value="${magazine.user.userName}"/></h4>
	
	<p>Description:</p>
	<p><c:out value="${magazine.description}"/></p>
	
	
</body>
</html>