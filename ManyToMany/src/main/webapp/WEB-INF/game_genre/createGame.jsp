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
<form:form action="/games/genres/process/create/game" method="post" modelAttribute="game">
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
    <div class="form-group">
        <label>Genres</label>
        <form:input path="formGenres" class="form-control" />
        <form:errors path="formGenres" class="text-danger" />
    </div>
    <input type="submit" value="Add game" class="btn btn-primary" />
</form:form>
</body>
</html>