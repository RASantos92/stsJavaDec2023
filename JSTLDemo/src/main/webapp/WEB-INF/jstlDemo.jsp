<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>JSTL Demo</h1>
	
	<h1>Displaying Variables</h1>
	
	<p><c:out value="${nameFromController}"/></p>
	<p>${ageFromController}</p>
	<p><c:out value="${isHungryFromController}"/></p>
	
	
	<h1>if-statement</h1>
	
	<c:if test="${ isHungryFromController}">
		<p> <c:out value="${ nameFromController}"/> </p>
	</c:if>
	

    <h1>if-else statement</h1>
    
    <c:choose>
    	<c:when test="${ageFromController < 21 }">
    		<p><c:out value="${nameFromController}"/> is under 21 cannot drink yet</p>
    	</c:when>
    	<c:otherwise>
    		<p><c:out value="${nameFromController}"/> is over 21 can drink. have fun be safe</p>
    	</c:otherwise>
    
    </c:choose>

    <h1>for each</h1>
    <c:forEach items="${listOfUsersFromController}" var="user">
    	<p><c:out value="${user}"/></p>
    </c:forEach>
	
</body>
</html>


















