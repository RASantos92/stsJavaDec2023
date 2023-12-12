<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>
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
<h1>Edit user</h1>
<form:form action="/users/process/edit/${user_id}" method="post" modelAttribute="user">
				<input type="hidden" value="PATCH" name="_method"/>
				<form:hidden path="magazines"/>
				<form:hidden path="password"/>
				<form:input type="hidden" path="confirm" value="whatever"/>
				    <div class="form-group">
				        <label>User Name</label>
				        <form:input path="userName" class="form-control" />
				        <form:errors path="userName" class="text-danger" />
				    </div>
				    <div class="form-group">
				        <label>Email</label>
				        <form:input path="email" class="form-control" />
				        <form:errors path="email" class="text-danger" />
				    </div>

				    <input type="submit" value="Edit user" class="btn btn-primary" />
				</form:form>
				
	<h1>Your magazines</h1>
	<table class="table table-dark">
	  <thead>
	    <tr>
	      <th scope="col">Magazine Title</th>
	      <th scope="col">Added By</th>
	      <th>Action</th>
	
	    </tr>
	  </thead>
	  <tbody>
	    <c:forEach items="${user.magazines}" var="magazine">
	    <tr>
				<td><a href="/magazines/display/${magazine.id}">${magazine.title}</a></td>
				<td>${magazine.user.userName}</td>
				<td>
					<form action="/magazines/delete/${magazine.id}" method="POST">
						<input type="hidden" name="_method" value="DELETE"/>
						<input type="submit" value="Delete" class="btn btn-outline-danger"/>
					</form>
					
				</td>
	    </tr>
		</c:forEach>
	  </tbody>
	</table>
</body>
</html>