<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/style.css"/>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 class="test">All Donations</h1>
	<c:forEach items="${allDonations}" var="donation">
		<p>Donation name: <c:out value="${donation.donationName }"/></p>
		<p>Donor name: <c:out value="${donation.donor }"/></p>
		<p>Quantity: <c:out value="${donation.quantity }"/></p>
	</c:forEach>
</body>
</html>