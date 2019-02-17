<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"><html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Books</title>
	<link href="http://localhost:8080/webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
	<script src="http://localhost:8080/webjars/bootstrap/4.0.0/js/bootstrap.min.js "></script>
	<script src="http://localhost:8080/webjars/jquery/3.0.0/js/jquery.min.js "></script>
</head>
<body>
	<div class="container">
		<spring:url value="/book/save" var="saveURL" />
		<h2>Book</h2>
		<form:form modelAttribute="bookForm" method="post" action="${saveURL }" cssClass="form">
			<form:hidden path="bookID"/>
			<div class="form-group">
				<label for="bookname">BookName</label>
				<form:Input path="bookname" cssClass = "form-control" id="bookname" />
			</div>
			<div class="form-group">
				<label for="publisher">Publisher</label>
				<form:Input path="publisher" cssClass = "form-control" id="publisher" />
			</div>
			<div class="form-group">
				<label for="author">Author</label>
				<form:Input path="author" cssClass = "form-control" id="author" />
			</div>
			<div class="form-group">
				<label for="isIssued">isIssued</label>
				<form:Input path="isIssued" cssClass = "form-control" id="isIssued" />
			</div>
			<button type="submit" class="btn btn-primary">Save</button>
		</form:form>
	</div>
</body>
</html>