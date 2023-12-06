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
	<h1>One Donation</h1>
	
	<p>Donation name: <c:out value="${ oneDonation.donationName}"/></p>
	<p>Donor name: <c:out value="${ oneDonation.donor}"/></p>
	<p>Quantity: <c:out value="${ oneDonation.quantity}"/></p>
	
	<form action="/donations/delete/${oneDonation.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <input class ="btn btn-outline-danger" type="submit" value="Delete">
</form>
	
</body>
</html>