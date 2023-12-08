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
	<h1>Dashboard</h1>
	<a href="/users/logout" class="btn btn-outline-danger">Logout</a>
	<a href="/donations/create" class="btn btn-outline-success">Add donation</a>
	<h1>All Donations</h1>
	<table class="table table-dark">
  <thead>
    <tr>
      <th scope="col">id</th>
      <th scope="col">Donation name</th>
      <th scope="col">Quantity</th>
      <th scope="col">Donor Name</th>
      <th>Actions</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${allDonations}" var="donation">
    <tr>
			<td><c:out value="${donation.id}"/></td>
			<td><a href="/donations/display/${donation.id}"><c:out value="${donation.donationName}"/></a></td>
			<td><c:out value="${donation.quantity}"/></td>
			<td><c:out value="${donation.donor.userName}"/></td>
			<td>
			<c:if test="${donation.donor.id == user_id }">
				<a href="/donations/edit/${donation.id}" class="btn btn-outline-warning">Edit</a>
				<form action="/donations/delete/${donation.id}" method="post">
					<input type="hidden" name="_method" value="DELETE"/>
					<input type="submit" value="delete" class="btn btn-outline-danger"/>
				</form>
			</c:if>
			
			</td>
    </tr>
	</c:forEach>
  </tbody>
</table>
</body>
</html>