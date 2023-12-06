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
<link rel="stylesheet" type="text/css" href="/css/style.css"/>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/donations/all">
		<input type="text" name="searchValue"/>
		<input class="btn btn-outline-primary" type="submit" value="Search"/>
	</form>
	<h1 class="test">All Donations</h1>
		<table class="table table-dark">
		  <thead>
		    <tr>
		      <th scope="col">Id</th>
		      <th scope="col">Donation name</th>
		      <th scope="col">Donor</th>
		      <th scope="col">Quantity</th>
		    </tr>
		  </thead>
			<c:forEach items="${allDonations}" var="donation">
		  		<tbody>
				 	<td> <c:out value ="${donation.id}"/></td>
				 	<td> <c:out value ="${donation.donationName}"/></td>
				 	<td> <c:out value ="${donation.donor}"/></td>
				 	<td> <c:out value ="${donation.quantity}"/></td>
		  		</tbody>
			</c:forEach>
		</table>
</body>
</html>