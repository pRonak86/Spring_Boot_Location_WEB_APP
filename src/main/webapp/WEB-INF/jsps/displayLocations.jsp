<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Locations: </h1>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Code</th>
			<th>Name</th>
			<th>Type</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		
	<c:forEach items="${locations }" var="s">	
		<tr>
			<td>${s.id }</td>
			<td>${s.code }</td>
			<td>${s.name }</td>
			<td>${s.type }</td>
			<td><a href="editData?id=${s.id }">Edit</a>
			<td><a href="deletedata?id=${s.id }">Delete</a>
		</tr>
	</c:forEach>
	</table>
	<a href="showCreate">Add Record</a>
</body>
</html>