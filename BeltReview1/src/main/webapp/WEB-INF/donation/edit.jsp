<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Edit donation</h1>
	<form:form action="/donations/process/edit/${donation.id }" modelAttribute="donation" method="post">
		<input type="hidden" value="PATCH" name="_method"/>
        <form:hidden  path="donor"/>
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
        <input type="submit" value="Edit Donation" class="btn btn-primary"/>
     </form:form>
</body>
</html>