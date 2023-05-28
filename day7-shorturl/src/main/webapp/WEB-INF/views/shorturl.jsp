<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring 5 MVC -SHORT URL PROJECT</title>
</head>
<body>
	<h2>Enter the url</h2>
	<form:form id="mCodeForm" name="sdf" action="/telusko/shorturl"   method="post">
	<input type="text" name="url" value="${url}" id="url">
	<input type="submit" value="Submit">
	${shorturl}
	</form:form>
</body>
</html>