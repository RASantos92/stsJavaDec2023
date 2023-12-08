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
	<h1>Show one Donation</h1>
	<p>Donation id: <c:out value="${donation.id}"/></p>
	<p>Donation Name: <c:out value="${donation.donationName}"/></p>
	<p>Quantity: <c:out value="${donation.quantity}"/></p>
	<p>Donor Name: <c:out value="${donation.donor.userName}"/></p>
</body>
</html>