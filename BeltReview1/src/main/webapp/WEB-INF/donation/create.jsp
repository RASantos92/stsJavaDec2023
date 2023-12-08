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
	<h1>Add donation</h1>
	<form:form action="/donations/process/create" modelAttribute="donation" method="post">
        <form:input type="hidden" path="donor" value="${user_id}"/>
        <div>
            <form:label path="donationName" > Donation Name</form:label>
            <form:input type="text" path="donationName"/>
            <form:errors path="donationName"/>
        </div>
        <div>
            <form:label path="quantity" > Quantity</form:label>
            <form:input type="text" path="quantity"/>
            <form:errors path="quantity"/>
        </div>
        <input type="submit" value="Add Donation" class="btn btn-primary"/>
     </form:form>
        
</body>
</html>