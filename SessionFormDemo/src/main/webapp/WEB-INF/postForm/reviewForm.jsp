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
    <h1 class="styleTest"> Review Form </h1>
    <form action="/home/review/process" method="post">
    	<input type="hidden" value="Jacob Wayne" name="name"/>
        <div>
            <label style="color:blue"> Movie </label>
            <input type="text" name="movie"/>
        </div>
        <div>
            <label class="text-success"> Comment </label>
            <textarea name="comment"></textarea>
        </div>
        <div>
            <label> Rating </label>
            <input type="number" name="rating" placeholder="between 0 and 5"/>
            <p class="text-danger"><c:out value="${error}"/></p>
        </div>
            <input class="btn btn-outline-success" type="submit" value="Submit" />
    </form>
</body>
</html>