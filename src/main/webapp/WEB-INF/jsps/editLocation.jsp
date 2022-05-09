<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Locations</title>
</head>
<body>
	<h1>Update Form</h1>
	<form action="updateLoc" method="post">
		<table>
			<tr>
				<td>id</td>
				<td><input type="text" name="id" value="${location.id }" readonly></td>
			</tr>
			<tr>
				<td>Code</td>
				<td><input type="text" name="code" value="${location.code }"></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" value="${location.name } "></td>
			</tr>
			<tr>
				<td>Type</td>
				<td>Urban <input type="radio" name="type" value="Urban" ${location.type=='Urban'?'checked':'' }>
					Rural <input type="radio" name="type" value="Rural" ${location.type=='Rural'?'checked':'' }>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="save"></td>
			</tr>
		</table>
	</form>
	${msg }

	<a href="displayLocations">View All</a>
</body>
</html>