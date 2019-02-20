<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Book List</title>
	<link href="../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
	<script src="../webjars/bootstrap/4.0.0/js/bootstrap.min.js "></script>
	<script src="../webjars/jquery/3.0.0/js/jquery.min.js "></script>
</head>
<body>
	<div class="container">
		<h2>Book List</h2>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="row">Book ID</th>
					<th scope="row">Book Name</th>
					<th scope="row">Publisher</th>
					<th scope="row">Author</th>
					<th scope="row">isIssued</th>
					<th scope="row">Edit by ID</th>
					<th scope="row">Edit by Name</th>
					<th scope="row">Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${book_list}" var="book" >
						<tr>
							<td>${book.bookID}</td>
							<td>${book.bookname}</td>
							<td>${book.publisher}</td>
							<td>${book.author}</td>
							<td>${book.issued}</td>
							<td>
								<spring:url value="/book/updateid/${book.bookID}" var="updateidURL" />
								<a class="btn btn-primary" href="${updateidURL }" role="button">UpdateByID</a>
							</td>
							<td>
								<spring:url value="/book/updatename/${book.bookname}" var="updatenameURL" />
								<a class="btn btn-primary" href="${updatenameURL }" role="button"> UpdateByName </a>
							</td>
							<td>
								<spring:url value="/book/delete/${book.bookID}" var="deleteURL" />
								<a class="btn btn-primary" href="${deleteURL }" role="button"> Delete</a>
							</td>
						</tr>
				</c:forEach>
			</tbody>
		</table>
		<spring:url value="/book/add" var="addURL" />
		<a class="btn btn-primary" href="${addURL }" role="button">Add new Book</a>
	</div>
</body>
</html>