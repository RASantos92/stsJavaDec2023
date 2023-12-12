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
<h1>Add Magazine</h1>
<form:form action="/magazines/process/create" method="post" modelAttribute="magazine">
	<form:input type="hidden" path="user" value="${user_id}"/>
    <div class="form-group">
        <label>Title</label>
        <form:input path="title" class="form-control" />
        <form:errors path="title" class="text-danger" />
    </div>
    <div class="form-group">
        <label>Description</label>
        <form:input path="description" class="form-control" />
        <form:errors path="description" class="text-danger" />
    </div>
    <input type="submit" value="Add Magazine" class="btn btn-primary" />
</form:form>
</body>
</html>