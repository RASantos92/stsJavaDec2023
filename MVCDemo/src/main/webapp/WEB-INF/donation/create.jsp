<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  
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
<h1>Add Donation</h1>
<form:form action="/donations/process/new" method="post" modelAttribute="donation">
    <div class="form-group">
        <label>Donation Name</label>
        <form:input type="text" path="donationName" class="form-control" />
        <form:errors path="donationName"/>
    </div>
    <div class="form-group">
        <label>Quantity</label>
        <form:input type="number" path="quantity" class="form-control" />
        <form:errors path="quantity"/>
    </div>
    <div class="form-group">
        <label>Donor</label>
        <form:input type="text" path="donor" class="form-control" />
        <form:errors path="donor"/>
    </div>
    <input type="submit" value="Add Donation" class="btn btn-primary" />
</form:form>
</body>
</html>