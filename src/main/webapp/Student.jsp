<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="Navbar.jsp" %>
</head>
<body>
<a href="StudentController?action=addstudent">Add Student</a>
<div class = "row justified-content-center">
<div class = "col-md-10">
		<h3 class="text-center">Student Details</h3>

	<div class="card">
	<c:if test="${!empty studentDetails}"></c:if>
	<table class="table">
			<thead>
				<tr>
				<th>ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Date of Birth</th>
				<th>Gender</th>
				<th>Email</th>
				<th>Phone</th>
				<th>Action</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${studentDetails}" var="student">
				<tr>
					<td><c:out value="${student.ID}"></c:out></td>
					<td><c:out value="${student.name}"></c:out></td>
					<td><c:out value="${student.lastname}"></c:out></td>
					<td><c:out value="${student.date_of_birth}"></c:out></td>
					<td><c:out value="${student.gender}"></c:out></td>
					<td><c:out value="${student.email}"></c:out></td>
					<td><c:out value="${student.phone}"></c:out></td>
					<th><a class= "btn btn-outline-danger" href="StudentController?action=delete&id=${student.ID}">Delete</a> | <a class= "btn btn-outline-warning"  href="StudentController?action=edit&id=${student.ID}">Edit</a> </th>
				</tr>
			</c:forEach>
			</tbody>
</table>
	</div>

</div>
	
</div>
</body>
</html>